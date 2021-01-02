package com.example.studentregapp.service;

import android.util.Log;


import com.example.studentregapp.RegistrationActivity;
import com.example.studentregapp.model.Message;
import com.example.studentregapp.model.Student;
import com.example.studentregapp.remote.APIService;
import com.example.studentregapp.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationService {

    static APIService mAPIService = ApiUtils.getAPIService();

    private static String TAG = "RegistrationActivity";

    public static void sendDataToServer(Student student, final RegistrationActivity context) {

        Log.i(TAG, "student--------------------." + student);
       // Log.i(TAG, "mAPIService--------------------." + mAPIService);

        mAPIService.registerStudent(student).enqueue(new Callback<Message>() {

            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Log.i(TAG, "in onResponse--------------------." + response);
                if (response.isSuccessful()) {
                    showResponse(response.body().toString());
                    if(response.body().isFlag()){
                        Log.i(TAG, "Registration submitted to Server." + response.body());
                    }else {
                        Log.i(TAG, "Registration did no submit to Server." + response.body());
                    }
                    context.callBack(response.body());

                } else {
                    Log.i(TAG, "in response else--------------------." + response);
                    if (response != null) {
                        Log.i(TAG, "Registration Data Response unsuccessful." + response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.i(TAG, "Unable to submit Registration Data to Server.");
            }
        });
    }

    public static void showResponse(String response) {
        Log.i(TAG, "success: " + response);
    }
}
