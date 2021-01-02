package com.example.studentregapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.service.DeleteStudentService;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView tvRollNo;
    TextView tvName;
    TextView tvEmail;

    Button btUpdate;
    Button btCancel;
    Button btDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_deatails);

        tvName = findViewById(R.id.tv_Name_SDA);
        tvRollNo = findViewById(R.id.tv_Roll_No_SDA);
        tvEmail = findViewById(R.id.tv_email_SDA);

        btUpdate = findViewById(R.id.bt_update_SDA);
        btCancel = findViewById(R.id.bt_Cancel_SDA);
        btDelete = findViewById(R.id.bt_delete_SDA);

        Intent intent = getIntent();
        Student student = intent.getExtras().getParcelable("Student");

        setProfileData(student);
        buttonClick(student);
    }

    void setProfileData(Student student){



        if(student.getName()!=null) {
            tvName.setText(student.getName());
        }else {
            tvName.setText("");
        }

        if(student.getRollNo()!=0) {
            tvRollNo.setText(""+student.getRollNo());
        }
        if(student.getEmail()!=null) {
            tvEmail.setText(student.getEmail());
        }

    }

    void buttonClick(final Student student){
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentDetailsActivity.this, UpdateStudentActivity.class);
                intent.putExtra("Student", (Parcelable) student);
                startActivity(intent);
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StudentDetailsActivity.this, StudentListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeleteStudentService.deleteStudent(student, StudentDetailsActivity.this);

//                Intent intent = new Intent(StudentDetailsActivity.this, StudentListActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);

            }
        });
    }

    public void callBackDelete(boolean status, Message message) {
        if (status) {
            Toast.makeText(this, " "+message, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(StudentDetailsActivity.this, StudentListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}