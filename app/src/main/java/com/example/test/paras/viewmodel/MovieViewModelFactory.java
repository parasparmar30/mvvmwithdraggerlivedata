package com.example.test.paras.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.util.ArrayMap;

import com.example.test.paras.dependencyinjection.ViewModelSubComponent;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MovieViewModelFactory implements ViewModelProvider.Factory {
    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public MovieViewModelFactory(ViewModelSubComponent viewModelSubComponent) {
        creators = new ArrayMap<>();

        // View models cannot be injected directly because they won't be bound to the owner's view model scope.
        creators.put(MovieViewModel.class, () -> viewModelSubComponent.movieViewModel());
        creators.put(MovieListViewModel.class, () -> viewModelSubComponent.movieListViewModel());
        creators.put(CastViewModel.class, () -> viewModelSubComponent.castViewModel());

    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}