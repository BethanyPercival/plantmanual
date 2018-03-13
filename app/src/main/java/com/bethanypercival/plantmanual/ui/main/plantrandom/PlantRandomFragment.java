package com.bethanypercival.plantmanual.ui.main.plantrandom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bethanypercival.plantmanual.R;

/**
 * Created by bethanypercival on 13/03/2018.
 */

public class PlantRandomFragment extends Fragment {

    public PlantRandomFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_random, container, false);
        return rootView;
    }
}
