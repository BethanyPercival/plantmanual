package com.bethanypercival.rxjavatestapp.networking;

import com.bethanypercival.rxjavatestapp.networking.response.GetAllPlantsResponse;
import com.bethanypercival.rxjavatestapp.networking.response.GetPlantDetailsResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class ApiRequest {

    Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://tropicalfruitandveg.com/api/tfvjsonapi.php/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    public Single<GetAllPlantsResponse> getAllPlants() {
        NetworkTask networkTask = retrofit.create(NetworkTask.class);
        return networkTask.getAllPlants();
    }

    public Single<GetPlantDetailsResponse> getPlantDetails(String name) {
        NetworkTask networkTask = retrofit.create(NetworkTask.class);
        return networkTask.getPlantDetails(name);
    }
}
