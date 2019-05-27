package com.example.chatroom.chatActivity.viewModel;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableFloat;

public class DrawerModel {

    private ObservableField<String> name;

    private ObservableFloat account;

    public DrawerModel(String name, float account) {
        this.name = new ObservableField<>(name);
        this.account = new ObservableFloat(account);
    }

}
