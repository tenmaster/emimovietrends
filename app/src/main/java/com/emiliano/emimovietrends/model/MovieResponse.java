package com.emiliano.emimovietrends.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by emiliano on 05/03/18.
 */

public class MovieResponse {

    @SerializedName("page")
    int page;

    @SerializedName("total_results")
    int totalResults;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("total_count")
    ArrayList<Movie> movies;


}
