package com.bethanypercival.rxjavatestapp.plantList;

import com.bethanypercival.rxjavatestapp.model.Plant;
import com.bethanypercival.rxjavatestapp.networking.ApiRequest;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class PlantListData {

    private ApiRequest apiRequest;

    PlantListData() {
        this.apiRequest = new ApiRequest();
    }

    public void getAllPlants(final IPlantListPresenter presenter) {
        apiRequest.getAllPlants()
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Plant>>() {
                    @Override
                    public void accept(List<Plant> plants) throws Exception {
                        presenter.onDataReady(plants);
                    }
                });

    }
}


