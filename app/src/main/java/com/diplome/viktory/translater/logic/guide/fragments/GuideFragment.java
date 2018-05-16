package com.diplome.viktory.translater.logic.guide.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.activities.GuideActivity;

import java.util.List;

public class GuideFragment extends Fragment {

    static final String ARGUMENT_TITTLE_NAME = "arg_page_number";

    public static GuideFragment newInstance(int position, View view) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить View
        GuideFragment pageFragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_TITTLE_NAME, position);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.englsih_verbs_fragment_layout, null);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
