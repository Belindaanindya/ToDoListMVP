package com.example.todolistmvp.modul.profile;

import android.os.Bundle;
import android.view.View;

import com.example.todolistmvp.base.BaseFragmentHolderActivity;

public class ProfileActivity extends BaseFragmentHolderActivity {
    ProfileFragment profileFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        Bundle bundle = getIntent().getExtras();
        profileFragment = new ProfileFragment(bundle);
        setCurrentFragment(profileFragment, false);

    }
}
