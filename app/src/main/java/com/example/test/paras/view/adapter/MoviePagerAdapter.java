package com.example.test.paras.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.test.paras.view.ui.fragment.MovieListFragment;


public class MoviePagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MoviePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        MovieListFragment movieListFragment = new MovieListFragment();
        if (position == 0)
        {
            bundle.putString("movieType", "now_playing");
        }
        else if (position == 1)
        {
            bundle.putString("movieType", "upcoming");
        }
        else if (position == 2)
        {
            bundle.putString("movieType", "popular");

        }

        movieListFragment.setArguments(bundle);
        return movieListFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Now Playing";
        }
        else if (position == 1)
        {
            title = "Upcoming";
        }
        else if (position == 2)
        {
            title = "Popular";
        }
        return title;
    }
}