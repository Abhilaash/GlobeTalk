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
        if(user.equalsIgnoreCase("abhilaash") || user.equalsIgnoreCase("therobotcarlson") || user.equalsIgnoreCase("irysad")) {
            intent.putExtra("username", user);
            startActivity(intent);
        }
    }
}
