package com.mycompany.examen.businessLogic;

public class AuthenticationManager {
    private static AuthenticationManager instance;
    private boolean isAuthenticated = false;

    private AuthenticationManager() {
        // Constructor privado para evitar la instanciación directa
    }

    public static AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}
