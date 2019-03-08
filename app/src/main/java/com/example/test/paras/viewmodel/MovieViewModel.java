package com.example.test.paras.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.test.paras.service.model.MovieDetailWrapper;
import com.example.test.paras.service.model.MovieItemsWrapper;
import com.example.test.paras.service.model.MoviesWrapper;
import com.example.test.paras.service.repository.MovieRepository;

import javax.inject.Inject;

public class MovieViewModel extends AndroidViewModel {
    private static final String TAG = MovieViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        ABSENT.setValue(null);
    }

    private final LiveData<MovieDetailWrapper> movieObservable;
    private final MutableLiveData<String> movieID;

    public ObservableField<MovieDetailWrapper> movie = new ObservableField<>();

    @Inject
    public MovieViewModel(@NonNull MovieRepository movieRepository, @NonNull Application application) {
        super(application);

        this.movieID = new MutableLiveData<>();

        movieObservable = Transformations.switchMap(movieID, input -> {
            if (input.isEmpty()) {
                Log.i(TAG, "MovieViewModel movieID is absent!!!");
                return ABSENT;
            }

            Log.i(TAG,"MovieViewModel movieID is " + movieID.getValue());

            return movieRepository.getMovieDetails( movieID.getValue());
        });
    }

    public LiveData<MovieDetailWrapper> getObservableProject() {
        return movieObservable;
    }

    public void setMovieDetail(MovieDetailWrapper movie) {
        this.movie.set(movie);
    }

    public void setMovieID(String movieID) {
        this.movieID.setValue(movieID);
    }
}
