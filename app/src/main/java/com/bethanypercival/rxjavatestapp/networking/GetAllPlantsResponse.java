package com.bethanypercival.rxjavatestapp.networking;

import com.bethanypercival.rxjavatestapp.model.PlantOverview;

import java.util.List;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public class GetAllPlantsResponse {
    private List<PlantOverview> results;

    public List<PlantOverview> getResults() {
        return results;
    }

    public void setResults(List<PlantOverview> results) {
        this.results = results;
    }
}
