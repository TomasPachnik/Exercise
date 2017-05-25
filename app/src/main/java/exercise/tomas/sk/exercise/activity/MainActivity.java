package exercise.tomas.sk.exercise.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
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
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.adapter.RecyclerAdapter;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.util.Util;
import io.realm.Realm;
import io.realm.RealmResults;

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
    }

    @Override
    public void onResume() {
        super.onResume();
        load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void load() {
        RealmResults<Exercise> all = realm.where(Exercise.class).findAll();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.invalidate();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(all));
    }

    private void writeToFile(String data, Context context) {

        if (Util.isExternalStorageWritable()) {
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root + "/exercise");
            myDir.mkdirs();
            String fileName = "database.json";
            File file = new File(myDir, fileName);
            if (file.exists()) file.delete();
            try {
                FileOutputStream out = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(out);
                pw.print(data);
                pw.flush();
                pw.close();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "Pamat nie je pristupna!", Toast.LENGTH_LONG).show();
        }
    }

    public void onFabeClicked(View view) {
        Intent myIntent = new Intent(MainActivity.this, NewExerciseActivity.class);
        startActivity(myIntent);
    }

    public void importOnClick(MenuItem item) {
        String response = readFile("/exercise", "database.json");
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Exercise>>() {
        }.getType();
        final List<Exercise> exercises = gson.fromJson(response, collectionType);

        realm.executeTransactionAsync(new Realm.Transaction() {
            public void execute(Realm realm) {
                realm.delete(Exercise.class);
                realm.insertOrUpdate(exercises);
            }
        });
        Toast.makeText(context, "Data nacitane" + "", Toast.LENGTH_LONG).show();
        finish();
        startActivity(getIntent());
    }

    public void exportOnClick(MenuItem item) {
        new AsyncTaskRunner().execute();
    }

    private class AsyncTaskRunner extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            Realm realm = Realm.getDefaultInstance();
            List<Exercise> all = realm.where(Exercise.class).findAll();
            all = realm.copyFromRealm(all);
            String json = new Gson().toJson(all);
            realm.close();
            return json;
        }

        protected void onPostExecute(String result) {
            writeToFile(result, context);
            Toast.makeText(context, "Data ulozene", Toast.LENGTH_LONG).show();
        }
    }

    private String readFile(String path, String fileName) {
        try {
            FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + path + "/" + fileName);
            StringBuilder fileContent = new StringBuilder("");

            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, n));
            }
            fis.close();
            return fileContent.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
