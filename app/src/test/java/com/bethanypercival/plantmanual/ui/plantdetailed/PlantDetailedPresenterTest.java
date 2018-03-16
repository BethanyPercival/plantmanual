package com.bethanypercival.plantmanual.ui.plantdetailed;

import android.content.Context;

import com.bethanypercival.plantmanual.model.PlantDetailed;
import com.bethanypercival.plantmanual.networking.response.GetPlantDetailsResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bethanypercival on 15/03/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class PlantDetailedPresenterTest {

    private static final String NAME = "Banana";
    private static final String READ_MORE = "Read More";
    private static final String READ_LESS = "Read Less";

    @Mock
    private IPlantDetailedView mockView;
    @Mock
    private PlantDetailedData mockData;
    @Mock
    private GetPlantDetailsResponse mockGetPlantDetailsResponse;
    @Mock
    private PlantDetailed plantDetailed;
    @Mock
    private Context context;

    private PlantDetailedPresenter presenter;

    @Before
    public void testSetup() {
        presenter = new PlantDetailedPresenter(mockView, mockData);
    }

    @Test
    public void shouldCallGetPlantDetails_whenOnViewReadyIsCalled() {
        presenter.onViewReady(NAME);

        verify(mockData).getPlantDetails(NAME, presenter);
    }

    @Test
    public void shouldCallPopulateFields_whenOnDataReadyIsCalled() {
        List<PlantDetailed> list = new ArrayList<>();
        list.add(plantDetailed);

        when(mockGetPlantDetailsResponse.getPlantDetailedList()).thenReturn(list);
        presenter.onDataReady(mockGetPlantDetailsResponse);
        verify(mockView).populateFields(plantDetailed);
    }

    @Test
    public void shouldCallShowMoreDetails_whenReadMore() {
        presenter.readMoreClicked(READ_MORE, context);

        verify(mockView).showMoreDetails();
    }

    @Test
    public void shouldCallHideMoreDetails_whenReadLess() {
        presenter.readMoreClicked(READ_LESS, context);

        verify(mockView).hideMoreDetails();
    }
}