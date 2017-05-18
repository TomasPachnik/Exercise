package exercise.tomas.sk.exercise;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import sk.tomas.servant.core.Core;

/**
 * Created by anx00283 on 17-May-17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }

}
