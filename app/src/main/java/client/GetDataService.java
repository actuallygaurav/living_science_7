package client;


import model.RootModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {
    @GET("/2d0d29b1cfee91b0b605/{chapterIndex}")
    Call<RootModel> getWeather(@Path("chapterIndex") int chapterIndex);
}
