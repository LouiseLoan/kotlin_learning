package com.example.kotlinlearning.test4;

// JAVA
public class JavaStringUtils {
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static boolean isValidEmail(String s) {
        return s != null && s.contains("@") && s.contains(".");
    }

}




// Utilisation — moche
//  StringUtils.capitalize("bonjour");
//  StringUtils.isValidEmail("loan@gmail.com");

