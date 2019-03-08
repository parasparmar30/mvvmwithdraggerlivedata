package com.example.test.paras.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.test.paras.service.model.CastWrapper;
import com.example.test.paras.service.model.MovieDetailWrapper;
import com.example.test.paras.service.repository.MovieRepository;

import javax.inject.Inject;

public class CastViewModel extends AndroidViewModel {
    private static final String TAG = CastViewModel.class.getName();
    private static final MutableLiveData ABSENT = new MutableLiveData();
    {
        ABSENT.setValue(null);
    }

    private final LiveData<CastWrapper> castObservable;
    private final MutableLiveData<String> movieID;

    public ObservableField<CastWrapper> cast = new ObservableField<>();

    @Inject
    public CastViewModel(@NonNull MovieRepository movieRepository, @NonNull Application application) {
        super(application);

        this.movieID = new MutableLiveData<>();

        castObservable = Transformations.switchMap(movieID, input -> {
            if (input.isEmpty()) {
                Log.i(TAG, "MovieViewModel movieID is absent!!!");
                return ABSENT;
            }

            Log.i(TAG,"MovieViewModel movieID is " + movieID.getValue());

            return movieRepository.getCast( movieID.getValue());
        });
    }

    public LiveData<CastWrapper> getObservableProject() {
        return castObservable;
    }

    public void setMovieDetail(CastWrapper cast) {
        this.cast.set(cast);
    }

    public void setMovieID(String movieID) {
        this.movieID.setValue(movieID);
    }
}
