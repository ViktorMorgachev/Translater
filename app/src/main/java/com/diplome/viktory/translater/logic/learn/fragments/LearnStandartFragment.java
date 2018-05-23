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

import com.diplome.viktory.translater.R;

public class LearnStandartFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageViewGo;
    static final String KEY_FIRST = "Source text";
    static final String KEY_SECOND= "Users input";
    private OnButtonClickListener mCallBackClickListener;
    private EditText mEditText;
    private TextView mTextView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learn_simple_fragment_layout, null);

        mImageViewGo = (ImageView) view.findViewById(R.id.iv_go);
        mEditText = (EditText) view.findViewById(R.id.edit_text);
        mTextView = (TextView) view.findViewById(R.id.text_view);

        mTextView.setText(savedInstanceState.getString(KEY_FIRST));
        mEditText.setText(savedInstanceState.getString(KEY_SECOND));

        mImageViewGo.setOnClickListener(this);

        return view;
    }

    // Передам позицию и ссылку на вьюшку в виде строки
    public static LearnStandartFragment newInstance(String source, String usersInput) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        LearnStandartFragment pageFragment = new LearnStandartFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_FIRST, source);
        arguments.putString(KEY_SECOND, usersInput);
        pageFragment.setArguments(arguments);
        return pageFragment;
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
