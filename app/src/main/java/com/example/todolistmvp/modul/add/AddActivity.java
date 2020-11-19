package com.example.todolistmvp.modul.add;

import android.content.Intent;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

import java.util.ArrayList;

public class AddActivity extends BaseFragmentHolderActivity {
    protected AddFragment addFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        addFragment = new AddFragment();
        setCurrentFragment(addFragment, false);
    }
}
