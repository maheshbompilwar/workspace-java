package com.techdenovo.studentregistration.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="mobile_no")
    private String mobileNo;

    @Column(name="email_id")
    private String emailId;

    @Column(name="password")
    private String password;

    @Column(name="BRANCH_NAME")
    private String branchName;

    @Enumerated(EnumType.STRING)
    @Column(name="YEAR")
    private Year year;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, String mobileNo, String emailId, String password, String branchName, Year year) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.password = password;
        this.branchName = branchName;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getBranchName() {
        return branchName;
    }

    public Year getYear() {
        return year;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", branchName='" + branchName + '\'' +
                ", year=" + year +
                '}';
    }
}
