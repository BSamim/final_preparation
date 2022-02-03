package com.example.finalpreparation;

import static com.example.finalpreparation.R.id.cancel_button;
import static com.example.finalpreparation.R.id.exit_button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button Add;
    ImageButton exit_button;
    EditText name;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> Array=new ArrayList<String>();
        ArrayAdapter<String> adapt=new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Array);

        Add =findViewById(R.id.button);
        name=findViewById(R.id.Name);
        list=findViewById(R.id.list_view);
        exit_button=findViewById(R.id.exit_button);
        list.setAdapter(adapt);
        Add.setOnClickListener(view -> {
            String listname= name.getText().toString();
            Array.add(listname);
            adapt.notifyDataSetChanged();
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder clickDialog= new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Change")
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setMessage("Hello")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Array.remove(pos);
                                adapt.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        clickDialog.show();

            }
        });
       exit_button.setOnClickListener(view -> {
           AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
           builder.setMessage("Do You want to exit the application?");
           builder.setTitle("Exit");
           builder.setCancelable(false);
           builder.setPositiveButton("Exit",
                   new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           finish();
                       }
                   });
           builder.setNegativeButton("Stay", null);
           builder.setNeutralButton("Whats Up", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(MainActivity.this,"Click Exit to close and Stay to stay on this page", Toast.LENGTH_LONG).show();

               }
           });
           AlertDialog alertDialog=builder.create();
           alertDialog.show();
       });

    }
}