package com.example.test.paras.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.test.paras.R;
import com.example.test.paras.databinding.MovieListItemBinding;
import com.example.test.paras.service.model.MovieItemsWrapper;
import com.example.test.paras.view.callback.MovieClickCallback;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    List<? extends MovieItemsWrapper> movieList;

    @Nullable
    private final MovieClickCallback movieClickCallback;

    public MovieListAdapter(@Nullable MovieClickCallback movieClickCallback) {
        this.movieClickCallback = movieClickCallback;
    }

    public void setMovieList(final List<? extends MovieItemsWrapper> movieList) {
        if (this.movieList == null) {
            this.movieList = movieList;
            notifyItemRangeInserted(0, movieList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return MovieListAdapter.this.movieList.size();
                }

                @Override
                public int getNewListSize() {
                    return movieList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return MovieListAdapter.this.movieList.get(oldItemPosition).getId() ==
                            movieList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    MovieItemsWrapper movie = movieList.get(newItemPosition);
                    MovieItemsWrapper old = movieList.get(oldItemPosition);
                    return movie.getId() == old.getId()
                            ;
                }
            });
            this.movieList = movieList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.movie_list_item,
                        parent, false);

        binding.setCallback(movieClickCallback);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.binding.setMovie(movieList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        final MovieListItemBinding binding;

        public MovieViewHolder(MovieListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
