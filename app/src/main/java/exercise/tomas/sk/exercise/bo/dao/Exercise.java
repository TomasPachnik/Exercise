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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (series != exercise.series) return false;
        if (repetitions != exercise.repetitions) return false;
        if (id != null ? !id.equals(exercise.id) : exercise.id != null) return false;
        if (entry != null ? !entry.equals(exercise.entry) : exercise.entry != null) return false;
        return date != null ? date.equals(exercise.date) : exercise.date == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        result = 31 * result + series;
        result = 31 * result + repetitions;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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
