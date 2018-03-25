package com.hackuva.globetalk;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SessionPageTeacher extends AppCompatActivity {

    String username;
    ArrayList<String> languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_page_teacher);
        ImageView imageView;
        LinearLayout layout = (LinearLayout) findViewById(R.id.chats);
        for (int i = 0; i < 3; i++) {
            imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.image_preview));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }
        layout = findViewById(R.id.archives);
        for (int i = 0; i < 3; i++) {
            imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.image_preview));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        setTitle("Welcome: " + username);
        languages = intent.getStringArrayListExtra("Languages");
    }

    public void StartChat(View v) {
        Intent intent = new Intent(this, videoChat.class);
        startActivity(intent);
    }
}
