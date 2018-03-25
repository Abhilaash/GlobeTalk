package com.hackuva.globetalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Abhilaash on 3/24/2018.
 */

public class Student extends Fragment {
    ArrayList<String> languages =new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    private String username;

    // newInstance constructor for creating fragment with arguments
    public static Student newInstance() {
        Student fragmentFirst = new Student();
        Bundle args = new Bundle();
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.studentfragment, container, false);


        Button activity = (Button) view.findViewById(R.id.button);
        activity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SessionPageStudent.class);
                intent.putStringArrayListExtra("Language", languages);
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                DatabaseReference user = myRef.child("users").push();
                user.child("username").setValue(username);
                user.child("teacher").setValue(false);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        return view;
    }
}
