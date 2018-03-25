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

public class Teacher extends Fragment {
    ArrayList<String> languages =new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    private String username;

    // newInstance constructor for creating fragment with arguments
    public static Teacher newInstance(String username) {
        Teacher fragmentFirst = new Teacher();
        Bundle args = new Bundle();
        args.putString("username", username);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString("username");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.teacherfragment, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(adapter);
        editText = (EditText) view.findViewById(R.id.editText);
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String lang = editText.getText().toString();
                if(lang != "") {
                    languages.add(lang);
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        Button activity = (Button) view.findViewById(R.id.button);
        activity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SessionPageTeacher.class);
                intent.putStringArrayListExtra("Languages", languages);
                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                ArrayList<String> lclang = new ArrayList<>();
                for(String s : languages) {
                    lclang.add(s.toLowerCase());
                }
                DatabaseReference user = myRef.child("users").push();
                user.child("username").setValue(username);
                user.child("teacher").setValue(true);
                user.child("languages").setValue(lclang);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        return view;
    }
}
