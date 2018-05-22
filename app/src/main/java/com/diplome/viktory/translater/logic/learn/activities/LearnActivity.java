package com.diplome.viktory.translater.logic.learn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.learn.fragments.ChoiceVariantsFragment;

public class LearnActivity extends AppCompatActivity  implements ChoiceVariantsFragment.OnButtonClickListener{
    // For analize this Activity working is first time
    private static boolean isStarted;
    private Fragment mFragment;
    private FragmentManager mFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        isStarted = true;

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if(mFragment == null || !isStarted){
            mFragment = new ChoiceVariantsFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment).commit();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStarted = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isStarted = true;
    }

    @Override
    public void onButtonPressed(View view) {

        Toast.makeText(this,((Button) view).getText().toString() + " нажали", Toast.LENGTH_SHORT).show();

        switch (view.getId()){
            case R.id.btn_colors:
                Toast.makeText(this, "Будем учить цвета", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
