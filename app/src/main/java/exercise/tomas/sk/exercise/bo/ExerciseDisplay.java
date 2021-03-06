package exercise.tomas.sk.exercise.bo;

import java.util.Date;

/**
 * Created by anx00283 on 18-May-17.
 */

public class ExerciseDisplay {
    //exercise name
    private String name;
    //last series and repetitions
    private int series;
    private int repetitions;
    //exercise level
    private int level;
    //percentual days
    private int days;
    //help to find last series and repetitions
    private Date date;

    public ExerciseDisplay(String name) {
        this.name = name;
    }

    public ExerciseDisplay(String name, int series, int repetitions, int level) {
        this.name = name;
        this.series = series;
        this.repetitions = repetitions;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExerciseDisplay{" +
                "name='" + name + '\'' +
                ", series=" + series +
                ", repetitions=" + repetitions +
                ", level=" + level +
                ", days=" + days +
                '}';
    }

    public String getText() {
        return name + " level " + level + "\n" +
                series + "x" + repetitions;
    }

}
