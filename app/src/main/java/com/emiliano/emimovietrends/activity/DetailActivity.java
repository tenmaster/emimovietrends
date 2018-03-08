package com.emiliano.emimovietrends.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.emiliano.emimovietrends.R;
import com.emiliano.emimovietrends.adapters.MainMoviesAdapter;
import com.emiliano.emimovietrends.adapters.SimilarMoviesAdapter;
import com.emiliano.emimovietrends.listeners.EndlessRecyclerViewScrollListener;
import com.emiliano.emimovietrends.model.Movie;
import com.emiliano.emimovietrends.network.EmiHTTPClient;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements EmiHTTPClient.HttpSimilarMoviesListener{

    @BindView(R.id.detail_title_textview)
    TextView mTitleTextView;
    @BindView(R.id.detail_vote_average_textview)
    TextView mVoteAverageTextView;
    @BindView(R.id.detail_picture_imageview)
    ImageView mPictureImageView;
    @BindView(R.id.detail_release_date_textview)
    TextView mReleaseTextView;
    @BindView(R.id.detail_language_textview)
    TextView mLanguageTextView;
    @BindView(R.id.detail_description_textview)
    TextView mDescriptionTextView;

    @BindView(R.id.detail_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        loadViews((Movie) getIntent().getExtras().get("Movie"));
        setupAdapter();
    }

    private void loadViews(Movie movie) {
        mTitleTextView.setText(movie.getTitle());
        mVoteAverageTextView.setText(String.valueOf(getString(R.string.detail_average) + movie.getVoteAverage()));

        Glide.with(this).load("http://image.tmdb.org/t/p/w500/" + movie.getPosterPath() ).into(mPictureImageView); // I could have used Picasso also

        mReleaseTextView.setText(getString(R.string.detail_release_date) + movie.getReleaseDate());
        mLanguageTextView.setText(getString(R.string.detail_language) + movie.getOriginalLanguage());
        mDescriptionTextView.setText(movie.getOverview());

        EmiHTTPClient.getInstance().getSimilarMovies(this, movie.getID(), 1);
    }

    private void setupAdapter() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }


    @Override
    public void onSimilarMoviesRequestSuccess(ArrayList<Movie> movies) {
        mRecyclerView.setAdapter(new SimilarMoviesAdapter(this, movies));
        mRecyclerView.getAdapter().notifyDataSetChanged();
        Toast.makeText(this, getString(R.string.success_loading_movies), Toast.LENGTH_SHORT).show();
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSimilarMoviesRequestFailed() {
        Toast.makeText(this, getString(R.string.error_loading_movies), Toast.LENGTH_SHORT).show();
    }
}
