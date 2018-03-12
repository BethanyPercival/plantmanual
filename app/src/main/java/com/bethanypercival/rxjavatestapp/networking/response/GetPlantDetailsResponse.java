package com.bethanypercival.rxjavatestapp.networking.response;

import com.bethanypercival.rxjavatestapp.model.PlantDetailed;

import java.util.List;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public class GetPlantDetailsResponse {
    private List<PlantDetailed> results;

    public List<PlantDetailed> getPlantDetailedList() {
        return results;
    }

    public void setPlantDetailedList(List<PlantDetailed> plantDetailedList) {
        this.results = plantDetailedList;
    }
}
