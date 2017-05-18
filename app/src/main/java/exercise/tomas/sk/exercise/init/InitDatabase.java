package exercise.tomas.sk.exercise.init;

import android.app.Application;

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

        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        Type type1 = realm.createObject(Type.class);
                        type1.setId("fb7475c0-2082-4702-adf5-1468ac2197c8");
                        type1.setValue("jedna");

                        Type type2 = realm.createObject(Type.class);
                        type2.setId("9e4776a5-f248-4565-a601-b500867d52bb");
                        type2.setValue("dva");

                    }
                }).build();
        Realm.setDefaultConfiguration(config);
    }

}
