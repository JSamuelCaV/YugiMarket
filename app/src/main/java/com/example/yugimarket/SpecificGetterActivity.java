package com.example.yugimarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;


public class SpecificGetterActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    String card_id, card_name;

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
        }
    }
}