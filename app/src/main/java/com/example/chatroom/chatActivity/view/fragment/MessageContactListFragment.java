package com.example.chatroom.chatActivity.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chatroom.R;

import java.util.List;

public class MessageContactListFragment<T> extends Fragment implements ListInterface<T>{

    public MessageContactListFragment() {
        // Required empty public constructor
    }

    private MessageContactFragmentInteraction interaction;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MessageContactFragmentInteraction) {
            interaction = (MessageContactFragmentInteraction) context;
            recycleViewAdapter = new RecycleViewAdapter<>(interaction.getMessageContactLit(), R.layout.message_contact_list_tiem);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_contact_list, container, false);
        recyclerView = view.findViewById(R.id.message_contact_frg_recycler);
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
    public void setList(List<T> messageContacts) {
        if (recycleViewAdapter != null)
            recycleViewAdapter.reSetList(messageContacts);
    }

    public interface MessageContactFragmentInteraction {
        List getMessageContactLit();
    }
}
