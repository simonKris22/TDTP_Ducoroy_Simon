package com.example.tp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface theMoviesDB
{
    public final String ENDPOINT ="https://api.themoviedb.org";

    @GET("/3/movie/popular?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=fr&page=1")
            Call<MovieDb> listPopular();

    @GET("/3/movie/upcoming?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=fr&page=1")
            Call<MovieDb> listUpcoming();

    @GET("/3/movie/popular?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=en&page=1")
    Call<MovieDb> listPopularEN();

    @GET("/3/movie/upcoming?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=en&page=1")
    Call<MovieDb> listUpcomingEN();

    @GET("/3/search/movie?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=fr")
    Call<MovieDb> sceach(@Query("query") String query);

    @GET("/3/search/movie?api_key=4c6f8d1b550a6d0627f84d6a1d1076c5&language=en")
    Call<MovieDb> sceachEN(@Query("query") String query);



}
