package com.example.test.paras.view.ui.fragment;

import android.arch.lifecycle.Lifecycle;
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
import com.example.test.paras.databinding.FragmentMovieCastListBinding;
import com.example.test.paras.dependencyinjection.Injectable;
import com.example.test.paras.service.model.CastDetailWrapper;
import com.example.test.paras.service.model.CastWrapper;
import com.example.test.paras.view.adapter.CastListAdapter;
import com.example.test.paras.view.callback.CastClickCallback;
import com.example.test.paras.view.ui.MovieDetailActivity;
import com.example.test.paras.viewmodel.CastViewModel;

import javax.inject.Inject;

public class MovieCastListFragment extends Fragment implements Injectable {
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private FragmentMovieCastListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate this data binding layout
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_cast_list, container, false);

        // Create and set the adapter for the RecyclerView.
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final CastViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CastViewModel.class);

        viewModel.setMovieID(getArguments().getString(MovieDetailActivity.KEY_MOVIE_ID));

        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(final CastViewModel viewModel) {
        // Observe cast data
        viewModel.getObservableProject().observe(this, new Observer<CastWrapper>() {
            @Override
            public void onChanged(@Nullable CastWrapper movie) {
                if (movie != null) {
                    binding.setIsLoading(false);
                    if(movie.getCast()!=null && !movie.getCast().isEmpty())
                        binding.castList.setAdapter(new CastListAdapter(movie.getCast(),castClickCallback));
                }
            }
        });
    }

    private final CastClickCallback castClickCallback = new CastClickCallback() {
        @Override
        public void onClick(CastDetailWrapper movie) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            }
        }
    };

}
