package com.example.firebasebacked;

public class HelperClass {
    String name,age,phoneNo,gender;

    public HelperClass(String name, String age, String phoneNo, String gender) {
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
