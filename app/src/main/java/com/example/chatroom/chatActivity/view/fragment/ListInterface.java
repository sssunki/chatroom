package com.example.chatroom.chatActivity.view.fragment;

import java.util.List;

public interface ListInterface<T> {
    void setList(List<T> friendList);
    void addItemListener(ItemListener<T> itemListener);
}
