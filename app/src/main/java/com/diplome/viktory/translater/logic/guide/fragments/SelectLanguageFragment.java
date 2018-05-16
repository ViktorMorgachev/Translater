package com.diplome.viktory.translater.logic.guide.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.UserManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.menu.fragments.MenuFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectLanguageFragment extends Fragment {

    private OnButtonClickListener mCallBackClickListener;
    private RecyclerView mRecyclerView;
    private LanguageAdapter mAdapter;

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
        List<String> languageList = new ArrayList<>();
        languageList.add(LanguagesInteractor.KeysField.RUSSIAN);
        languageList.add(LanguagesInteractor.KeysField.KYRGUZS);
                languageList.add(LanguagesInteractor.KeysField.ENGLISH);
        //languageList = Arrays.asList(getResources().getStringArray(R.array.languages));
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

    private class LanguageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private String language;
       private TextView mTextView;

        public void bind(String str) {
            mTextView.setText(str);
        }

        public LanguageHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_select_language, parent, false));
            mTextView = (TextView) itemView.findViewById(R.id.item_text);
            mTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           mCallBackClickListener.onButtonPressed(v);
        }
    }

    private class LanguageAdapter extends RecyclerView.Adapter<LanguageHolder>{

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
