package com.example.test.paras.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.test.paras.R;
import com.example.test.paras.databinding.CastListItemBinding;
import com.example.test.paras.service.model.CastDetailWrapper;
import com.example.test.paras.service.model.MovieItemsWrapper;
import com.example.test.paras.view.callback.CastClickCallback;
import com.example.test.paras.view.callback.MovieClickCallback;

import java.util.List;

public class CastListAdapter extends RecyclerView.Adapter<CastListAdapter.CastViewHolder> {

    List<CastDetailWrapper> castList;
    @Nullable
    private final CastClickCallback castClickCallback;
    public CastListAdapter(List< CastDetailWrapper> movieList,@Nullable CastClickCallback castClickCallback) {
        this.castClickCallback = castClickCallback;
        this.castList = movieList;
    }


    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CastListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.cast_list_item,
                        parent, false);
        binding.setCallback(castClickCallback);
        return new CastViewHolder(binding);
    }
    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {
        holder.binding.setCast(castList.get(position));
        holder.binding.executePendingBindings();
    }
    @Override
    public int getItemCount() {
        return castList == null ? 0 : castList.size();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder {
        final CastListItemBinding binding;
        public CastViewHolder(CastListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
