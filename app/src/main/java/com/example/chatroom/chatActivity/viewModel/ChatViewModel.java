package com.example.chatroom.chatActivity.viewModel;

import com.example.chatroom.chatActivity.view.ChatViewInterface;
import com.example.chatroom.chatActivity.viewModel.dataModel.User;

import java.util.List;

public class ChatViewModel implements ChatViewModelInterface {

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public List getFriendList() {
        return friendListModel.getFriends();
    }

    @Override
    public List getMessageContactList() {
        return messageContactListModel.getMessageContacts();
    }

    @Override
    public void changeCurrentContact(String name, int account) {

    }

    @Override
    public void sendMessageTo(String name, int account, String message) {

    }

    @Override
    public void onViewInitFinished() {
        contactChatView();
    }

    //view
    private ChatViewInterface chatViewInterface;

    //数据
    private DrawerModel drawerModel;
    private FriendListModel friendListModel;
    private MessageContactListModel messageContactListModel;
    private CurrentMessageModel currentMessageModel;
    private User user;


    public ChatViewModel(ChatViewInterface chatViewInterface) {
        this.chatViewInterface = chatViewInterface;
        iniChildrenModel();
    }

    //创建子model
    private void iniChildrenModel() {
        //TODO(1) 需要在登入的时候，设置drawerModel中的姓名和帐号
        this.drawerModel = new DrawerModel("青韧",1427218224);
        this.currentMessageModel = new CurrentMessageModel();
        this.friendListModel = new FriendListModel();
        this.messageContactListModel = new MessageContactListModel();
        this.user = new User("青韧", 1427218224);
    }

    private void contactChatView() {
        this.chatViewInterface.setFriendList(this.friendListModel.getFriends());
    }
}
