package com.diplome.viktory.translater.logic.guide.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;

import java.util.ArrayList;
import java.util.List;


public class GuideSectionFragment extends Fragment {

    private OnButtonClickListener mCallBackClickListener;
    private RecyclerView mRecyclerView;
    private SectionAdapter mAdapter;
    List<String> sectionsList;
    static final String KEY_LIST = "Name of document";


    // Передам позицию и ссылку на вьюшку в виде строки
    public static GuideSectionFragment newInstance(ArrayList<String> listOfSections) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        GuideSectionFragment guideSectionFragment = new GuideSectionFragment();
        Bundle arguments = new Bundle();
        arguments.putStringArrayList(KEY_LIST, listOfSections);
        guideSectionFragment.setArguments(arguments);
        return guideSectionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.select_fragment_layout, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_languages_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;

    }

    private void updateUI() {
        sectionsList = getArguments().getStringArrayList(KEY_LIST);
        mAdapter = new SectionAdapter(sectionsList);
        mRecyclerView.setAdapter(mAdapter);

        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + ": updateUI " +
                "\nTittles: " + sectionsList);
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

        private String tittle;
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

    private class SectionAdapter extends RecyclerView.Adapter<LanguageHolder> {

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

        public SectionAdapter(List<String> languages) {
            this.mLanguagesList = languages;
        }
    }

    public interface OnButtonClickListener {
        void onButtonPressed(View view);
    }


}
