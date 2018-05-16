package com.diplome.viktory.translater.logic.guide.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

public class GuideActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        Toast.makeText(this, getIntent().getStringExtra(LanguagesInteractor.KeysField.EXTRA_KEY), Toast.LENGTH_SHORT).show();
    }

}


