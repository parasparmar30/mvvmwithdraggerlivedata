package com.example.test.paras.dependencyinjection;

import android.arch.lifecycle.ViewModelProvider;

import com.example.test.paras.service.repository.MovieDBService;
import com.example.test.paras.viewmodel.MovieViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents = ViewModelSubComponent.class)
class AppModule {
    @Singleton @Provides
    MovieDBService provideMovieDbService() {
        return new Retrofit.Builder()
                .baseUrl(MovieDBService.HTTPS_API_MOVIEDB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieDBService.class);
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {

        return new MovieViewModelFactory(viewModelSubComponent.build());
    }
}
