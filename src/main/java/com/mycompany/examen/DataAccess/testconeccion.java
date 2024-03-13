package com.mycompany.examen.DataAccess;

import com.mycompany.examen.businessLogic.LoginService;

public class testconeccion {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        String username = "usuario_prueba";
        String password = "contraseña";

        boolean isAuthenticated = loginService.authenticate(username, password);

        if (isAuthenticated) {
            System.out.println("Inicio de sesión exitoso para el usuario: " + username);
        } else {
            System.out.println("Error: Nombre de usuario o contraseña incorrectos");
        }
    }
}
