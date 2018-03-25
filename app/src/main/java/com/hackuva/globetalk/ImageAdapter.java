package com.hackuva.globetalk;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhilaash on 3/25/2018.
 */

public class ImageAdapter extends ArrayAdapter<Room> {
    public ImageAdapter(Context context, ArrayList<Room> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View room_View, ViewGroup parent) {
        Room room = getItem(position);
        if (room_View == null) {
            room_View = LayoutInflater.from(getContext()).inflate(R.layout.image_room, parent, false);
        }
        ImageView imview = (ImageView) room_View.findViewById(R.id.roomImage);
        imview.setImageBitmap(BitmapFactory.decodeResource(room_View.getResources(), R.drawable.image_preview));
        TextView tvName = (TextView) room_View.findViewById(R.id.roomName);
        tvName.setText(room.getRoom());

        return room_View;
    }
}