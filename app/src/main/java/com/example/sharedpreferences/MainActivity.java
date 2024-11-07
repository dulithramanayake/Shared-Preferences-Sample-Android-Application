package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button Save, Load;
    EditText Name,Age;

    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Save=findViewById(R.id.btnSave);
        Load=findViewById(R.id.btnLoad);
        Name=findViewById(R.id.txtName);
        Age=findViewById(R.id.txtAge);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if (Age.getText().toString().equals("") && Name.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Enter Your Name and Age ", Toast.LENGTH_SHORT).show();
                } else if (Age.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Your Age ", Toast.LENGTH_SHORT).show();
                } else if (Name.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Enter Your Name ", Toast.LENGTH_SHORT).show();
                }
                else {

                    name = Name.getText().toString();
                    age = Integer.parseInt(Age.getText().toString());

                    SharedPreferences prf=getSharedPreferences("details",MODE_PRIVATE);
                    SharedPreferences.Editor editor=prf.edit();
                    editor.putString("name",name);
                    editor.putInt("age",age);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();
                }
            }
        });

        Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prf=getSharedPreferences("details",MODE_PRIVATE);

                String name=prf.getString("name","no name");
                int age=prf.getInt("age",0);

                Toast.makeText(getApplicationContext(), "Your Name:"+name+" Your Age:"+age, Toast.LENGTH_LONG).show();

;            }
        });

    }
}