package com.example.test.paras.dependencyinjection;

import com.example.test.paras.view.ui.MovieDetailActivity;
import com.example.test.paras.view.ui.MovieTabActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MovieDetailActivity contributeMainActivity();
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MovieTabActivity contributeMovieTabActivity();
}
