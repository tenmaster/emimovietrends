package com.emiliano.emimovietrends.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by emiliano on 05/03/18.
 */

public class Movie implements Serializable {

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("genre_ids")
    int [] genreIDArray;

    @SerializedName("title")
    String title;

    @SerializedName("popularity")
    float popularity;

    @SerializedName("vote_count")
    int voteCount;

    @SerializedName("vote_average")
    float voteAverage;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("overview")
    String overview;

    @SerializedName("poster_path")
    String posterPath;

    public String getOriginalTitle() {
        return originalTitle;
    }

    public int[] getGenreIDArray() {
        return genreIDArray;
    }

    public String getTitle() {
        return title;
    }

    public float getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
