package com.thanh.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.Manifest;


public class Ex5 extends AppCompatActivity {

    private Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5);

        btn = findViewById(R.id.btn);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        }
        //aa
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View website
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.vn"));

                //Call phone
                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+84)123456789"));

                //start the phone dialer
                Intent intent3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+84)123456789"));

                //default contacts app
                Intent intent4 = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));

                //Message
                Intent intent5 = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
                intent5.putExtra("sms_body", "Thu bay nay di choi khong?");

                //Get Picture
                Intent intent6 = new Intent();
                intent6.setType("image/pictures/*");
                intent6.setAction(Intent.ACTION_GET_CONTENT);

                //Music
                Intent intent7 = new Intent("android.intent.action.MUSIC_PLAYER");

                //Find the path from point A to point B
                String url = "http://maps.google.com/maps?"+ "saddr=9.938083,- 84.054430&daddr=9.926392,-84.055964";
                Intent intent8 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                //3 more intent
                //1. Intent for sending an email:
                Intent intent9 = new Intent(Intent.ACTION_SEND);
                intent9.setType("message/rfc822");
                intent9.putExtra(Intent.EXTRA_EMAIL, new String[] {"recipient@example.com"});
                intent9.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent9.putExtra(Intent.EXTRA_TEXT, "Email message body");

                //2. Intent for opening a specific location in Google Maps
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?q=Golden+Gate+Bridge,San+Francisco,CA");
                Intent intent10 = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                intent10.setPackage("com.google.android.apps.maps");

                //Intent for picking a file from the device storage
                Intent intent11 = new Intent(Intent.ACTION_GET_CONTENT);
                intent11.setType("*/*");


                startActivity(intent11);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                // Permission denied. Handle accordingly.
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}