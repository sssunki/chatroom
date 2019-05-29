package com.example.chatroom.chatActivity.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<Object> objects;
    private int layoutId;

    public RecycleViewAdapter(List<Object> objects, int layoutId) {
        this.objects = objects;
        this.layoutId = layoutId;
    }

    @Override
    public int getItemCount() {
        if (objects == null) return 0;
        else return objects.size();
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(objects.get(i));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, viewGroup, false);
        return new ViewHolder(viewDataBinding);
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        private final ViewDataBinding viewDataBinding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.viewDataBinding = binding;
        }

        void bind(Object object) {
            viewDataBinding.setVariable(BR.obj,object);
            viewDataBinding.executePendingBindings();
        }
    }
}
