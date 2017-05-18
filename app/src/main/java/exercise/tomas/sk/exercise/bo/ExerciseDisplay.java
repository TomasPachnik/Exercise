package exercise.tomas.sk.exercise.bo;

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
}
