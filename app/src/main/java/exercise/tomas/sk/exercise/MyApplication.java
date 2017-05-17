package exercise.tomas.sk.exercise;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by anx00283 on 17-May-17.
 */

public class MyApplication extends Application {
    private static MyApplication application;
    private Realm realm;


    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration config = new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
        application = this;
    }

    public static MyApplication getApplication() {
        return application;
    }

    public Realm getRealm() {
        return realm;
    }

}
