package exercise.tomas.sk.exercise.init;

import android.app.Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import exercise.tomas.sk.exercise.bo.dao.Entry;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.bo.dao.Type;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;

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

                        int typeCount = 6;
                        int entryCount = typeCount * 10;

                        Type[] types = new Type[typeCount];

                        for (int i = 0; i < typeCount; i++) {
                            types[i] = createObject(realm, Type.class);
                        }

                        types[0].setValue("kliky");
                        types[1].setValue("drepy");
                        types[2].setValue("zhyby");
                        types[3].setValue("zdvihy nóh");
                        types[4].setValue("mostíky");
                        types[5].setValue("kliky v stojke");

                        Entry[] entries = new Entry[entryCount];

                        for (int i = 0; i < entryCount; i++) {
                            entries[i] = createObject(realm, Entry.class);
                            entries[i].setType(types[i / 10]);
                            entries[i].setLevel((i % 10) + 1);
                        }

                        realm.insert(Arrays.asList(types));
                        realm.insert(Arrays.asList(entries));

                    }
                }).build();

        Realm.setDefaultConfiguration(config);

    }

    private <E extends RealmModel> E createObject(Realm realm, Class<E> clazz) {
        return realm.createObject(clazz, UUID.randomUUID().toString());
    }

}
