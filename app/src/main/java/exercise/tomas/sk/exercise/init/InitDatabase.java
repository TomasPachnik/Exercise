package exercise.tomas.sk.exercise.init;

import android.app.Application;

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

                        Type type1 = realm.createObject(Type.class, "fb7475c0-2082-4702-adf5-1468ac2197c8");
                        type1.setValue("jedna");

                        Type type2 = realm.createObject(Type.class, "9e4776a5-f248-4565-a601-b500867d52bb");
                        type2.setValue("dva");

                        Entry entry1 = realm.createObject(Entry.class, "57a6a3ab-bba1-4885-a170-422731661b82");
                        entry1.setLevel(1);
                        entry1.setType(type1);
                        entry1.setValue("value_1");

                        Exercise exercise1 = realm.createObject(Exercise.class, "66f4760f-b745-4d9e-92c2-a93656b4f70a");
                        exercise1.setDate(new Date());
                        exercise1.setEntry(entry1);
                        exercise1.setSeries(3);
                        exercise1.setRepetitions(30);
                        realm.insert(exercise1);
                    }
                }).build();

        Realm.setDefaultConfiguration(config);

    }

}
