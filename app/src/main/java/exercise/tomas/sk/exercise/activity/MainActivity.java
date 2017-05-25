package exercise.tomas.sk.exercise.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.adapter.RecyclerAdapter;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.util.Util;
import io.realm.Realm;
import io.realm.RealmResults;
import sk.tomas.jsonConverter.core.Core;

public class MainActivity extends BaseActivity {

    private Context context;

    public MainActivity() {
        this.context = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(myToolbar);

        load();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NewExerciseActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem action_import = menu.findItem(R.id.action_import);
        MenuItem action_export = menu.findItem(R.id.action_export);

        action_import.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(context, "Import", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        action_export.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                new AsyncTaskRunner().execute();
                return true;
            }
        });

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void load() {
        RealmResults<Exercise> all = realm.where(Exercise.class).findAll();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(all));

    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("database.json", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private class AsyncTaskRunner extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            Realm realm = Realm.getDefaultInstance();

            List<Exercise> all = realm.where(Exercise.class).findAll();

            all = realm.copyFromRealm(all);

            String json = new Gson().toJson(all);

            Log.d("json: ", json);

            realm.close();

            return json;
        }

        protected void onPostExecute(String result) {
            writeToFile(result, context);
            Toast.makeText(context, "data exported", Toast.LENGTH_LONG).show();
        }

    }

}
