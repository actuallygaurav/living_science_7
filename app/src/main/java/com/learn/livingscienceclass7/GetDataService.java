package com.learn.livingscienceclass7;


import com.learn.livingscienceclass7.model.RootModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {
    String API_KEY = "f78ee147a41d739b576a386766bf56a1";
    String UNITS = "metric";
    @GET("/823369a5f4c1129a4c31/{chapterIndex}")
    Call<RootModel> getWeather(@Path("chapterIndex") int chapterIndex);
}
