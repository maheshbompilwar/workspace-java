package com.example.studentregapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.service.UpdateStudentService;


public class UpdateStudentActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etRollNo;
    EditText etName;
    EditText etEmail;

    Button btSubmit;
    Button btCancel;

    private long id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        etRollNo = findViewById(R.id.et_Roll_No_USA);
        etName = findViewById(R.id.et_Name_USA);
        etEmail = findViewById(R.id.et_email_USA);


        btSubmit = findViewById(R.id.bt_submit_USA);
        btCancel = findViewById(R.id.bt_cancel_USA);

        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        Intent intent = getIntent();
        Student student = intent.getExtras().getParcelable("Student");

        id=student.getId();

        setStudentValues(student);
    }

    void setStudentValues(Student student){
        etRollNo.setText(""+student.getRollNo());
        etName.setText(student.getName());
        etEmail.setText(student.getEmail());
    }

    @Override
    public void onClick(View v){
        if(v == btSubmit){
            String rollNo = etRollNo.getText().toString();
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            if(!name.equals("") && !rollNo.equals("") && !email.equals("")){


                    if(id!=0) {
                        long rollNoLong = Long.parseLong( etRollNo.getText().toString());
                        Student student = new Student(id, rollNoLong, name, email);
                        //API CALL for update info
                        UpdateStudentService.updateStudent(student, this);
                    }

            }else {
                Toast.makeText(this, " Fields cant be empty, Please fill all Fields...", Toast.LENGTH_SHORT).show();
            }
        }else if(v == btCancel){
            etName.setText("");
            etRollNo.setText("");
            etEmail.setText("");
            onBackPressed();
        }
    }

    public void callBack(boolean status, Student student) {
        if (status) {
            Toast.makeText(this, " Student Information Updated Successfully...", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etRollNo.setText("");
            etEmail.setText("");

            Intent intent = new Intent(UpdateStudentActivity.this, StudentDetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Student", (Parcelable)student);
            startActivity(intent);
        }
    }


}