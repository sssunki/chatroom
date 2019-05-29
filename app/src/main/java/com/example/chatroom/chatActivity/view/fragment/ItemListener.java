package com.example.chatroom.chatActivity.view.fragment;

import android.view.MotionEvent;
import android.view.View;

public interface ItemListener<T> {
    void onClick(T item);
    boolean onLongClick(T item);
}
