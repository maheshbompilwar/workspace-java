package com.example.studentregapp.service;

import android.util.Log;

import com.example.studentregapp.StudentDetailsActivity;
import com.example.studentregapp.UpdateStudentActivity;
import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.remote.APIService;
import com.example.studentregapp.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteStudentService {

    static APIService mAPIService = ApiUtils.getAPIService();

    static boolean submitStatus = false;

    private static String TAG = "DeleteStudentActivity";

    public static void deleteStudent(Student student, final StudentDetailsActivity context) {

        Log.i(TAG, "student--------------------." + student);
        Log.i(TAG, "mAPIService--------------------." + mAPIService);

        mAPIService.deleteStudent(student.getId()).enqueue(new Callback<Message>() {

            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Log.i(TAG, "in onResponse--------------------." + response);
                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Registration submitted to Server." + response.body().toString());
                    submitStatus = true;

                    context.callBackDelete(submitStatus, response.body());

                } else {
                    Log.i(TAG, "in response else--------------------." + response);
                    submitStatus = false;
                    if (response != null) {
                        Log.i(TAG, "Registration Data Response unsuccessful." + response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.i(TAG, "Unable to submit Registration Data to Server.");
                submitStatus = false;

            }
        });
    }

    public static void showResponse(String response) {
        Log.i(TAG, "success: " + response);
    }
}
