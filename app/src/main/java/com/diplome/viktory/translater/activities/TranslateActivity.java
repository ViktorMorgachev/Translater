package com.diplome.viktory.translater.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.translater.fragments.TranslateFragment;

public class TranslateActivity extends AppCompatActivity{

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if(mFragment == null){
            mFragment = new TranslateFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment)
                    .commit();
        }

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

