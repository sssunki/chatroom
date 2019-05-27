package com.example.chatroom.chatActivity.view.fragment;

import java.util.List;

public interface ListInterface<T> {
    void setList(List friendList);
    void addItemListener(ItemListener<? extends T> itemListener);
}
