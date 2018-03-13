package com.bethanypercival.plantmanual.networking.response;

import com.bethanypercival.plantmanual.model.PlantOverview;

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
