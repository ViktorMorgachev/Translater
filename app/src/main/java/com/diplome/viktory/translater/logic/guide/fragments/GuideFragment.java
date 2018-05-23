package com.diplome.viktory.translater.logic.guide.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.diplome.viktory.translater.R;

public class GuideFragment extends Fragment {

    static final String ARGUMENT_LAYOUT = "Necessary Layout";
    private int linkForView;

    // Передам позицию и ссылку на вьюшку в виде строки
    public static GuideFragment newInstance(int position, Integer view) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        GuideFragment pageFragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_LAYOUT, position);
        arguments.putInt(ARGUMENT_LAYOUT, view);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(linkForView, null);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linkForView = getArguments().getInt(ARGUMENT_LAYOUT);
    }
}
