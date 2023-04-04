package com.thanh.exercise1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.Key;

public class Ex4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        EditText editText = findViewById(R.id.edit_text);
        final AlertDialog ad = new AlertDialog.Builder(this).create();
        Button nextbtn = findViewById(R.id.switchbtn);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DPAD_CENTER){
                    String message = editText.getText().toString();
                    ad.setMessage(message);
                    ad.show();
                }
                return false;
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ex4.this, Ex5.class);
                startActivity(intent);
            }
        });
    }
}