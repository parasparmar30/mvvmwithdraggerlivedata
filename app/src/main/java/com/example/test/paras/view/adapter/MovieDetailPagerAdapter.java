package com.example.test.paras.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.test.paras.view.ui.MovieDetailActivity;
import com.example.test.paras.view.ui.fragment.MovieCastListFragment;
import com.example.test.paras.view.ui.fragment.MovieDetailsFragment;


public class MovieDetailPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String movieId;

    public MovieDetailPagerAdapter(Context context, FragmentManager fm,String movieId) {
        super(fm);
        this.context = context;
        this.movieId =  movieId;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        bundle.putString(MovieDetailActivity.KEY_MOVIE_ID, movieId);
        if (position == 0)
        {
            MovieDetailsFragment movieListFragment = new MovieDetailsFragment();
            movieListFragment.setArguments(bundle);
            return movieListFragment;
        }
        else
        {
            MovieCastListFragment movieCastListFragment = new MovieCastListFragment();
            movieCastListFragment.setArguments(bundle);
            return movieCastListFragment;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Detail";
        }
        else if (position == 1)
        {
            title = "Cast";
        }

        return title;
    }
}