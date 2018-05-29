package com.diplome.viktory.translater.logic.guide.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class SelectLanguageFragment extends Fragment {

    private OnButtonClickListener mCallBackClickListener;
    private RecyclerView mRecyclerView;
    private LanguageAdapter mAdapter;
    List<String> languageList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.select_language_fragment_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_languages_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;

    }

    private void updateUI() {

        languageList = new ArrayList<>();
        languageList.addAll(Arrays.asList(getResources().getString(R.string.russian),
                getResources().getString(R.string.kyrgyzs),
                getResources().getString(R.string.english)));

        mAdapter = new LanguageAdapter(languageList);
        mRecyclerView.setAdapter(mAdapter);
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

    private class LanguageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private String language;
        private TextView mTextView;
        private CardView mCardView;

        public void bind(String str) {
            mTextView.setText(str);
        }

        public LanguageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_select_language, parent, false));
            mCardView = (CardView) itemView.findViewById(R.id.cv_language);
            mTextView = (TextView) itemView.findViewById(R.id.tv_select_language);
            mCardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallBackClickListener.onButtonPressed(v);
        }
    }

    private class LanguageAdapter extends RecyclerView.Adapter<LanguageHolder> {

        List<String> mLanguagesList;

        @NonNull
        @Override
        public LanguageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new LanguageHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LanguageHolder holder, int position) {
            holder.bind(mLanguagesList.get(position));
        }

        @Override
        public int getItemCount() {
            return mLanguagesList.size();
        }

        public LanguageAdapter(List<String> languages) {
            this.mLanguagesList = languages;
        }
    }

    public interface OnButtonClickListener {
        void onButtonPressed(View view);
    }


}
