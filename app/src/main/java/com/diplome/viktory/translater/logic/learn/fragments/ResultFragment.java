package com.diplome.viktory.translater.logic.learn.fragments;

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

import com.diplome.viktory.translater.R;

import static com.diplome.viktory.translater.logic.learn.fragments.LearnStandartFragment.KEY_IMAGE;

public class ResultFragment extends Fragment {

    static final String KEY_TRUE_INFO = "True_Key";
    static final String KEY_FALSE_INFO = "False_Key";
    private ImageView mImageViewResult;
    private TextView mTextViewTrue, mTextViewFalse;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_learn_fragment_layout, null);

        mImageViewResult = (ImageView) view.findViewById(R.id.iv_result_smile);
        mTextViewFalse = (TextView) view.findViewById(R.id.tv_false);
        mTextViewTrue = (TextView) view.findViewById(R.id.tv_true);

        mTextViewTrue.setText(getResources().getString(R.string.True) + ": " + getArguments().getInt(KEY_TRUE_INFO));
        mTextViewFalse.setText(getResources().getString(R.string.False) + ": " + getArguments().getInt(KEY_FALSE_INFO));

        int result = (getArguments().getInt(KEY_FALSE_INFO) * 100) / getArguments().getInt(KEY_TRUE_INFO);

       if (result >= 70){
            mImageViewResult.setImageResource(R.drawable.true_smile);
        } if(result >= 50)
            mImageViewResult.setImageResource(R.drawable.normal_smile); else
                mImageViewResult.setImageResource(R.drawable.false_smile);

        return view;
    }

    public static ResultFragment newInstance(int countOfTrue , int countOfFalse) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        ResultFragment resultFragment = new ResultFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(KEY_TRUE_INFO, countOfTrue);
        arguments.putInt(KEY_FALSE_INFO, countOfFalse);
        resultFragment.setArguments(arguments);
        return resultFragment;
    }
}
