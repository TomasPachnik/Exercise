package exercise.tomas.sk.exercise.util;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import exercise.tomas.sk.exercise.bo.ExerciseDisplay;
import exercise.tomas.sk.exercise.bo.dao.Exercise;

/**
 * Created by anx00283 on 19-May-17.
 */

public class Util {

    private static final int MAX_PERCENTAGE = 100;

    public static List<ExerciseDisplay> order(List<Exercise> unordered) {
        List<ExerciseDisplay> result = new LinkedList<>();
        //add to list
        for (Exercise exercise : unordered) {
            Integer position = findPositionByName(result, exercise.getEntry().getName());
            if (position == null) {
                result.add(new ExerciseDisplay(exercise.getEntry().getName()));
            }
        }
        //set correct level
        for (Exercise exercise : unordered) {
            Integer position = findPositionByName(result, exercise.getEntry().getName());
            if (position != null) {
                if (result.get(position).getLevel() < exercise.getEntry().getLevel()) {
                    result.set(position, new ExerciseDisplay(exercise.getEntry().getName(), exercise.getSeries(), exercise.getRepetitions(), exercise.getEntry().getLevel()));
                }
            }
        }
        //set correct series and repetitions
        for (Exercise exercise : unordered) {
            Integer position = findPositionByName(result, exercise.getEntry().getName());
            if (position != null) {
                if (result.get(position).getLevel() == exercise.getEntry().getLevel()) {
                    if (result.get(position).getDate() == null || result.get(position).getDate().getTime() < exercise.getDate().getTime()) {
                        result.get(position).setDate(exercise.getDate());
                        result.get(position).setSeries(exercise.getSeries());
                        result.get(position).setRepetitions(exercise.getRepetitions());
                    }
                }
            }
        }
        //calculate date percentage
        for (Exercise exercise : unordered) {
            Integer position = findPositionByName(result, exercise.getEntry().getName());
            if (position != null) {
                if (result.get(position).getLevel() == exercise.getEntry().getLevel()) {
                    int days = calculateDays(exercise);
                    if (result.get(position).getDays() < days) {
                        if (days < MAX_PERCENTAGE) {
                            result.get(position).setDays(days);
                        } else {
                            result.get(position).setDays(MAX_PERCENTAGE);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static int calculateDays(Exercise exercise) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.MONTH, -1);
        Date lastMonth = cal.getTime();
        long totalDiff = today.getTime() - lastMonth.getTime();
        long totalDays = TimeUnit.DAYS.convert(totalDiff, TimeUnit.MILLISECONDS);
        long diff = today.getTime() - exercise.getDate().getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return (int) (days * MAX_PERCENTAGE / totalDays);
    }

    private static Integer findPositionByName(List<ExerciseDisplay> array, String name) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

}
