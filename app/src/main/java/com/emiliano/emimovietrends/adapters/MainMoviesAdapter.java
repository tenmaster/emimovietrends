package com.emiliano.emimovietrends.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.emiliano.emimovietrends.R;
import com.emiliano.emimovietrends.model.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emiliano on 23/02/18.
 */

public class MainMoviesAdapter extends RecyclerView.Adapter<MainMoviesAdapter.ViewHolder> {

    private static ArrayList<Movie> mMoviesDataset;
    public static Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_movie_title)
        TextView mMovieNameTextview;
        @BindView(R.id.item_movie_stars)
        TextView mMovieVotesTextview;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public MainMoviesAdapter(Context context, ArrayList<Movie> moviesDataset) {
        mContext = context;
        this.mMoviesDataset = moviesDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mMovieNameTextview.setText(mMoviesDataset.get(position).getTitle());
        holder.mMovieVotesTextview.setText(String.valueOf(mMoviesDataset.get(position).getVoteAverage()));

    }

    @Override
    public int getItemCount() {
        return mMoviesDataset.size();
    }

}