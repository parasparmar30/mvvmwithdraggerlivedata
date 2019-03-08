package com.example.test.paras.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.test.paras.R;
import com.example.test.paras.databinding.ActivityMovieDetailBinding;
import com.example.test.paras.view.adapter.MovieDetailPagerAdapter;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MovieDetailActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final String KEY_MOVIE_ID = "movie_id";
    private ActivityMovieDetailBinding binding;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private String movieId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        setSupportActionBar(binding.toolbar);
        if(getIntent().hasExtra(KEY_MOVIE_ID)){
            movieId =  getIntent().getStringExtra(KEY_MOVIE_ID);
        }
        setViewPager();
    }
    private void setViewPager(){
        binding.viewPager.setAdapter(new MovieDetailPagerAdapter(this,getSupportFragmentManager(),movieId));
        binding.tabs.setupWithViewPager(binding.viewPager);
    }
    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
