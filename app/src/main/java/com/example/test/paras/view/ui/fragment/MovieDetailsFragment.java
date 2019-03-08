package com.example.test.paras.view.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.paras.R;
import com.example.test.paras.databinding.FragmentMovieDetailsBinding;
import com.example.test.paras.dependencyinjection.Injectable;
import com.example.test.paras.service.model.MovieDetailWrapper;
import com.example.test.paras.view.ui.MovieDetailActivity;
import com.example.test.paras.viewmodel.MovieViewModel;

import javax.inject.Inject;

public class MovieDetailsFragment extends Fragment implements Injectable {
    private FragmentMovieDetailsBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false);

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final MovieViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MovieViewModel.class);

        viewModel.setMovieID(getArguments().getString(MovieDetailActivity.KEY_MOVIE_ID));

        binding.setMovieViewModel(viewModel);
        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(final MovieViewModel viewModel) {
        // Observe cast data
        viewModel.getObservableProject().observe(this, new Observer<MovieDetailWrapper>() {
            @Override
            public void onChanged(@Nullable MovieDetailWrapper movie) {
                if (movie != null) {
                    binding.setIsLoading(false);
                    viewModel.setMovieDetail(movie);
                    if(movie.getGenres()!=null && !movie.getGenres().isEmpty()){
                        String genres = "Genres";
                        for(int i = 0 ;i<movie.getGenres().size() ; i++){
                            if(i==0){
                                genres=genres+": "+movie.getGenres().get(i).getName();
                            }else
                                genres=genres+", "+movie.getGenres().get(i).getName();
                        }
                        binding.txtVwGenres.setText(genres);
                    }
                }
            }
        });
    }
}
