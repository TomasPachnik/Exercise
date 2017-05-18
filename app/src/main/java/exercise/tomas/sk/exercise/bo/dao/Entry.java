package exercise.tomas.sk.exercise.bo.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anx00283 on 18-May-17.
 */

public class Entry extends RealmObject {

    @PrimaryKey
    private String id;
    private int level;
    private Type type;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
