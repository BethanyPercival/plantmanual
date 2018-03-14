package com.bethanypercival.plantmanual.ui.plantdetailed;

import com.bethanypercival.plantmanual.model.PlantDetailed;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public interface IPlantDetailedView {
    void populateFields(PlantDetailed details);

    void showMoreDetails();

    void hideMoreDetails();
}
