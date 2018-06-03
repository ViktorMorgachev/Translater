package com.diplome.viktory.translater.logic.guide.fragments;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;
import com.github.barteksc.pdfviewer.PDFView;

public class GuideFragment extends Fragment {

    static final String KEY_TITTLE = "Name of tittle";
    static final String KEY_DOCUMENT = "Name of document";
    PDFView mPDFView;

    // Передам позицию и ссылку на вьюшку в виде строки
    public static GuideFragment newInstance(String LinkForPdf) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        GuideFragment pageFragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_DOCUMENT, LinkForPdf);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.guide_fragment_layout,  null);
        mPDFView = (PDFView) view.findViewById(R.id.pdfView);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() +
                " : onCreateView , filename = " + getArguments().getString(KEY_DOCUMENT) +
                "\n Native language = " + PreferenceManager.getDefaultSharedPreferences(getContext()).getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                LanguagesInteractor.KeysField.RUSSIAN));

        mPDFView.fromAsset("russian_pronouns_en.pdf").load();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
