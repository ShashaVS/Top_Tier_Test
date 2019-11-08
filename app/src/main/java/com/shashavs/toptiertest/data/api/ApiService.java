package com.shashavs.toptiertest.data.api;

import com.shashavs.toptiertest.data.entity.Uiname;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api")
    Single<Response<List<Uiname>>> getUinames(
            @Query("amount") String amount,
            @Query("gender") String gender,
            @Query("ext") String ext);
}
