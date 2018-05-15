package com.diplome.viktory.translater.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.fragments.MenuFragment;
import com.diplome.viktory.translater.logic.ModuleInteractor;

public class MenuActivity extends AppCompatActivity implements MenuFragment.OnButtonClickListener {

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;
    private final ModuleInteractor mModuleInteractor = new ModuleInteractor();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
            mFragment = new MenuFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment)
                    .commit();
        }


    }

    @Override
    public void onButtonPressed(View view) {

        switch (view.getId()){
            case R.id.btn_translater:
                mModuleInteractor.startTranslaterActivity(this);
                break;
        }

    }
}