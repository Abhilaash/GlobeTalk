package com.hackuva.globetalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.GlobeTalk.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Welcome.class);
        EditText username = (EditText) findViewById(R.id.input_email);
        EditText password = (EditText) findViewById((R.id.input_password));

        String user = username.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, user);
        startActivity(intent);
    }
}
