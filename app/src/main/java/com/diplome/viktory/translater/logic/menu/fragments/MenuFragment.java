package com.diplome.viktory.translater.logic.menu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysInteractor;

public class MenuFragment extends Fragment implements View.OnClickListener {

    private OnButtonClickListener mCallBackClickListener;
    private Button btnAbout;
    private Button btnExit;
    private Button btnTranslater;
    private Button btnLearn;
    private Button btnGuide;
    private Button btnSettings;


    public interface OnButtonClickListener {
        void onButtonPressed(View view);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_fragment_layout, container, false);
        btnAbout = (Button) view.findViewById(R.id.btn_about);
        btnExit = (Button) view.findViewById(R.id.btn_exit);
        btnLearn = (Button) view.findViewById(R.id.btn_learn);
        btnTranslater = (Button) view.findViewById(R.id.btn_translater);
        btnGuide = (Button) view.findViewById(R.id.btn_guide);
        btnSettings = (Button) view.findViewById(R.id.btn_setup);

        btnLearn.setOnClickListener(this);
        btnTranslater.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnGuide.setOnClickListener(this);
        btnSettings.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onClick ");
        mCallBackClickListener.onButtonPressed(v);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBackClickListener = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }
}
