package com.bethanypercival.plantmanual.ui.plantList;

import android.content.Context;

import com.bethanypercival.plantmanual.model.PlantOverview;
import com.bethanypercival.plantmanual.networking.response.GetAllPlantsResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bethanypercival on 16/03/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlantListPresenterTest {

    @Mock
    private IPlantListView mockView;
    @Mock
    private PlantListData mockData;
    @Mock
    private IPlantListPresenter mockPresenter;
    @Mock
    private Context context;
    @Mock
    private GetAllPlantsResponse getAllPlantsResponse;
    @Mock
    private PlantOverview plantOverview;

    @Before
    public void setUp() {
        mockPresenter = new PlantListPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetAllPlants_whenOnViewReadyIsCalled() {
        mockPresenter.onViewReady();

        verify(mockData).getAllPlants(mockPresenter);
    }

    @Test
    public void shouldCallPopulateRecyclerView_whenOnDataReadyIsCalled() {
        ArrayList<PlantOverview> plantOverviewArrayList = new ArrayList<>();
        plantOverviewArrayList.add(plantOverview);
        when(GetAllPlantsResponse)

        mockPresenter.onDataReady(getAllPlantsResponse);

        verify(mockView).populateRecyclerView();
    }

}