package com.example.studentregapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Student implements Serializable, Parcelable {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("rollNo")
    @Expose
    private long rollNo;


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    public Student(long id, long rollNo, String name, String email) {
        this.id = id;
        this.rollNo=rollNo;
        this.name = name;
        this.email = email;
    }
    public Student(long rollNo, String name, String email) {

        this.rollNo=rollNo;
        this.name = name;
        this.email = email;
    }


    public Student() {
    }

    protected Student(Parcel in) {
        id = in.readLong();
        rollNo = in.readLong();
        name = in.readString();
        email = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public long getId() {
        return id;
    }

    public long getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setRollNo(long rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(rollNo);
        dest.writeString(name);
        dest.writeString(email);
    }
}
