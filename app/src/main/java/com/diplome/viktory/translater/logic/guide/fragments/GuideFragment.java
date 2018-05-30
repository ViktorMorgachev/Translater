package com.diplome.viktory.translater.logic.guide.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diplome.viktory.translater.R;
import com.github.barteksc.pdfviewer.PDFView;

public class GuideFragment extends Fragment {

    static final String KEY_LAYOUT = "Necessary Layout";
    static final String KEY_LINK = "Link For Document";
    private int linkForView;
    PDFView mPDFView;

    // Передам позицию и ссылку на вьюшку в виде строки
    public static GuideFragment newInstance(String LinkForPdf) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        GuideFragment pageFragment = new GuideFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_LINK, LinkForPdf);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(linkForView, null);
        mPDFView = view.findViewById(R.id.pdfView);
        mPDFView.fromAsset(getArguments().get(KEY_LINK) + ".pdf").load();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linkForView = getArguments().getInt(KEY_LAYOUT);
    }
}
