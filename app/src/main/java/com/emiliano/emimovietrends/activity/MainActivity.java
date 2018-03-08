package com.emiliano.emimovietrends.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.emiliano.emimovietrends.R;
import com.emiliano.emimovietrends.adapters.MainMoviesAdapter;
import com.emiliano.emimovietrends.listeners.EndlessRecyclerViewScrollListener;
import com.emiliano.emimovietrends.model.Movie;
import com.emiliano.emimovietrends.network.EmiHTTPClient;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements EmiHTTPClient.HttpPopularMoviesListener {

    @BindView(R.id.main_activity_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.main_activity_progress_bar)
    ProgressBar mProgressBar;

    private EndlessRecyclerViewScrollListener scrollListener;
    private ArrayList<Movie> moviesArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupAdapter();
        loadMovies(1);
    }

    private void setupAdapter() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadMovies(++page);
            }
        };
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(scrollListener);
    }

    private void loadMovies(int page) {
        mProgressBar.setVisibility(View.VISIBLE);
        EmiHTTPClient.getInstance().getTrendingMovies(this, page);
    }

    @Override
    public void onPopularMoviesRequestSuccess(ArrayList<Movie> movies) {

        moviesArraylist.addAll(movies);

        if(mRecyclerView.getAdapter() == null){
            mRecyclerView.setAdapter(new MainMoviesAdapter(this, moviesArraylist));
        }

        mRecyclerView.getAdapter().notifyDataSetChanged();
        Toast.makeText(this, getString(R.string.success_loading_movies), Toast.LENGTH_SHORT).show();
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPopularMoviesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_movies), Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.GONE);
    }
}
