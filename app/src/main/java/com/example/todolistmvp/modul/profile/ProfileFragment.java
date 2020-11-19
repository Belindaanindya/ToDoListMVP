package com.example.todolistmvp.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.todolistmvp.R;
import com.example.todolistmvp.base.BaseFragment;
import com.example.todolistmvp.modul.list.ListActivity;
import com.example.todolistmvp.modul.login.LoginActivity;

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements ProfileContract.View {
    TextView tvUsername;
    TextView tvLabelUsername;
    TextView tvPassword;
    TextView tvLabelPassword;
    Button btnTodo;
    Button btnLogout;
    Bundle bundle;

    public ProfileFragment(Bundle bundle) {
        this.bundle = bundle;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        mPresenter = new ProfilePresenter(this);
        mPresenter.start();

        tvUsername = fragmentView.findViewById(R.id.tv_username);
        tvLabelUsername = fragmentView.findViewById(R.id.tv_label_username);
        tvPassword = fragmentView.findViewById(R.id.tv_password);
        tvLabelPassword = fragmentView.findViewById(R.id.tv_label_password);

        mPresenter.getUserInfo(bundle);

        btnTodo = fragmentView.findViewById(R.id.bt_todo);
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtToDoClick();
            }
        });

        btnLogout = fragmentView.findViewById(R.id.bt_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtLogoutClick();
            }
        });

        setTitle("My Profile View");

        return fragmentView;
    }

    public void setBtToDoClick(){
        mPresenter.performToDoList();
    }

    public void setBtLogoutClick(){
        mPresenter.performLogout();
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void showProfile(String email, String password){
        tvUsername.setText(email);
        tvPassword.setText(password);
    }

    public void redirectToToDoList() {
        Intent intent = new Intent(activity, ListActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void redirectToLogin() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
