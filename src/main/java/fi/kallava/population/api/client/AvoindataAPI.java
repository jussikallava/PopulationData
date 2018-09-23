package fi.kallava.population.api.client;

import java.util.List;

import fi.kallava.population.domain.Occupation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AvoindataAPI {

    @GET("municipalities/")
    Call<List<Occupation>> loadOccupations(@Query("q") String status);
}