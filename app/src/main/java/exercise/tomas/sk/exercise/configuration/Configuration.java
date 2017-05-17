package exercise.tomas.sk.exercise.configuration;

import exercise.tomas.sk.exercise.MyApplication;
import io.realm.Realm;
import sk.tomas.servant.annotation.Bean;
import sk.tomas.servant.annotation.Config;

/**
 * Created by anx00283 on 17-May-17.
 */

@Config
public class Configuration {

    @Bean
    public Realm realm() {
        MyApplication application = MyApplication.getApplication();
        return application.getRealm();
    }

}
