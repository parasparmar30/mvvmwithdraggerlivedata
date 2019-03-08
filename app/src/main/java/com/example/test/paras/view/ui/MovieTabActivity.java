package com.example.test.paras.view.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.test.paras.R;
import com.example.test.paras.databinding.ActivityMovieTabBinding;
import com.example.test.paras.view.adapter.MoviePagerAdapter;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MovieTabActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private ActivityMovieTabBinding binding;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_tab);
        setSupportActionBar(binding.toolbar);
        setViewPager();
    }
    private void setViewPager(){
        binding.viewPager.setAdapter(new MoviePagerAdapter(this,getSupportFragmentManager()));
        binding.tabs.setupWithViewPager(binding.viewPager);
    }
    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}
