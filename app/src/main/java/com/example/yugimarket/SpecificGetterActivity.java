package com.example.yugimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class SpecificGetterActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    String card_id, card_name,card_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_getter);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            if (textView.getText().length() == 10 && textView.getText().toString().substring(4) == "-" && textView != null) {
                card_id = (String) bundle.get("Card_id");
                textView.setText(card_id);
            } else {
                card_name = (String) bundle.get("Card_name");
                textView.setText(card_name);
            }
            card_image = (String) bundle.get("card_image");

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap image = getBitmapFromURL(card_image);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(image);
                        }
                    });

                }
            });
            thread.start();



        }
    }
    private Bitmap getBitmapFromURL(String card_image){


        try {
            URL url = new URL(card_image);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap image = BitmapFactory.decodeStream(input);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
