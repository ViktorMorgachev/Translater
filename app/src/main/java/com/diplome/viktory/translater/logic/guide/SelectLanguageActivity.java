package com.diplome.viktory.translater.logic.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.activities.GuideActivity;
import com.diplome.viktory.translater.logic.guide.activities.GuideSectionActivity;
import com.diplome.viktory.translater.logic.guide.fragments.SelectLanguageFragment;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

public class SelectLanguageActivity extends AppCompatActivity implements SelectLanguageFragment.OnButtonClickListener {

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
            mFragment = new SelectLanguageFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment)
                    .commit();
        }

    }

    @Override
    public void onButtonPressed(View view) {

        CardView cardView = (CardView) view;
        TextView textView = (TextView) cardView.getChildAt(0);

        Intent intent = new Intent(this, GuideSectionActivity.class);
        intent.putExtra(LanguagesInteractor.KeysField.EXTRA_KEY, textView.getText().toString());
        startActivity(intent);

    }
}

