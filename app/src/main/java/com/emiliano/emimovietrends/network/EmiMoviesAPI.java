package com.emiliano.emimovietrends.network;

import com.emiliano.emimovietrends.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by emiliano on 05/03/18.
 */

public interface EmiMoviesAPI {

    String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/popular?api_key=e9b2e70e0f6aaf295bdd8fb4b7a8ae57&language=en-US")
    Call<MovieResponse> getTrendingMovies(@Query("page") int page);

    @GET("movie/{movie_id}/similar?api_key=e9b2e70e0f6aaf295bdd8fb4b7a8ae57&language=en-US")
    Call<MovieResponse> getRelatedMovies(@Path("movie_id") int movieID,
                                         @Query("page") int page);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
