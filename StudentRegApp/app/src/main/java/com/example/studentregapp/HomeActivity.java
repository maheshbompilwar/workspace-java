package com.example.studentregapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btRegister;
    Button btStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btRegister = findViewById(R.id.bt_register_HA);
        btStudentList = findViewById(R.id.bt_Student_list_HA);
    }

    public void onButtonClick(View v) {
        if(v== btRegister){
            Intent intent = new Intent(HomeActivity.this, RegistrationActivity.class);
            startActivity(intent);
        }else if(v== btStudentList){
            Intent intent = new Intent(HomeActivity.this, StudentListActivity.class);
            startActivity(intent);
        }
    }


}