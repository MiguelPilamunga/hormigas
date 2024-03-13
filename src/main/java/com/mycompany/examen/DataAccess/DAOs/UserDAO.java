package com.mycompany.examen.DataAccess.DAOs;

import com.mycompany.examen.DataAccess.DTOs.UserDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends GenericDAO<UserDTO> {
    private static final String TABLE_NAME = "users";
    private static final String INSERT_QUERY = "INSERT INTO users (username, password, first_name, last_name) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ? WHERE id = ?";
    // Otros queries necesarios para operaciones CRUD en usuarios

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected UserDTO mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        UserDTO user = new UserDTO();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        return user;
    }

    @Override
    protected String generateInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected void setParametersForInsert(PreparedStatement statement, UserDTO entity) throws SQLException {
        statement.setString(1, entity.getUsername());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getFirstName());
        statement.setString(4, entity.getLastName());
    }

    @Override
    protected String generateUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected void setParametersForUpdate(PreparedStatement statement, UserDTO entity) throws SQLException {
        statement.setString(1, entity.getUsername());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getFirstName());
        statement.setString(4, entity.getLastName());
        statement.setInt(5, entity.getId());
    }
}
