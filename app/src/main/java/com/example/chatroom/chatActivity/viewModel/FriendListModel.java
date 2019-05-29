package com.example.chatroom.chatActivity.viewModel;

import com.example.chatroom.chatActivity.viewModel.dataModel.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendListModel {

    private List<Friend> friends;

    public FriendListModel() {
        this.friends = new ArrayList<>();
        this.friends.add(new Friend("朋友1", 123));
        this.friends.add(new Friend("朋友2", 456));
        this.friends.add(new Friend("朋友3", 789));
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }
}
