package com.emiliano.emimovietrends.network;

import com.emiliano.emimovietrends.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by emiliano on 05/03/18.
 */

public class EmiHTTPClient {

    private static EmiHTTPClient instance;
    private static EmiMoviesAPI moviesService;

    public static EmiHTTPClient getInstance() {
        if (instance == null) {
            instance = new EmiHTTPClient();
            start();
        }
        return instance;
    }

    private static void start() {
        moviesService = EmiMoviesAPI.retrofit.create(EmiMoviesAPI.class);
    }

    private static void getTrendingMovies(int page) {
        Call<List<MovieResponse>> call = moviesService.getTrendingMovies(page);
        call.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {

            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {

            }
        });
    }

    private static void getSimilarMovies(int movieID, int page) {
        Call<List<MovieResponse>> call = moviesService.getRelatedMovies(movieID, page);
        call.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {

            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {

            }
        });
    }
}
