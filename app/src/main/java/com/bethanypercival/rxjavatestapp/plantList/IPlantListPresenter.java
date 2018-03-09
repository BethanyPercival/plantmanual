package com.bethanypercival.rxjavatestapp.plantList;

import com.bethanypercival.rxjavatestapp.model.PlantOverview;

import java.util.List;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public interface IPlantListPresenter {

    void onViewReady();

    void onDataReady(List<PlantOverview> plantOverviews);
}
