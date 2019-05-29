package com.example.chatroom.chatActivity.viewModel;

import com.example.chatroom.chatActivity.viewModel.dataModel.Message;
import com.example.chatroom.chatActivity.viewModel.dataModel.MessageContact;

import java.util.ArrayList;
import java.util.List;

public class MessageContactListModel {
    private List<MessageContact> messages;

    public MessageContactListModel() {
        this.messages = new ArrayList<>();
        this.messages.add(new MessageContact("小白", "jin cao fan mou", 14));
        this.messages.add(new MessageContact("小白", "jin cao fan mou", 14));
        this.messages.add(new MessageContact("小白", "jin cao fan mou", 14));
    }

    public List<MessageContact> getMessageContacts() {
        return messages;
    }

    public void setMessageContacts(List<MessageContact> messages) {
        this.messages = messages;
    }
}
