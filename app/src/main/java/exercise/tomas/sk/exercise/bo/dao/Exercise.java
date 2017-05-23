package exercise.tomas.sk.exercise.bo.dao;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anx00283 on 18-May-17.
 */

public class Exercise extends RealmObject {

    @PrimaryKey
    private String id;
    private Entry entry;
    private int series;
    private int repetitions;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id='" + id + '\'' +
                ", entry=" + entry +
                ", series=" + series +
                ", repetitions=" + repetitions +
                ", date=" + date +
                '}';
    }
}
