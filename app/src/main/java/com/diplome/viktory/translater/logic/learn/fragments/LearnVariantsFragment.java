package com.diplome.viktory.translater.logic.learn.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LearnVariantsFragment extends Fragment implements View.OnClickListener {

    static final String KEY_QUESTION = "Source text";
    static final String KEY_ANSWER = "Users input";
    static final String KEY_IMAGE =  "Image";
    static final String KEY_REMAINING = "Remaining three wrong answer";
    static final String KEY_COUNT_TRUE = "Count of true answers";
    static final String KEY_COUNT_FALSE = "Count of false answers";
    private int countOfTrueAnswers;
    private TextView mTextViewQuestion;
    private int countOfFalseAnswers;
    private TextView mTextViewTrue;
    private TextView mTextViewFalse;
    private OnButtonClickListener mCallBackClickListener;
    private static SharedPreferences sSharedPreferences;
    private Button mButtonRighTop, mButtonLeftTop, mButtonRightBottom, mButtonLeftBottom;

    public static LearnVariantsFragment newInstance(String question, String rightAnswer,
                                                    int imageID, int countOfTrueAnswers, int countOfFalseAnswers, List<String> remainingWords) {
        // Уcё, вопросов нет, осталcя один вопрос, как сохранить view
        // Добавляем правильный ответ к общему списку
        remainingWords.add(rightAnswer);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, "Before sorting: " + remainingWords.toString());
        // Сортируем
        Collections.shuffle(remainingWords);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, "After sorting: " + remainingWords.toString());

        String[] answersArrays = createAnswersArrays(remainingWords);

        LearnVariantsFragment pageFragment = new LearnVariantsFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_QUESTION, question);
        arguments.putInt(KEY_COUNT_TRUE, countOfTrueAnswers);
        arguments.putInt(KEY_COUNT_FALSE, countOfFalseAnswers);
        arguments.putString(KEY_ANSWER, rightAnswer);
        arguments.putInt(KEY_IMAGE, imageID);
        arguments.putStringArray(KEY_REMAINING, answersArrays);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    public static LearnVariantsFragment newInstance(String question, String rightAnswer,
                                                    int countOfTrueAnswers, int countOfFalseAnswers,
                                                    List<String> remainingWords) {

        // Добавляем правильный ответ к общему списку
        remainingWords.add(rightAnswer);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, "Before sorting: " + remainingWords.toString());
        // Сортируем
        Collections.shuffle(remainingWords);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, "After sorting: " + remainingWords.toString());

        String[] answersArrays = createAnswersArrays(remainingWords);

        LearnVariantsFragment pageFragment = new LearnVariantsFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_QUESTION, question);
        arguments.putInt(KEY_COUNT_TRUE, countOfTrueAnswers);
        arguments.putInt(KEY_COUNT_FALSE, countOfFalseAnswers);
        arguments.putString(KEY_ANSWER, rightAnswer);
        arguments.putStringArray(KEY_REMAINING, answersArrays);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    private static String[] createAnswersArrays(List<String> remainingWords) {

        String[] answersArrays = new String[remainingWords.size()];
        Iterator<String> iterator = remainingWords.iterator();

        int tempCount = 0;
        while (iterator.hasNext()){
            answersArrays[tempCount++] = iterator.next();
        }

        return answersArrays;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.learn_variants_fragment_layout, null);
        mButtonLeftBottom = (Button) view.findViewById(R.id.btn_left_bottom);
        mButtonLeftTop = (Button)  view.findViewById(R.id.btn_left_top);
        mButtonRightBottom = (Button) view.findViewById(R.id.btn_right_bottom);
        mButtonRighTop = (Button) view.findViewById(R.id.btn_right_top);
        mTextViewQuestion = (TextView)  view.findViewById(R.id.tv_question);

        String[] questions = getArguments().getStringArray(KEY_REMAINING);
        List<String> stringList = Arrays.asList(questions);

        mTextViewFalse = (TextView) view.findViewById(R.id.tv_false_count);
        mTextViewTrue = (TextView) view.findViewById(R.id.tv_true_count);
        // Теперь бегаем по коллекции и вытаскиваем элементы
        mButtonRighTop.setText(stringList.get(0));
        mButtonRightBottom.setText(stringList.get(1));
        mButtonLeftTop.setText(stringList.get(2));
        mButtonLeftBottom.setText(stringList.get(3));


        mTextViewTrue.setText(getResources().getString(R.string.True) + " : " + getArguments().getInt(KEY_COUNT_TRUE));
        mTextViewFalse.setText(getResources().getString(R.string.False) + " : " + getArguments().getInt(KEY_COUNT_FALSE));
        mTextViewQuestion.setText(getArguments().getString(KEY_QUESTION).toString()+"?");


        mButtonLeftBottom.setOnClickListener(this);
        mButtonLeftTop.setOnClickListener(this);
        mButtonRightBottom.setOnClickListener(this);
        mButtonRighTop.setOnClickListener(this);

        return view;

    }

    public interface OnButtonClickListener {
        void onButtonPressed(View view, boolean trueFalse);
    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;
        // Если верно
        if(getArguments().getString(KEY_ANSWER).equalsIgnoreCase(button.getText().toString())){
               mCallBackClickListener.onButtonPressed(v, true);
        } else {
            mCallBackClickListener.onButtonPressed(v, false);
        }



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
    }
}
