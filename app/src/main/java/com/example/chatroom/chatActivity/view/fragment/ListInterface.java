package com.example.chatroom.chatActivity.view.fragment;

import java.util.List;

public interface ListInterface<T> {
    void setFriendList(List friendList);
    void addItemListener(ItemListener<T> itemListener);
}
