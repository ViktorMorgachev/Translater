package com.diplome.viktory.translater.logic.translater.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.DirectionInteractor;
import com.diplome.viktory.translater.logic.translater.interfaces.OnRequestCreatedListener;
import com.diplome.viktory.translater.logic.translater.data.ResultObjectContext;

import java.util.List;

import retrofit2.Response;

public class TranslateFragment extends Fragment implements View.OnClickListener, OnRequestCreatedListener {

    private Spinner spinner1, spinner2;
    private ImageView imageViewRight, imageViewLeft;
    private EditText editTextLeft, editTextRight;
    private OnButtonClickListener mCaalBackClickListener;


    private String result;


    private String[] languages;

    public interface OnButtonClickListener{
        void onButtonPressed(View view, String textLeft, String textRight, int spinner1Position, int spinner2Position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.translate__layout, container, false);
        spinner1 = (Spinner) view.findViewById(R.id.spinner_first);
        spinner2 = (Spinner) view.findViewById(R.id.spinner_second);
        imageViewLeft = (ImageView) view.findViewById(R.id.translate_left);
        imageViewRight = (ImageView) view.findViewById(R.id.translate_right);
        editTextLeft = (EditText) view.findViewById(R.id.edit_left);
        editTextRight = (EditText) view.findViewById(R.id.edit_right);




        imageViewRight.setOnClickListener(this);
        imageViewLeft.setOnClickListener(this);

        languages = getResources().getStringArray(R.array.languages);



      /*  // Подключаем свой шаблон с разными значками
        MyCustomAdapter adapter = new MyCustomAdapter(getContext(),
                R.layout.spinner_languages_item, languages);*/

        // Вызываем адапетр
        //   spinner1.setAdapter(adapter);
        spinner1.setSelection(2, true);

        // Вызываем адапетр 2
        //  spinner2.setAdapter(adapter);
        spinner2.setSelection(1, true);



        return view;
    }




    @Override
    public void onClick(View v) {

        if ((editTextLeft.getText().toString() == "") && (editTextRight.getText().toString() == ""))
            return;


       mCaalBackClickListener.onButtonPressed(v,
               editTextLeft.getText().toString(),
               editTextRight.getText().toString(),
               spinner1.getSelectedItemPosition(),
               spinner2.getSelectedItemPosition() );
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCaalBackClickListener = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }

    @Override
    public void onEndedResponseCreated(Response<ResultObjectContext> response, int direction) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> stringList = response.body().getText();

        for (int i = 0; i < stringList.size(); i++) {
            stringBuilder.append(stringList.get(i));
        }

        if (direction == DirectionInteractor.Direction.RIGHT)
            editTextRight.setText(stringBuilder.toString());
        else
            editTextLeft.setText(stringBuilder.toString());
    }
}
