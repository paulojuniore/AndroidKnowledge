package com.paulojuniore.workout;

import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * A simple {@link ListFragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for(int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1, names);
        setListAdapter(listAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
