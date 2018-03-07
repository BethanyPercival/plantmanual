package com.bethanypercival.rxjavatestapp.networking;

import com.bethanypercival.rxjavatestapp.model.Plant;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bethanypercival on 07/03/2018.
 */

public class ApiRequest {

    Retrofit retrofit;

    private void sendRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mygarden.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Single<List<Plant>> getAllPlants() {
        NetworkTask networkTask = retrofit.create(NetworkTask.class);
        return networkTask.getAllPlants();
    }
}
