package exercise.tomas.sk.exercise.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.bo.dao.Entry;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.bo.dao.Type;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by anx00283 on 23-May-17.
 */

public class NewExerciseActivity extends BaseActivity {

    private EditText dateEditText;
    private Calendar myCalendar;
    private Button confirm;
    private NumberPicker series;
    private NumberPicker repetitions;
    private NumberPicker level;
    private Spinner exercises;
    private SimpleDateFormat sdf;
    private Context context;
    private DatePickerDialog.OnDateSetListener date;


    public NewExerciseActivity() {
        this.sdf = new SimpleDateFormat("dd. MM. yyyy");
        this.myCalendar = Calendar.getInstance();
        this.context = this;
        init();
    }


    private void init() {
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
    }

    private void setListeners() {
        confirm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Type type = (Type) exercises.getSelectedItem();
                        RealmResults<Entry> resultList = realm
                                .where(Entry.class)
                                .equalTo("level", level.getValue())
                                .equalTo("type.id", type.getId())
                                .findAll();

                        if (resultList.size() == 1) {
                            final Exercise exercise = new Exercise();
                            exercise.setEntry(resultList.get(0));

                            Date myDate = new Date();
                            try {
                                myDate = sdf.parse(dateEditText.getText().toString());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            exercise.setId(UUID.randomUUID().toString());
                            exercise.setDate(myDate);
                            exercise.setSeries(series.getValue());
                            exercise.setRepetitions(repetitions.getValue());

                            realm.executeTransactionAsync(new Realm.Transaction() {
                                public void execute(Realm realm) {
                                    realm.insertOrUpdate(exercise);
                                }
                            });

                            Toast.makeText(context, "Uložené", Toast.LENGTH_LONG).show();
                        }

                        finish();
                    }
                }
        );

        dateEditText.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(
                                NewExerciseActivity.this, date, myCalendar
                                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        findByViewId();
        setListeners();
        inicialize();

        RealmResults<Type> all = realm.where(Type.class).findAll();
        ArrayAdapter<String> adp1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List) all);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exercises.setAdapter(adp1);
    }

    private void updateLabel() {
        dateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    private void findByViewId() {
        dateEditText = (EditText) findViewById(R.id.new_date);
        series = (NumberPicker) findViewById(R.id.new_series);
        level = (NumberPicker) findViewById(R.id.new_level);
        repetitions = (NumberPicker) findViewById(R.id.new_repetitions);
        exercises = (Spinner) findViewById(R.id.new_exercises);
        confirm = (Button) findViewById(R.id.new_confirm);
    }

    private void inicialize() {
        dateEditText.setText(sdf.format(new Date()));
        level.setMinValue(1);
        level.setMaxValue(10);
        series.setMinValue(1);
        series.setMaxValue(5);
        repetitions.setMinValue(10);
        repetitions.setMaxValue(50);
    }

}
