package com.bethanypercival.rxjavatestapp.plantList;

import com.bethanypercival.rxjavatestapp.model.Plant;

import java.util.List;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public interface IPlantListPresenter {

    void onViewReady();

    void onDataReady(List<Plant> plants);
}
