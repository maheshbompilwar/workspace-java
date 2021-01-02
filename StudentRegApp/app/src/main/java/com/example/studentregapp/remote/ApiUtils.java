package com.example.studentregapp.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.43.214:8080/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}