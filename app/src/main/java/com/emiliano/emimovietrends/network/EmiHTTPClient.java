package com.emiliano.emimovietrends.network;

import android.util.Log;

import com.emiliano.emimovietrends.model.Movie;
import com.emiliano.emimovietrends.model.MovieResponse;

import java.util.ArrayList;

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

    public void getTrendingMovies(final HttpPopularMoviesListener listener, int page) {
        Call<MovieResponse> call = moviesService.getTrendingMovies(page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listener.onPopularMoviesRequestSuccess(response.body().getMovies());
                Log.d("request", "Success!");
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                listener.onPopularMoviesRequestFailed();
                Log.d("request", "Failure!");
            }
        });
    }

    public void getSimilarMovies(final HttpSimilarMoviesListener listener, int movieID, int page) {
        Call<MovieResponse> call = moviesService.getRelatedMovies(movieID, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listener.onSimilarMoviesRequestSuccess(response.body().getMovies());
                Log.d("request", "Success!");
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                listener.onRepositoriesSimilarMoviesRequestFailed();
                Log.d("request", "Failure!");
            }
        });
    }

    public interface HttpPopularMoviesListener{
        void onPopularMoviesRequestSuccess(ArrayList<Movie> movies);
        void onPopularMoviesRequestFailed();
    }
    public interface HttpSimilarMoviesListener{
        void onSimilarMoviesRequestSuccess(ArrayList<Movie> movies);
        void onRepositoriesSimilarMoviesRequestFailed();

    }
}
