package exercise.tomas.sk.exercise.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.bo.ExerciseDisplay;
import exercise.tomas.sk.exercise.bo.dao.Exercise;
import exercise.tomas.sk.exercise.bo.dao.Type;

/**
 * Created by anx00283 on 17-May-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Exercise> exercises;
    private List<ExerciseDisplay> orderedExercises;

    public RecyclerAdapter(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.textView.setText(exercise.toString());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.row_text);
        }
    }

    private List<ExerciseDisplay> order(List<Exercise> unordered) {
        List<ExerciseDisplay> result = new LinkedList<>();
        for (Exercise exercise : unordered) {
            Integer value = findPositionByType(result, exercise.getEntry().getValue());
            if (value == null) {
                //add
                result.add(new ExerciseDisplay(exercise.getEntry().getValue(), exercise.getSeries(), exercise.getRepetitions(), exercise.getEntry().getLevel()));
            } else {
                //porovnaj a aktualizuj
                if (result.get(value).getLevel() < exercise.getEntry().getLevel()) {
                    result.set(value, new ExerciseDisplay(exercise.getEntry().getValue(), exercise.getSeries(), exercise.getRepetitions(), exercise.getEntry().getLevel()));
                }
            }
        }
        return result;
    }

    private Integer findPositionByType(List<ExerciseDisplay> array, String name) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

}
