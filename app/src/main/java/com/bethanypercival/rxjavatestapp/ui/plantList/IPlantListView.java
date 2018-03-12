package com.bethanypercival.rxjavatestapp.ui.plantList;

import com.bethanypercival.rxjavatestapp.model.PlantOverview;

import java.util.List;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public interface IPlantListView {

    void populateRecyclerView(List<PlantOverview> plantOverviewList);

    void openPlantDetails(String name);
}
