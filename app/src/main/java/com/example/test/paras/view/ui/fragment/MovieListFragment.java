package com.example.test.paras.view.ui.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.paras.R;
import com.example.test.paras.databinding.FragmentMovieListBinding;
import com.example.test.paras.dependencyinjection.Injectable;
import com.example.test.paras.service.model.MovieItemsWrapper;
import com.example.test.paras.service.model.MoviesWrapper;
import com.example.test.paras.view.ui.MovieDetailActivity;
import com.example.test.paras.view.adapter.MovieListAdapter;
import com.example.test.paras.view.callback.MovieClickCallback;
import com.example.test.paras.viewmodel.MovieListViewModel;

import javax.inject.Inject;

public class MovieListFragment extends Fragment implements Injectable {
    public MovieListFragment() {
    }
    public static final String TAG = "MovieListFragment";
    private MovieListAdapter projectAdapter;
    private FragmentMovieListBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false);

        projectAdapter = new MovieListAdapter(movieClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBundle();
        final MovieListViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(MovieListViewModel.class);
        viewModel.setMovieType(movieType);
        observeViewModel(viewModel);
    }
    private String movieType;
    private void getBundle() {
        Bundle bundle = getArguments();
        if (null != bundle) {
            if (bundle.containsKey("movieType")) {
                movieType = bundle.getString("movieType");
            }
        }
    }

    private void observeViewModel(MovieListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getMovieListObservable().observe(this, new Observer<MoviesWrapper>() {
            @Override
            public void onChanged(@Nullable MoviesWrapper projects) {
                if (projects != null) {
                    binding.setIsLoading(false);
                    projectAdapter.setMovieList(projects.getItems());
                }
            }
        });
    }

    private final MovieClickCallback movieClickCallback = new MovieClickCallback() {
        @Override
        public void onClick(MovieItemsWrapper movie) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                Intent intent =new Intent(getActivity(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.KEY_MOVIE_ID,movie.getId());
                startActivity(intent);
            }
        }
    };
}
