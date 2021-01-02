package com.example.studentregapp.remote;

import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @POST("add-student")
    Call<Message> registerStudent(@Body Student student);

    @PUT("update-student")
    Call<Student> updateStudent(@Body Student student);

    @GET("get-students")
    Call<List<Student>> getStudents();

//    @GET("get-Student")
//    Call<Student> getStudent(@Query("id") String id);

    @DELETE("delete-student/{id}")
    Call<Message> deleteStudent(@Path("id") long id);
}



