package com.thanh.exercise1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class Ex3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);

        final  Button btn = findViewById(R.id.timebtn);
        final AlertDialog ad = new AlertDialog.Builder(this).create();
        Button nextbtn = findViewById(R.id.switchbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date t = new Date();
                String message = "Thoi gian hiện hành" + t.toLocaleString();
                ad.setMessage(message);
                ad.show();
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ex3.this, Ex4.class);
                startActivity(intent);
            }
        });
    }
}