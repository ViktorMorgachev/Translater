package com.diplome.viktory.translater.logic.learn.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.diplome.viktory.translater.R;

public class LearnStandartFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageViewGo;
    static final String KEY_FIRST = "Source text";
    static final String KEY_SECOND = "Users input";
    static final String KEY_IMAGE =  "Image";
    static final String KEY_COUNT_TRUE = "Count of true answers";
    static final String KEY_COUNT_FALSE = "Count of false answers";
    private OnButtonClickListener mCallBackClickListener;
    private EditText mEditText;
    private TextView mTextView;
    private ImageView mImageView;
    private TextView mTextViewTrue;
    private TextView mTextViewFalse;
    private ImageView mImageViewShowResult;
    private int countOfTrueAnswers;
    private int countOfFalseAnswers;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learn_simple_fragment_layout, null);

        mImageViewGo = (ImageView) view.findViewById(R.id.iv_go);
        mEditText = (EditText) view.findViewById(R.id.edit_text);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        mImageView = (ImageView) view.findViewById(R.id.iv_picture);
        mTextViewFalse = (TextView) view.findViewById(R.id.tv_false_count);
        mTextViewTrue = (TextView) view.findViewById(R.id.tv_true_count);
        mImageViewShowResult = (ImageView) view.findViewById(R.id.iv_show_result);

        mTextView.setText(getArguments().getString(KEY_FIRST));
        mEditText.setText("");
        mImageView.setImageResource(getArguments().getInt(KEY_IMAGE));
        mTextViewTrue.setText(getResources().getString(R.string.True) + " : " + getArguments().getInt(KEY_COUNT_TRUE));
        mTextViewFalse.setText(getResources().getString(R.string.False) + " : " + getArguments().getInt(KEY_COUNT_FALSE));

        mImageViewGo.setOnClickListener(this);
        mImageViewShowResult.setOnClickListener(this);

        return view;
    }



    public static LearnStandartFragment newInstance(String learnText, String usersInput, int imageID, int countOfTrueAnswers, int countOfFalseAnswers) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        LearnStandartFragment pageFragment = new LearnStandartFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_FIRST, learnText);
        arguments.putInt(KEY_IMAGE, imageID);
        arguments.putInt(KEY_COUNT_TRUE, countOfTrueAnswers);
        arguments.putInt(KEY_COUNT_FALSE, countOfFalseAnswers);
        arguments.putString(KEY_SECOND, usersInput);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.iv_show_result) {
            countOfFalseAnswers++;
            mCallBackClickListener.onButtonPressed(v,
                    getArguments().getString(KEY_SECOND).equalsIgnoreCase(mEditText.getText().toString()));
            return;
        }

        if (mEditText.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Введите значение в поле ввода", Toast.LENGTH_SHORT).show();
            return;
        }

            if (!getArguments().getString(KEY_SECOND).equalsIgnoreCase(mEditText.getText().toString()))
                countOfFalseAnswers++;
            else
                countOfTrueAnswers++;


            mCallBackClickListener.onButtonPressed(v,
                    getArguments().getString(KEY_SECOND).equalsIgnoreCase(mEditText.getText().toString()));

    }

    public interface OnButtonClickListener {
        void onButtonPressed(View view, boolean trueFalse);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
