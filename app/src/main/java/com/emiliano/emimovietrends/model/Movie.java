package com.emiliano.emimovietrends.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by emiliano on 05/03/18.
 */

public class Movie {

    @SerializedName("original_name")
    String originalName;

    @SerializedName("genre_ids")
    int [] genreIDArray;

    @SerializedName("origin_country")
    String [] originCountryArray;

    @SerializedName("name")
    String name;

    @SerializedName("popularity")
    int popularity;

    @SerializedName("vote_count")
    int voteCount;

    @SerializedName("vote_average")
    float voteAverage;

    @SerializedName("first_air_date")
    String firstAirDate;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("overview")
    String overview;

    @SerializedName("poster_path")
    String posterPath;

    public String getOriginalName() {
        return originalName;
    }

    public int[] getGenreIDArray() {
        return genreIDArray;
    }

    public String[] getOriginCountryArray() {
        return originCountryArray;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getFirstAirDate() {
        return firstAirDate;
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
