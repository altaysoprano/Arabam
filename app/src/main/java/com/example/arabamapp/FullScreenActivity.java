package com.example.arabamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FullScreenActivity extends AppCompatActivity {

    public static final String EXTRA_PHOTO = "package com.example.arabamapp.EXTRA_PHOTO";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        imageView = findViewById(R.id.full_screen_imageview);

        setTitle("Photo");

        Intent intent = getIntent();
        String photo = intent.getStringExtra(EXTRA_PHOTO);

        Glide.with(this)
                .load(photo)
                .fitCenter()
                .into(imageView);
    }
}
