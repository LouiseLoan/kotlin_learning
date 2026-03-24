package com.example.kotlinlearning.test1;

// JAVA
public class JavaUserProfile {
    private String name;
    private String email;
    private String phoneNumber; // peut être null

    public JavaUserProfile(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getDisplayInfo() {
        if (phoneNumber != null) {
            return name + " — " + email + " — " + phoneNumber;
        } else {
            return name + " — " + email + " — Pas de téléphone";
        }
    }

    public int getPhoneLength() {
        if (phoneNumber != null) {
            return phoneNumber.length();
        }
        return 0;
    }
}
