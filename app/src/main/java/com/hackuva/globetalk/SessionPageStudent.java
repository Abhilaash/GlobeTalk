package com.hackuva.globetalk;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SessionPageStudent extends AppCompatActivity {

    String username;
    ArrayList<String> languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_page_student);
        ImageView imageView;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        DatabaseReference rooms = myRef.child("active_sessions");

        LinearLayout layout = (LinearLayout) findViewById(R.id.chats);
//        final ArrayList<String> roomnames = new ArrayList<>();
//        rooms.orderByKey().addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                assert ((HashMap) dataSnapshot.getValue()) != null;
//                String val = (String) ((HashMap) dataSnapshot.getValue()) ["session_id"];
//                Log.e("Hello", dataSnapshot.getValue());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        getDataFromURL dataRetriever = new getDataFromURL();
//        ArrayList<Room> allrooms = new ArrayList<Room>();
//        for(String roomname : roomnames) {
//            String url = ("https://imigrant.herokuapp.com/" + roomname);
//            allrooms.add(new Room(roomname));
//        }
//
//        ImageAdapter imageAdapter = new ImageAdapter(this, allrooms);
//        for (int x = 0; x < roomnames.size(); x++) {
//            Room r = new Room(roomnames.get(x));
//            imageView = new ImageView(this);
//            imageView.setId(x);
//            imageView.setPadding(2, 2, 2, 2);
//            imageView.setImageBitmap(BitmapFactory.decodeResource(
//                    getResources(), R.drawable.image_preview));
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            layout.addView(imageView);
//        }

        for (int i = 0; i < 3; i++) {
            imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.image_preview));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), videoChat.class);
                    startActivity(intent);
                }
            });
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
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), videoChat.class);
                    startActivity(intent);
                }
            });
            layout.addView(imageView);
        }

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        setTitle("Welcome: " + username);
        languages = intent.getStringArrayListExtra("Languages");
    }
}
