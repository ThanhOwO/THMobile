package com.thanh.exercise4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex2 extends Activity implements View.OnClickListener {
    Button btnread,btnwrite;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        Button nextBtn = findViewById(R.id.exerciseBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ex2.this, Ex3.class);
                startActivity(intent);
            }
        });

        btnread =  findViewById(R.id.btnreaddata);
        btnwrite =  findViewById(R.id.btnwritedata);
        editdata = findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);

    }
    public void onClick(View v) {
        if (v.getId()==R.id.btnreaddata)
        {
            readData();
        }
        else if(v.getId() ==R.id.btnwritedata)
        {
            writeData();
        }
    }

    private void writeData() {
        try {
            FileOutputStream out = openFileOutput("myfile.txt", 0);
            OutputStreamWriter writer = new OutputStreamWriter(out);
            writer.write(editdata.getText().toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void readData() {
        try {
            FileInputStream in = openFileInput("myfile.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data = "";
            StringBuilder builder = new StringBuilder();
            while ((data = reader.readLine()) != null) {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            editdata.setText(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
}