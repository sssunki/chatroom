package com.example.chatroom.chatActivity.view.fragment;

public interface ItemListener<T> {
    void onClick(T item);
    void onLongClick(T item);
    void onSlideLeftToRight(T item);
    void onSlideRightToLeft(T item);
}
