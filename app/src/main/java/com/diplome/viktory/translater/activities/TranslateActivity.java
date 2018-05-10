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
import com.diplome.viktory.translater.activities.translater.ResultObject;
import com.diplome.viktory.translater.activities.translater.Translater;
import com.diplome.viktory.translater.interfaces.YandexTranslateApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TranslateActivity extends AppCompatActivity implements View.OnClickListener {

    private YandexTranslateApi yandexTranslateApi;
    private Spinner spinner1, spinner2;
    private ImageView imageViewRight, imageViewLeft;
    private ResultObject mResultObject;
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

        Map<String, String> map = new HashMap<>();
        int firstLanguage = (int) spinner1.getSelectedItemId();
        int secongLanguage = (int) spinner2.getSelectedItemId();




        if (editTextLeft == null)
            return;

        String resultLang = null;

        map.put("key", KeysInteractor.KeysField.API_KEY_YANDEX_TRANSLATER);

        Log.d("MY_DEBUG", "OnClick\n" + spinner1.getSelectedItem().toString());

        switch (v.getId()) {
            case R.id.translate_left:
                resultLang = mLanguageMap.get(secongLanguage) + "-" + mLanguageMap.get(firstLanguage) ;
                map.put("text", editTextRight.getText().toString());
                break;
            case R.id.translate_right:
                resultLang = mLanguageMap.get(firstLanguage) + "-" + mLanguageMap.get(secongLanguage);
                map.put("text", editTextLeft.getText().toString());
                break;
        }

        Toast.makeText(this, resultLang, Toast.LENGTH_SHORT).show();

        map.put("lang", resultLang);


        Translater.getApi().getData(map)
                .enqueue(new Callback<ResultObject>() {
                    @Override
                    public void onResponse(Call<ResultObject> call, Response<ResultObject> response) {
                        Log.d("MY_DEBUG", "OnResponse\n" + call.toString());
                        if (response.body() != null) {
                            List<String> textList = response.body().getText();
                            if (v.getId() == R.id.translate_right) {
                                editTextRight.setText("");
                                editTextRight.setText(Arrays.toString(textList.toArray()));

                            } else {
                                editTextLeft.setText("");
                                editTextLeft.setText(Arrays.toString(textList.toArray()));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultObject> call, Throwable t) {
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

