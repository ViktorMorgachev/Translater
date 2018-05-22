package com.diplome.viktory.translater.logic.learn.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.diplome.viktory.translater.R;

public class LearnStandartFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageViewGo;
    private OnButtonClickListener mCallBackClickListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learn_fragment_layout, null);

        mImageViewGo = (ImageView) view.findViewById(R.id.iv_go);

        mImageViewGo.setOnClickListener(this);

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
