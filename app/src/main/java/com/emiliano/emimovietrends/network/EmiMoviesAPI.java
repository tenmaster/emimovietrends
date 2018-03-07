package com.emiliano.emimovietrends.network;

import com.emiliano.emimovietrends.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by emiliano on 05/03/18.
 */

public interface EmiMoviesAPI {

    String BASE_URL = "https://api.themoviedb.org/3";
    String API_KEY = "e9b2e70e0f6aaf295bdd8fb4b7a8ae57";

    @GET("/tv/popular?api_key="+API_KEY+"&language=en-US&page={page}\n")
    Call<MovieResponse> getTrendingMovies(@Path("page") int page);

    @GET("/tv/{movie_id}/similar?"+API_KEY+"={api_key}&language=en-US&page={page}")
    Call<MovieResponse> getRelatedMovies(@Path("movie_id") int movieID,
                                               @Path("page") int page);

            Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                        .build();
}
