package com.example.chatroom.chatActivity.view.fragment;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.chatroom.R;
import com.example.chatroom.chatActivity.viewModel.FriendListModel;
import com.example.chatroom.chatActivity.viewModel.dataModel.Friend;

import java.util.ArrayList;
import java.util.List;


public class FriendListFragment<T> extends Fragment implements ListInterface<T>{

    public FriendListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        recyclerView = view.findViewById(R.id.friend_frag_recycler);
        initRecycler();
        return view;
    }

    private RecyclerView recyclerView;

    private void initRecycler() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecycleViewAdapter(null, R.layout.friend_list_item));
        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return super.onInterceptTouchEvent(rv, e);
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                super.onTouchEvent(rv, e);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                super.onRequestDisallowInterceptTouchEvent(disallowIntercept);
            }
        });
    }


    private ItemListener<T> itemListener;


    public void addItemListener(ItemListener<? extends T> itemListener) {

    }

    @Override
    public void setList(List friendList) {

    }
}
