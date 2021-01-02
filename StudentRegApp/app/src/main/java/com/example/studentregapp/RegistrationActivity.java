package com.example.studentregapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.service.RegistrationService;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etRollNo;
    EditText etEmail;


    Button btSubmit;
    Button btCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.et_Name_RA);
        etRollNo = findViewById(R.id.et_Roll_No_RA);
        etEmail = findViewById(R.id.et_Email_RA);

        btSubmit = findViewById(R.id.bt_submit_RA);
        btCancel = findViewById(R.id.bt_cancel_RA);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btSubmit) {
            String name = etName.getText().toString();
            String rollNo = etRollNo.getText().toString();
            String email = etEmail.getText().toString();


            if (!name.equals("") && !rollNo.equals("") && !email.equals("")) {

                long rollNoLong = Long.parseLong( etRollNo.getText().toString());

                    Student student = new Student(rollNoLong, name,email);

                    Toast.makeText(this, "for sendDataToServer", Toast.LENGTH_SHORT).show();
                    RegistrationService.sendDataToServer(student, this);



            } else {
                Toast.makeText(this, " Fields cant be empty, Please fill all Fields...", Toast.LENGTH_SHORT).show();
            }

        } else if (v == btCancel) {
            etName.setText("");
            etRollNo.setText("");
            etEmail.setText("");

            Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
            startActivity(intent);

        }
    }


    public void callBack(Message message) {
        if (message.isFlag()) {
            Toast.makeText(getApplicationContext(), " Student Information Submitted Successfully...", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etRollNo.setText("");
            etEmail.setText("");

            Intent intent = new Intent(RegistrationActivity.this, StudentListActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Message: "+message.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}