package com.diplome.viktory.translater.logic.learn.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.menu.fragments.MenuFragment;

public class ChoiceVariantsFragment extends Fragment implements View.OnClickListener {

    private OnButtonClickListener mCallBackClickListener;
    private Button mButtonColors, mButtonFruits,
            mButtonVegetables, mButtonSports,
            mButtonHobby, mButtonAnimals, mButtonClothes, mButtonQuestions;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learn_select_variant_layout, null);
        mButtonColors = view.findViewById(R.id.btn_colors);
        mButtonFruits = view.findViewById(R.id.btn_fruits);
        mButtonSports = view.findViewById(R.id.btn_sport);
        mButtonHobby = view.findViewById(R.id.btn_hobby);
        mButtonVegetables = view.findViewById(R.id.btn_vegetables);
        mButtonAnimals = view.findViewById(R.id.btn_animals);
        mButtonClothes = view.findViewById(R.id.btn_clothes);
        mButtonQuestions = view.findViewById(R.id.btn_questions);


        mButtonQuestions.setOnClickListener(this);
        mButtonClothes.setOnClickListener(this);
        mButtonSports.setOnClickListener(this);
        mButtonFruits.setOnClickListener(this);
        mButtonColors.setOnClickListener(this);
        mButtonHobby.setOnClickListener(this);
        mButtonAnimals.setOnClickListener(this);
        mButtonVegetables.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mCallBackClickListener.onButtonPressed(v);
    }

    public interface OnButtonClickListener {
        void onButtonPressed(View view);
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
