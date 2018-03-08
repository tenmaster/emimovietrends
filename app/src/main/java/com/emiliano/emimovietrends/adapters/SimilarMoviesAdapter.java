package com.emiliano.emimovietrends.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.emiliano.emimovietrends.R;
import com.emiliano.emimovietrends.activity.DetailActivity;
import com.emiliano.emimovietrends.model.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emiliano on 23/02/18.
 */

public class SimilarMoviesAdapter extends RecyclerView.Adapter<SimilarMoviesAdapter.ViewHolder> {

    private static ArrayList<Movie> mSimilarMoviesDataset;
    public static Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_similar_movie_imageview)
        ImageView mMovieImageTextview;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(v -> onClick(v));
            ButterKnife.bind(this, view);
        }

        private void onClick(View v) {
            Intent detailActivity = new Intent(mContext, DetailActivity.class);
            detailActivity.putExtra("Movie", mSimilarMoviesDataset.get(getAdapterPosition()));
            mContext.startActivity(detailActivity);
        }
    }

    public SimilarMoviesAdapter(Context context, ArrayList<Movie> moviesDataset) {
        mContext = context;
        this.mSimilarMoviesDataset = moviesDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_similar_movie, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load("http://image.tmdb.org/t/p/w185/"+ mSimilarMoviesDataset.get(position).getPosterPath()).into(holder.mMovieImageTextview);
    }

    @Override
    public int getItemCount() {
        return mSimilarMoviesDataset.size();
    }


}