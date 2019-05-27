package com.example.chatroom.chatActivity.view.fragment;

import android.view.MotionEvent;
import android.view.View;

public interface ItemListener<T> {
    void onTouchEvent(T item, MotionEvent motionEvent);
}
