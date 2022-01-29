package com.example.finalpreparation;

import static com.example.finalpreparation.R.id.exit_button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button toasters;
    Button exit_button;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toasters =findViewById(R.id.button);
        toasters.setOnClickListener(view -> {
            LayoutInflater toast=getLayoutInflater();
            View myToast=toast.inflate(R.layout.toast_layout, null );
            Toast toast1=new Toast(this);
            toast1.setView(myToast);
            toast1.setDuration(Toast.LENGTH_SHORT);
            toast1.show();
            Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);
        });
       exit_button=findViewById(R.id.exit_button);
       exit_button.setOnClickListener(view -> {
           AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
           builder.setMessage("Do You want to exit the application?");
       });
    }
}