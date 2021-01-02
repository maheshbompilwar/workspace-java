package com.example.studentregapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.studentregapp.adapter.StudentRecyclerAdapter;
import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.service.RegistrationService;
import com.example.studentregapp.service.StudentListService;

import java.util.List;

public class StudentListActivity extends AppCompatActivity implements View.OnClickListener, StudentRecyclerAdapter.ItemClickListener{

    StudentRecyclerAdapter adapter;

    Button btHome;
    Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        btHome = findViewById(R.id.bt_home_SL);
        btRegister = findViewById(R.id.bt_register_SL);

        btHome.setOnClickListener(this);
        btRegister.setOnClickListener(this);

        StudentListService.getStudentList(this);

    }

    public void callBack(List<Student> students) {
        if (students!=null) {
            // set up the RecyclerView
            RecyclerView recyclerView = findViewById(R.id.rv_student_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new StudentRecyclerAdapter(this, students);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);

        }else {

            Toast.makeText(this, "students-null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(View view, int position) {

        Student student = adapter.getItem(position);

        Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("Student", (Parcelable) student);
        startActivity(intent);

        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        if(v==btHome){
            Intent intent = new Intent(StudentListActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if(v==btRegister){
            Intent intent = new Intent(StudentListActivity.this, RegistrationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}