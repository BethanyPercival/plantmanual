package com.bethanypercival.plantmanual.networking;

import com.bethanypercival.plantmanual.networking.response.GetAllPlantsResponse;
import com.bethanypercival.plantmanual.networking.response.GetPlantDetailsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bethanypercival on 07/03/2018.
 */

interface NetworkTask {

    @GET("?search=all")
    Single<GetAllPlantsResponse> getAllPlants();

    @GET("?")
    Single<GetPlantDetailsResponse> getPlantDetails(@Query("tfvitem") String name);
}
