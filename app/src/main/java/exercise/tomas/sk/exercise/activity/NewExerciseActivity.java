package exercise.tomas.sk.exercise.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.bo.dao.Type;
import io.realm.RealmResults;

/**
 * Created by anx00283 on 23-May-17.
 */

public class NewExerciseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new);

        EditText editText = (EditText) findViewById(R.id.new_date);
        NumberPicker series = (NumberPicker) findViewById(R.id.new_series);
        NumberPicker repetitions = (NumberPicker) findViewById(R.id.new_repetitions);
        Spinner exercises = (Spinner) findViewById(R.id.new_exercises);
        final Button confirm = (Button) findViewById(R.id.new_confirm);

        SimpleDateFormat sdf = new SimpleDateFormat("dd. MM. yyyy");
        editText.setText(sdf.format(new Date()));
        series.setMinValue(1);
        series.setMaxValue(5);
        repetitions.setMinValue(10);
        repetitions.setMaxValue(50);

        RealmResults<Type> all = realm.where(Type.class).findAll();
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List) all);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercises.setAdapter(adp1);

        final Context context = this;

        confirm.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context, "Clicked on Button", Toast.LENGTH_LONG).show();
                   finish();
               }
           }
        );
    }

}
