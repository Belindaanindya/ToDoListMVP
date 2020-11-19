package com.example.todolistmvp.modul.list;

import android.content.Intent;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

import java.util.ArrayList;

public class ListActivity extends BaseFragmentHolderActivity {
    protected ListFragment listFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        listFragment = new ListFragment();
        setCurrentFragment(listFragment, true);
    }
}