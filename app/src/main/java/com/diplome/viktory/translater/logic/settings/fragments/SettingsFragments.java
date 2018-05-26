package com.diplome.viktory.translater.logic.settings.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.learn.fragments.ChoiceVariantsFragment;

public class SettingsFragments extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private OnButtonClickListener mCallBackClickListener;
    private Spinner mSpinnerNativeLanguage;
    private Spinner mSpinnerLearnLanguage;
    private SharedPreferences mSharedPreferences;
    private Button mButtonBack;
    private Switch mSwitch;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings_fragment_layout, null);
        mSpinnerLearnLanguage = (Spinner) view.findViewById(R.id.sp_learn_language);
        mSpinnerNativeLanguage = (Spinner) view.findViewById(R.id.sp_native_laguage);
        mButtonBack = (Button) view.findViewById(R.id.btn_back);
        mSwitch = (Switch) view.findViewById(R.id.sw_show_image);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());


        mSpinnerNativeLanguage.setPrompt(getResources().getString(R.string.native_laguage));
        mSpinnerLearnLanguage.setPrompt(getResources().getString(R.string.learn_language));



        spinerLearnSetPosition();
        spinerNativeSetPosition();
        swithShowImageSetPosition();

        mButtonBack.setOnClickListener(this);

        mSwitch.setOnCheckedChangeListener(this);

        mSpinnerNativeLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCallBackClickListener.onNativeLanguageSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCallBackClickListener.onNativeLanguageSelected(1);

            }
        });

        mSpinnerLearnLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCallBackClickListener.onLearnLanguageSelected(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCallBackClickListener.onLearnLanguageSelected(2);

            }
        });

        return view;
    }

    private void swithShowImageSetPosition() {
        mSwitch.setChecked(mSharedPreferences.getBoolean(KeysInteractor.KeysField.KEY_SHOW_IMAGE, true));
    }

    private void spinerLearnSetPosition() {

        switch (mSharedPreferences.getString(KeysInteractor.KeysField.KEY_LEARN_LANGUAGE, LanguagesInteractor.KeysField.ENGLISH)){
            case LanguagesInteractor.KeysField.ENGLISH:
                mSpinnerLearnLanguage.setSelection(2);
                break;
            case LanguagesInteractor.KeysField.KYRGUZS:
                mSpinnerLearnLanguage.setSelection(0);
                break;
            case LanguagesInteractor.KeysField.RUSSIAN:
                mSpinnerLearnLanguage.setSelection(1);
                break;
        }
    }

    private void spinerNativeSetPosition() {

        switch (mSharedPreferences.getString(KeysInteractor.KeysField.KEY_NATIVE_LANGUAGE, LanguagesInteractor.KeysField.RUSSIAN)){
            case LanguagesInteractor.KeysField.ENGLISH:
                mSpinnerNativeLanguage.setSelection(2);
                break;
            case LanguagesInteractor.KeysField.KYRGUZS:
                mSpinnerNativeLanguage.setSelection(0);
                break;
            case LanguagesInteractor.KeysField.RUSSIAN:
                mSpinnerNativeLanguage.setSelection(1);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        mCallBackClickListener.onButtonPressed(v);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCallBackClickListener.onShowImageCheched(isChecked);
    }

    public interface OnButtonClickListener {
        void onNativeLanguageSelected(int id);

        void onLearnLanguageSelected(int id);

        void onButtonPressed(View view);

        void onShowImageCheched(boolean isChecked);
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
