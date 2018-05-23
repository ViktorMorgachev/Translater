package com.diplome.viktory.translater;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.diplome.viktory.translater.logic.menu.activities.MenuActivity;

import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_layout);


        mImageView = (ImageView) findViewById(R.id.im_photo_id);
        mImageView.setImageResource(R.drawable.photo_id);
     //   mImageView.setImageBitmap(getBitmapFromAssets("photo_id.jpg"));

        MyAsynkTask myAsynkTask = (MyAsynkTask) new MyAsynkTask().execute();

    }

    private class MyAsynkTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            startActivity(new Intent(MainActivity.this, MenuActivity.class));
        }

        @Override
        protected Void doInBackground(Void... voids) {
           // SystemClock.sleep(4000);
            return null;
        }
    }

    public Bitmap getBitmapFromAssets(String fileName){

        AssetManager assetmanager = getAssets();
        InputStream is = null;
        try{

            is = assetmanager.open(fileName);
        }catch(IOException e){
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }
}
