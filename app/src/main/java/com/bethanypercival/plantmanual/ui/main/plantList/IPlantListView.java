package com.bethanypercival.plantmanual.ui.main.plantList;

import com.bethanypercival.plantmanual.model.PlantOverview;

import java.util.List;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public interface IPlantListView {

    void populateRecyclerView(List<PlantOverview> plantOverviewList);

    void openPlantDetails(String name);
}
