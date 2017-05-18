package exercise.tomas.sk.exercise.bo.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anx00283 on 17-May-17.
 */

public class Type extends RealmObject {

    @PrimaryKey
    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
