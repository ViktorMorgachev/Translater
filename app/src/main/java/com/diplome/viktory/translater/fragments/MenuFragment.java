package com.diplome.viktory.translater.fragments;

import android.os.Bundle;
import android.os.UserManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.diplome.viktory.translater.R;

public class MenuFragment extends Fragment  implements View.OnClickListener{

    private Button btnAbout;
    private Button btnExit;
    private Button btnTranslater;
    private Button btnLearn;
    private Button btnGuide;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_fragment_layout, container, false);
        btnAbout = (Button) view.findViewById(R.id.btn_about);
        btnExit = (Button) view.findViewById(R.id.btn_exit);
        btnLearn = (Button) view.findViewById(R.id.btn_learn);
        btnTranslater = (Button) view.findViewById(R.id.btn_translater);
        btnGuide = (Button) view.findViewById(R.id.btn_guide);

        btnLearn.setOnClickListener(this);
        btnTranslater.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnAbout.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
