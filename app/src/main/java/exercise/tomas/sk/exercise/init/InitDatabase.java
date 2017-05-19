package exercise.tomas.sk.exercise.init;

import android.app.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import exercise.tomas.sk.exercise.bo.dao.Entry;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.bo.dao.Type;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by anx00283 on 18-May-17.
 */

public class InitDatabase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
                        String inputString1 = "23 04 2017";
                        String inputString2 = "10 04 2017";

                        Date date1 = new Date();
                        Date date2 = new Date();
                        try {
                            date1 = myFormat.parse(inputString1);
                            date2 = myFormat.parse(inputString2);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        Type type1 = realm.createObject(Type.class, "fb7475c0-2082-4702-adf5-1468ac2197c8");
                        type1.setValue("jedna");

                        Type type2 = realm.createObject(Type.class, "9e4776a5-f248-4565-a601-b500867d52bb");
                        type2.setValue("dva");

                        Entry entry1 = realm.createObject(Entry.class, "57a6a3ab-bba1-4885-a170-422731661b82");
                        entry1.setLevel(1);
                        entry1.setType(type1);
                        entry1.setName("value_1");

                        Entry entry2 = realm.createObject(Entry.class, "1e10f7ef-e96b-4b34-a7e5-1c7a4f20a579");
                        entry2.setLevel(3);
                        entry2.setType(type2);
                        entry2.setName("value_2");

                        Exercise exercise1 = realm.createObject(Exercise.class, "66f4760f-b745-4d9e-92c2-a93656b4f70a");
                        exercise1.setDate(date1);
                        exercise1.setEntry(entry1);
                        exercise1.setSeries(3);
                        exercise1.setRepetitions(30);

                        Exercise exercise2 = realm.createObject(Exercise.class, "8479d219-70bc-4897-a00f-30277b64308e");
                        exercise2.setDate(new Date());
                        exercise2.setEntry(entry2);
                        exercise2.setSeries(2);
                        exercise2.setRepetitions(25);

                        Exercise exercise3 = realm.createObject(Exercise.class, "85498204-bd6d-4777-98b6-e9eee693b295");
                        exercise3.setDate(date2);
                        exercise3.setEntry(entry2);
                        exercise3.setSeries(3);
                        exercise3.setRepetitions(50);

                        realm.insert(exercise1);
                        realm.insert(exercise2);
                        realm.insert(exercise3);
                    }
                }).build();

        Realm.setDefaultConfiguration(config);

    }

}
