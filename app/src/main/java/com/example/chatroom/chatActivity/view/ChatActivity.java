package com.example.chatroom.chatActivity.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.chatroom.R;
import com.example.chatroom.chatActivity.view.fragment.ChatFragment;
import com.example.chatroom.chatActivity.view.fragment.FriendListFragment;
import com.example.chatroom.chatActivity.view.fragment.ItemListener;
import com.example.chatroom.chatActivity.view.fragment.ListInterface;
import com.example.chatroom.chatActivity.view.fragment.MessageContactListFragment;
import com.example.chatroom.chatActivity.viewModel.ChatViewModel;
import com.example.chatroom.chatActivity.viewModel.ChatViewModelInterface;
import com.example.chatroom.chatActivity.viewModel.dataModel.Friend;
import com.example.chatroom.chatActivity.viewModel.dataModel.Message;
import com.example.chatroom.chatActivity.viewModel.dataModel.MessageContact;
import com.example.chatroom.databinding.NavHeaderChatBinding;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ChatViewInterface
        , FriendListFragment.FriendFragmentInteraction, MessageContactListFragment.MessageContactFragmentInteraction {

    //ChatActivity的功能
    @Override
    public void setFriendList(List<Friend> friendList) {
        this.friendListView.setList(friendList);
    }

    @Override
    public void setMessageContactList(List<MessageContact> messageContactList) {

    }

    @Override
    public void setMessageList(List<Message> messages) {

    }

    @Override
    public void scrollToChatWindow() {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        initViewPager();
        chatViewModel = new ChatViewModel(this);
        bindingNavigationView(navigationView);
    }

    //处理navigationView的dataBinding
    private void bindingNavigationView(NavigationView navigationView) {
        NavHeaderChatBinding navHeaderChatBinding = NavHeaderChatBinding.inflate(LayoutInflater.from(navigationView.getContext()));
        navHeaderChatBinding.setUser(chatViewModel.getUser());
        navHeaderChatBinding.executePendingBindings();
        navigationView.addHeaderView(navHeaderChatBinding.getRoot());
    }

    //ViewMode
    private ChatViewModelInterface chatViewModel;

    @Override
    protected void onStart() {
        super.onStart();
        //chatViewModel.onViewInitFinished();
        afterFragmentViewCreated();
    }

    //view
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //fragment
    private ListInterface<Friend> friendListView;
    private ListInterface<MessageContact> messageContactListView;

    private void initViewPager() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.friend_list));
        titles.add(getString(R.string.message_list));
        titles.add(getString(R.string.chat));
        for (String string : titles) tabLayout.addTab(tabLayout.newTab().setText(string));
        List<Fragment> fragments = new ArrayList<>();
        FriendListFragment<Friend> friendListFragment = new FriendListFragment<>();
        this.friendListView = friendListFragment;
        fragments.add(friendListFragment);
        MessageContactListFragment<MessageContact> messageContactListFragment = new MessageContactListFragment<>();
        this.messageContactListView = messageContactListFragment;
        fragments.add(messageContactListFragment);
        fragments.add(new ChatFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments, titles);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    //当fragment的view生成后
    private void afterFragmentViewCreated() {
        this.friendListView.addItemListener(new FriendItemListener());
    }


    //生成fragment的回调
    @Override
    public List getFriendList() {
        return chatViewModel.getFriendList();
    }

    @Override
    public List getMessageContactLit() {
        return chatViewModel.getMessageContactList();
    }

    //FriendFragment和MessageContactFragment中，item点击的回调。
    class FriendItemListener implements ItemListener<Friend> {
        @Override
        public void onClick(Friend item) {

        }

        @Override
        public boolean onLongClick(Friend item) {
            return false;
        }
    }

    class MessageContactItemListener implements ItemListener<MessageContact> {
        @Override
        public void onClick(MessageContact item) {

        }

        @Override
        public boolean onLongClick(MessageContact item) {
            return false;
        }
    }
}
