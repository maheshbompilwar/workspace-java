package com.example.studentregapp.service;

import android.util.Log;


import com.example.studentregapp.UpdateStudentActivity;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.remote.APIService;
import com.example.studentregapp.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateStudentService {

    static APIService mAPIService = ApiUtils.getAPIService();

    static boolean submitStatus = false;

    private static String TAG = "UpdateStudentActivity";

    public static void updateStudent(Student student, final UpdateStudentActivity context) {

        Log.i(TAG, "student--------------------." + student);
        Log.i(TAG, "mAPIService--------------------." + mAPIService);

        mAPIService.updateStudent(student).enqueue(new Callback<Student>() {

            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                Log.i(TAG, "in onResponse--------------------." + response);
                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Registration submitted to Server." + response.body().toString());
                    submitStatus = true;

                    context.callBack(submitStatus, response.body());

                } else {
                    Log.i(TAG, "in response else--------------------." + response);
                    submitStatus = false;
                    if (response != null) {
                        Log.i(TAG, "Registration Data Response unsuccessful." + response.body().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.i(TAG, "Unable to submit Registration Data to Server.");
                submitStatus = false;

            }
        });
    }

    public static void showResponse(String response) {
        Log.i(TAG, "success: " + response);
    }
}
