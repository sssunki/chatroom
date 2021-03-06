package com.example.chatroom.chatActivity.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.chatroom.R;
import com.example.chatroom.chatActivity.viewModel.dataModel.Friend;

import java.util.ArrayList;
import java.util.List;


public class FriendListFragment<T> extends Fragment implements ListInterface<T>{

    public FriendListFragment() {
        // Required empty public constructor
    }

    private FriendFragmentInteraction interaction;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FriendListFragment.FriendFragmentInteraction) {
            interaction = (FriendFragmentInteraction)context;
            recycleViewAdapter = new RecycleViewAdapter<>(interaction.getFriendList(), R.layout.friend_list_item);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        recyclerView = view.findViewById(R.id.friend_frag_recycler);
        initRecycler();
        return view;
    }

    private RecyclerView recyclerView;
    private RecycleViewAdapter<RecycleViewAdapter.ViewHolder, T> recycleViewAdapter;

    private void initRecycler() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recycleViewAdapter);
    }



    public void addItemListener(ItemListener<T> itemListener) {
        if (recycleViewAdapter != null)
        recycleViewAdapter.setItemListener(itemListener);
    }

    @Override
    public void setList(List<T> friendList) {
        if (recycleViewAdapter != null)
        recycleViewAdapter.reSetList(friendList);
    }

    public interface FriendFragmentInteraction {
        List getFriendList();
    }
}
