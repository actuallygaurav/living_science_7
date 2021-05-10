package com.learn.livingscienceclass6;


import com.learn.livingscienceclass6.model.RootModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {
    String API_KEY = "f78ee147a41d739b576a386766bf56a1";
    String UNITS = "metric";
    @GET("/2d0d29b1cfee91b0b605/{chapterIndex}")
    Call<RootModel> getWeather(@Path("chapterIndex") int chapterIndex);
}
