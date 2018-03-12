package com.bethanypercival.rxjavatestapp.ui.plantList;

import com.bethanypercival.rxjavatestapp.networking.response.GetAllPlantsResponse;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public interface IPlantListPresenter {

    void onViewReady();

    void onDataReady(GetAllPlantsResponse plantOverviews);

    void onListItemClicked(String name);
}
