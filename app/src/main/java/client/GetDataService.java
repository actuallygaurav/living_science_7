package client;


import model.RootModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {
    @GET("/823369a5f4c1129a4c31/{chapterIndex}")
    Call<RootModel> getWeather(@Path("chapterIndex") int chapterIndex);
}
