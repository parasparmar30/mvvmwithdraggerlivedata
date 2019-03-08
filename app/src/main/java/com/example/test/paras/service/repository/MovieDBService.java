package com.example.test.paras.service.repository;

import com.example.test.paras.service.model.CastWrapper;
import com.example.test.paras.service.model.MovieDetailWrapper;
import com.example.test.paras.service.model.MoviesWrapper;
import com.example.test.paras.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieDBService {
    String HTTPS_API_MOVIEDB_URL = "https://api.themoviedb.org/";

    @GET("3/movie/{movieType}?api_key="+ Constant.API_KEY +"&language=en-US")
    Call<MoviesWrapper> getMovieList(@Path("movieType") String movieType);

    @GET("3/movie/{movieId}?api_key="+ Constant.API_KEY +"&language=en-US")
    Call<MovieDetailWrapper> getMovieDetails(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/credits?api_key="+ Constant.API_KEY )
    Call<CastWrapper> getCast(@Path("movieId") String movieId);
}
