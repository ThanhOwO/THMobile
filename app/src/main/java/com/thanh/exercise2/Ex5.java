package com.thanh.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ex5 extends AppCompatActivity {

    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.vn"));

                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+84)123456789"));

                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+84)123456789"));

                Intent intent4 = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));

                Intent intent5 = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
                intent5.putExtra("sms_body", "Thu bay nay di choi khong?");

                Intent intent6 = new Intent();
                intent6.setType("image/pictures/*");
                intent6.setAction(Intent.ACTION_GET_CONTENT);

                Intent intent7 = new Intent("android.intent.action.MUSIC_PLAYER");

                String url = "http://maps.google.com/maps?"+ "saddr=9.938083,- 84.054430&daddr=9.926392,-84.055964";
                Intent intent8 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));


                startActivity(intent8);
            }
        });
    }
}