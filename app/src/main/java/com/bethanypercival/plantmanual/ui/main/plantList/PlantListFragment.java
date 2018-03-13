package com.bethanypercival.plantmanual.ui.main.plantList;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.model.PlantOverview;
import com.bethanypercival.plantmanual.ui.main.PlantListData;
import com.bethanypercival.plantmanual.ui.plantdetailed.PlantDetailedActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantListFragment extends Fragment implements IPlantListView {

    public static final String EXTRA_NAME = "com.bethanypercival.rxjavatestapp.ui.plantlist.name";

    private IPlantListPresenter presenter;
    private PlantListRecyclerAdapter adapter;
    private List<PlantOverview> plantOverviewList;

    @BindView(R.id.recyclerViewAllPlants)
    RecyclerView recyclerViewAllPlants;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_plant_list, container, false);
        ButterKnife.bind(this, rootView);
        initialiseFragment();
        return rootView;
    }

    private void initialiseFragment() {
        setUpRecyclerView();
        presenter = new PlantListPresenter(this, new PlantListData());
        presenter.onViewReady();
    }

    private void setUpRecyclerView() {
        adapter = new PlantListRecyclerAdapter(plantOverviewList, presenter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewAllPlants.setLayoutManager(layoutManager);
        recyclerViewAllPlants.setAdapter(adapter);
    }

    @Override
    public void populateRecyclerView(final List<PlantOverview> plantOverviewList) {
        this.plantOverviewList = plantOverviewList;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerViewAllPlants.setAdapter(new PlantListRecyclerAdapter(plantOverviewList, presenter));
            }
        });
    }

    @Override
    public void openPlantDetails(String name) {
        Intent intent = new Intent(getActivity(), PlantDetailedActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}
