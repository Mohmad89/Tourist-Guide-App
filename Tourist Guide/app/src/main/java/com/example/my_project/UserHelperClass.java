package com.example.my_project;

public class UserHelperClass {

    String firstName,lastName,phone,email;
    double arabicPerc,englishPerc;


    public UserHelperClass() {
    }

    public UserHelperClass(String firstName, String lastName, String phone, String email, double arabicPerc, double englishPerc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.arabicPerc = arabicPerc;
        this.englishPerc = englishPerc;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getArabicPerc() {
        return arabicPerc;
    }

    public void setArabicPerc(double arabicPerc) {
        this.arabicPerc = arabicPerc;
    }

    public double getEnglishPerc() {
        return englishPerc;
    }

    public void setEnglishPerc(double englishPerc) {
        this.englishPerc = englishPerc;
    }
}
