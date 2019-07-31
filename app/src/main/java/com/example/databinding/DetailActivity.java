package com.example.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.databinding.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    //TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        // textView = findViewById(R.id.text_vi);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra("EXTRA_URL");
        String creatorName = intent.getStringExtra("EXTRA_CREATOR");
        String likeCount = intent.getStringExtra("EXTRA_LIKES");

        ExampleItem exampleItem = new ExampleItem(imageUrl, creatorName, likeCount);
        detailBinding.setItem(exampleItem);
        // String j = detailBinding.getItem().creator;

        //textView.setText(j);


    }
}