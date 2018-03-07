package com.bethanypercival.rxjavatestapp.networking;

import com.bethanypercival.rxjavatestapp.model.Plant;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by bethanypercival on 07/03/2018.
 */

interface NetworkTask {

    @GET("plants/all")
    Single<List<Plant>> getAllPlants();
}
