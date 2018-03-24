package com.hackuva.globetalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StudentOrTeacher extends Fragment {
    // Store instance variables
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static StudentOrTeacher newInstance(int page) {
        StudentOrTeacher fragmentFirst = new StudentOrTeacher();
        page = page;
        Bundle args = new Bundle();
        args.putInt("pagenumber", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        if(page == 0) {
            view = inflater.inflate(R.layout.teacherfragment, container, false);
        }

        if(page == 1) {
            Log.e("Hello", "asdf");
            view = inflater.inflate(R.layout.studentfragment, container, false);
        }
        return view;
    }
}
