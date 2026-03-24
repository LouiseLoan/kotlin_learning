package com.example.kotlinlearning.test3;

public class JavaNetworkResult {
    private boolean success;
    private String data;
    private String errorMessage;
    private int errorCode;

    // Constructeur succès
    public static JavaNetworkResult success(String data) {
        JavaNetworkResult r = new JavaNetworkResult();
        r.success = true;
        r.data = data;
        return r;
    }

    // Constructeur erreur
    public static JavaNetworkResult error(String message, int code) {
        JavaNetworkResult r = new JavaNetworkResult();
        r.success = false;
        r.errorMessage = message;
        r.errorCode = code;
        return r;
    }

    public void handle() {
        if (success) {
            System.out.println("Données reçues : " + data);
        } else {
            System.out.println("Erreur " + errorCode + " : " + errorMessage);
        }
    }
}
