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

}
