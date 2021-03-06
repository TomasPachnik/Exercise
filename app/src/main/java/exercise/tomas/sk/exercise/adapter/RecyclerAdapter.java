package exercise.tomas.sk.exercise.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import exercise.tomas.sk.exercise.R;
import exercise.tomas.sk.exercise.activity.DetailActivity;
import exercise.tomas.sk.exercise.activity.MainActivity;
import exercise.tomas.sk.exercise.activity.NewExerciseActivity;
import exercise.tomas.sk.exercise.bo.ExerciseDisplay;
import exercise.tomas.sk.exercise.bo.dao.Exercise;

import static exercise.tomas.sk.exercise.util.Util.order;

/**
 * Created by anx00283 on 17-May-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<ExerciseDisplay> orderedExercises;

    public RecyclerAdapter(List<Exercise> exercises) {
        orderedExercises = order(exercises);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ExerciseDisplay exerciseDisplay = orderedExercises.get(position);
        holder.textView.setText(exerciseDisplay.getText());
        holder.progressBar.setProgress(exerciseDisplay.getDays());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), DetailActivity.class);
                myIntent.putExtra("name", exerciseDisplay.getName());
                v.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderedExercises.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.row_text);
            progressBar = (ProgressBar) itemView.findViewById(R.id.row_progressBar);
        }
    }

}
