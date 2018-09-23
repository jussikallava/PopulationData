package fi.kallava.population.api.client;

import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fi.kallava.population.domain.Occupation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OccupationClientController implements Callback<List<Occupation>> {

    static final String BASE_URL = "http://gis.vantaa.fi/rest/tyopaikat/v1/kaikki";

    public void start() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        AvoindataAPI avoindataAPI = retrofit.create(AvoindataAPI.class);

        Call<List<Occupation>> call = avoindataAPI.loadOccupations("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Occupation>> call, Response<List<Occupation>> response) {
        if (response.isSuccessful()) {
            List<Occupation> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.getName()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Occupation>> call, Throwable t) {
        t.printStackTrace();
    }
}