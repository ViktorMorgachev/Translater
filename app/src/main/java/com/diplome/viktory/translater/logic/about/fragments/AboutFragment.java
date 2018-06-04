package com.diplome.viktory.translater.logic.about.fragments;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.fragments.GuideSectionFragment;

import java.util.ArrayList;

public class AboutFragment extends DialogFragment implements View.OnClickListener {

    private Button mButtonOk, mButtonNot;
    private OnButtonClickListener mCallBackClickListener;
    private ImageView mImageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("About");
        View v = inflater.inflate(R.layout.dialog_about, null);
        mButtonNot = v.findViewById(R.id.btn_notCoffe);
        mButtonOk = v.findViewById(R.id.btn_setCoffe);
        mImageView = v.findViewById(R.id.image_coffeman);

        mButtonOk.setOnClickListener(this);
        mButtonNot.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View v) {
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

    public interface OnButtonClickListener {
        void onButtonPressed(View view);
    }
}
