package com.diplome.viktory.translater.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.activities.interactors.KeysInteractor;
import com.diplome.viktory.translater.activities.services.InternetChecker;
import com.diplome.viktory.translater.activities.translater.ResultObjectContext;
import com.diplome.viktory.translater.activities.translater.ResultObjectLanguage;
import com.diplome.viktory.translater.activities.translater.Translater;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslateActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner1, spinner2;
    private ImageView imageViewRight, imageViewLeft;
    private EditText editTextLeft, editTextRight;
    private Map<Integer, String> mLanguageMap;

    private String[] languages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate__layout);
        spinner1 = (Spinner) findViewById(R.id.spinner_first);
        spinner2 = (Spinner) findViewById(R.id.spinner_second);
        imageViewLeft = (ImageView) findViewById(R.id.translate_left);
        imageViewRight = (ImageView) findViewById(R.id.translate_right);
        editTextLeft = (EditText) findViewById(R.id.edit_left);
        editTextRight = (EditText) findViewById(R.id.edit_right);
        mLanguageMap = new HashMap<>();

        imageViewRight.setOnClickListener(this);
        imageViewLeft.setOnClickListener(this);


        languages = getResources().getStringArray(R.array.languages);

       /* <item>Русский</item>
        <item>Английский</item>
        <item>Французский</item>
        <item>Итальянский</item>
        <item>Испанский</item>
        <item>Немецкий</item>
        <item>Корейский</item>*/

        mLanguageMap.put(0, "ky");
        mLanguageMap.put(1, "ru");
        mLanguageMap.put(2, "en");
        mLanguageMap.put(3, "fr");
        mLanguageMap.put(4, "it");
        mLanguageMap.put(5, "es");
        mLanguageMap.put(6, "de");
        mLanguageMap.put(7, "ko");



      /*  // Подключаем свой шаблон с разными значками
        MyCustomAdapter adapter = new MyCustomAdapter(getContext(),
                R.layout.spinner_languages_item, languages);*/

        // Вызываем адапетр
        //   spinner1.setAdapter(adapter);
        spinner1.setSelection(2, true);

        // Вызываем адапетр 2
        //  spinner2.setAdapter(adapter);
        spinner2.setSelection(1, true);


    }


    @Override
    public void onClick(View v) {

        if (editTextLeft == null && editTextRight == null)
            return;

        Map<String, String> map = new HashMap<>();

        InternetChecker internetChecker = new InternetChecker();
        internetChecker.execute(getApplicationContext());

        try {
            if (internetChecker.get()) {

                map.put("key", KeysInteractor.KeysField.API_KEY_YANDEX_TRANSLATER);
                String resultLang = null;

                // Определяемя исходный язык

                String lang1 = getSourceText(getHintLang(mLanguageMap), KeysInteractor.KeysField.API_KEY_YANDEX_TRANSLATER);


                switch (v.getId()) {
                    case R.id.translate_left:
                        resultLang = mLanguageMap.get(spinner2.getSelectedItemPosition()
                                + "-" + lang1);
                        map.put("text", editTextRight.getText().toString());
                        break;
                    case R.id.translate_right:
                        resultLang = mLanguageMap.get(spinner1.getSelectedItemPosition())
                                + "-" + mLanguageMap.get(spinner2.getSelectedItemPosition());
                        map.put("text", editTextLeft.getText().toString());
                        break;
                }

                map.put("lang", resultLang);

                getTextTranstated(map, v.getId());


            } else {
                Toast.makeText(this, R.string.has_not_internet, Toast.LENGTH_SHORT).show();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    private String getHintLang(Map<Integer, String> langsMap) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < langsMap.size(); i++) {
            stringBuilder.append(langsMap.get(i) + ",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        Log.d(KeysInteractor.KeysField.LOG_TAG, stringBuilder.toString());
        return stringBuilder.toString();
    }

    public void getTextTranstated(Map<String, String> map, int direction) {
        Translater.getApi().getData(map)
                .enqueue(new Callback<ResultObjectContext>() {
                    @Override
                    public void onResponse(Call<ResultObjectContext> call, Response<ResultObjectContext> response) {
                        Log.d("MY_DEBUG", "onResponse\n" + call.toString());
                        if (response.body() != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            List<String> textList = response.body().getText();
                            if (direction == R.id.translate_right) {
                                editTextRight.setText("");
                                for (int i = 0; i < textList.size(); i++) {
                                    stringBuilder.append(textList.get(i));
                                }
                                editTextRight.setText(stringBuilder);

                            } else {
                                editTextLeft.setText("");
                                for (int i = 0; i < textList.size(); i++) {
                                    stringBuilder.append(textList.get(i));
                                }
                                editTextLeft.setText(Arrays.toString(textList.toArray()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultObjectContext> call, Throwable t) {
                        Log.d("MY_DEBUG", "onFailure\n" + call.toString());
                    }


                });
    }

    private String getSourceText(String hint, String key) {
        Translater.getApi().getLanguage(hint, key)
                .enqueue(new Callback<ResultObjectLanguage>() {
                    @Override
                    public void onResponse(Call<ResultObjectLanguage> call, Response<ResultObjectLanguage> response) {
                        Log.d("MY_DEBUG", "onResponse\n" + call.toString());

                    }

                    @Override
                    public void onFailure(Call<ResultObjectLanguage> call, Throwable t) {
                        Log.d("MY_DEBUG", "onFailure\n" + call.toString());
                    }

                });

    }


   /* public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);

        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.item_select_language, parent, false);
            TextView label = (TextView) row.findViewById(R.id.id_text);
            label.setText(languages[position]);

            ImageView icon = (ImageView) row.findViewById(R.id.id_image);

            icon.setImageResource(R.drawable.english_flag);

            return row;
        }
    }*/


}

