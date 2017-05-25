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
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (level != entry.level) return false;
        if (id != null ? !id.equals(entry.id) : entry.id != null) return false;
        if (type != null ? !type.equals(entry.type) : entry.type != null) return false;
        return name != null ? name.equals(entry.name) : entry.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + level;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
