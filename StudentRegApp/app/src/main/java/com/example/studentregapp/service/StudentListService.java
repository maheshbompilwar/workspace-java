package com.example.studentregapp.service;

import android.util.Log;

import com.example.studentregapp.RegistrationActivity;
import com.example.studentregapp.StudentListActivity;
import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.remote.APIService;
import com.example.studentregapp.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListService {

    static APIService mAPIService = ApiUtils.getAPIService();

    private static String TAG = "StudentListActivity";

    public static void getStudentList(final StudentListActivity context) {

        mAPIService.getStudents().enqueue(new Callback<List<Student>>() {

            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                Log.i(TAG, "in onResponse--------------------." + response);
                if (response.isSuccessful()) {
                    showResponse(response.body().toString());

//                    if(response.body()!=null){
//                        Log.i(TAG, "Registration submitted to Server." + response.body());
//                    }else {
//                        Log.i(TAG, "Registration did no submit to Server." + response.body());
//                    }
                    context.callBack(response.body());

                } else {
                    Log.i(TAG, "in response else--------------------." + response);
                    if (response != null) {
                        Log.i(TAG, "Registration Data Response unsuccessful." + response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                Log.i(TAG, "Unable to submit Registration Data to Server.");
            }
        });
    }

    public static void showResponse(String response) {
        Log.i(TAG, "success: " + response);
    }
}
