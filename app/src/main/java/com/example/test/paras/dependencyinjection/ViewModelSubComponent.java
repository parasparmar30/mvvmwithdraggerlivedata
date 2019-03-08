package com.example.test.paras.dependencyinjection;

import com.example.test.paras.viewmodel.CastViewModel;
import com.example.test.paras.viewmodel.MovieListViewModel;
import com.example.test.paras.viewmodel.MovieViewModel;
import com.example.test.paras.viewmodel.MovieViewModelFactory;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link MovieViewModelFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    MovieListViewModel movieListViewModel();
    MovieViewModel movieViewModel();
    CastViewModel castViewModel();

}
