package com.diplome.viktory.translater.logic.about.activities;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.about.fragments.AboutFragment;

public class AboutActivity extends AppCompatActivity implements AboutFragment.OnButtonClickListener {

    DialogFragment mDialogFragment;
    @Override
    public void onButtonPressed(View view) {

        if(view.getId() == R.id.btn_setCoffe){
            Toast.makeText(this, "Спасибо от него ", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Вы обидели его ", Toast.LENGTH_LONG).show();
        mDialogFragment.onDetach();
        moveTaskToBack(false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDialogFragment = new AboutFragment();
        mDialogFragment.show(getSupportFragmentManager(), "about_fragment");
    }
}
