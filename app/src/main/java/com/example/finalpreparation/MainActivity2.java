package com.example.finalpreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
     Button toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toast=findViewById(R.id.button2);
        toast.setOnClickListener(view -> {
            Toast.makeText(this,"toast popped", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}