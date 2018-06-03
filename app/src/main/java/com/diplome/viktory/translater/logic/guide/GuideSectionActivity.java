package com.diplome.viktory.translater.logic.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.activities.GuideActivity;
import com.diplome.viktory.translater.logic.guide.fragments.GuideSectionFragment;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GuideSectionActivity extends AppCompatActivity implements GuideSectionFragment.OnButtonClickListener {

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;
    private ContextStorage mContextStorage;
    private Map<String, String> mContextTittlesMap;
    private ArrayList<String> mTittlesList = new ArrayList<>();
    private ArrayList<String> mFilesList= new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        mContextStorage = new ContextStorage(this);
        mContextTittlesMap = mContextStorage.getContextList();

        for(String key : mContextTittlesMap.keySet()) {
            mTittlesList.add(key);
            mFilesList.add(mContextTittlesMap.get(key));
        }

        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + ": onCreate " +
                "\nTittles list: " + mTittlesList.toString() +
                "\nFiles list: " + mFilesList.toString());

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
            mFragment = GuideSectionFragment.newInstance(mTittlesList);
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment)
                    .commit();
        }

    }

    @Override
    public void onButtonPressed(View view) {

        CardView cardView = (CardView) view;
        TextView textView = (TextView) cardView.getChildAt(0);

        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra(GuideActivity.KEY_FILE, mContextTittlesMap.get(textView.getText().toString()));
        startActivity(intent);

    }
}

