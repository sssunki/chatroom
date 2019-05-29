package com.example.chatroom.chatActivity.view.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

public class RecycleViewAdapter<T extends RecycleViewAdapter.ViewHolder, K> extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<K> objects;
    private int layoutId;
    private ItemListener<K> itemListener;

    public RecycleViewAdapter(List<K> objects, int layoutId) {
        this.objects = objects;
        this.layoutId = layoutId;
    }

    @Override
    public int getItemCount() {
        if (objects == null) return 0;
        else return objects.size();
    }


    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder viewHolder, int i) {
        Object object = objects.get(i);
        viewHolder.bind(object);
    }

    public void setItemListener(ItemListener<K> itemListener) {
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, viewGroup, false);
        return (T)(new ViewHolder(viewDataBinding));
    }

    public void reSetList(List<K> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        private final ViewDataBinding viewDataBinding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.viewDataBinding = binding;
        }

        void bind(final K object) {
            viewDataBinding.setVariable(BR.obj,object);
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemListener != null) itemListener.onClick(object);
                }
            };
            View.OnLongClickListener longListener = new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (itemListener != null) return itemListener.onLongClick(object);
                    return false;
                }
            };
            this.viewDataBinding.setVariable(BR.listener, listener);
            this.viewDataBinding.setVariable(BR.longListener, longListener);
            viewDataBinding.executePendingBindings();
        }
    }
}
