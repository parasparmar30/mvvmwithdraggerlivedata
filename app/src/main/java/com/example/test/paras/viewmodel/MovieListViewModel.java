package com.example.test.paras.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.test.paras.service.model.MoviesWrapper;
import com.example.test.paras.service.repository.MovieRepository;

import javax.inject.Inject;

public class MovieListViewModel extends AndroidViewModel {
    private final LiveData<MoviesWrapper> movieListObservable;
    private final MutableLiveData<String> movieType;
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        ABSENT.setValue(null);
    }

    @Inject
    public MovieListViewModel(@NonNull MovieRepository movieRepository, @NonNull Application application) {
        super(application);
        this.movieType = new MutableLiveData<>();

        // If any transformation is needed, this can be simply done by Transformations class ...
        movieListObservable = Transformations.switchMap(movieType, input -> {
            if (input.isEmpty()) {
                return ABSENT;
            }


            return movieRepository.getMovieList( movieType.getValue());
        });
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<MoviesWrapper> getMovieListObservable() {
        return movieListObservable;
    }
    public void setMovieType(String movieType) {
        this.movieType.setValue(movieType);
    }
}
