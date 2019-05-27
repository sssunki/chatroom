package com.example.chatroom.chatActivity.view.fragment;

import java.util.List;

public interface ChatFragmentInterface<T> {
    void addChatFragmentCallback(ChatFragment.Callback callback);
    void setMessageList(List<T> T);
}
