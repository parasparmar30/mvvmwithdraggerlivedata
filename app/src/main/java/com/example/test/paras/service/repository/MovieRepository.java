package com.example.test.paras.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.test.paras.service.model.CastWrapper;
import com.example.test.paras.service.model.MovieDetailWrapper;
import com.example.test.paras.service.model.MoviesWrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class MovieRepository {
    private MovieDBService movieDbService;

    @Inject
    public MovieRepository(MovieDBService movieDbService) {
        this.movieDbService = movieDbService;
    }

    public LiveData<MoviesWrapper> getMovieList(String movieType) {
        final MutableLiveData<MoviesWrapper> data = new MutableLiveData<>();

        movieDbService.getMovieList(movieType).enqueue(new Callback<MoviesWrapper>() {
            @Override
            public void onResponse(Call<MoviesWrapper> call, Response<MoviesWrapper> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MoviesWrapper> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<MovieDetailWrapper> getMovieDetails(String movieId) {
        final MutableLiveData<MovieDetailWrapper> data = new MutableLiveData<>();

        movieDbService.getMovieDetails(movieId).enqueue(new Callback<MovieDetailWrapper>() {
            @Override
            public void onResponse(Call<MovieDetailWrapper> call, Response<MovieDetailWrapper> response) {
                simulateDelay();
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieDetailWrapper> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<CastWrapper> getCast(String movieId) {
        final MutableLiveData<CastWrapper> data = new MutableLiveData<>();

        movieDbService.getCast(movieId).enqueue(new Callback<CastWrapper>() {
            @Override
            public void onResponse(Call<CastWrapper> call, Response<CastWrapper> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CastWrapper> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
