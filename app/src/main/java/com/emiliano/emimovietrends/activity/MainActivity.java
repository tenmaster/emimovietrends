package com.emiliano.emimovietrends.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.emiliano.emimovietrends.R;
import com.emiliano.emimovietrends.model.Movie;
import com.emiliano.emimovietrends.network.EmiHTTPClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EmiHTTPClient.HttpPopularMoviesListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmiHTTPClient.getInstance().getTrendingMovies(this, 1);
    }

    @Override
    public void onPopularMoviesRequestSuccess(ArrayList<Movie> movies) {
        Toast.makeText(this, getString(R.string.success_loading_movies), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPopularMoviesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_movies), Toast.LENGTH_SHORT).show();
    }
}
