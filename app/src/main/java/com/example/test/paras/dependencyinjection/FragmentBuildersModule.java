package com.example.test.paras.dependencyinjection;

import com.example.test.paras.view.ui.fragment.MovieCastListFragment;
import com.example.test.paras.view.ui.fragment.MovieDetailsFragment;
import com.example.test.paras.view.ui.fragment.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract MovieDetailsFragment contributeMovieFragment();

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();

    @ContributesAndroidInjector
    abstract MovieCastListFragment contributeMovieCastListFragment();
}
