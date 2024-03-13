package com.mycompany.examen.businessLogic;

import com.mycompany.examen.DataAccess.DAOs.UserDAO;
import com.mycompany.examen.DataAccess.DTOs.UserDTO;

import java.sql.SQLException;

public class LoginService {
    private UserDAO userDAO;

    public LoginService() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String username, String password) {
        try {
            UserDTO user = userDAO.getByUsername(username);
            if (user != null && user.getPassword().equals(password)) {

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
