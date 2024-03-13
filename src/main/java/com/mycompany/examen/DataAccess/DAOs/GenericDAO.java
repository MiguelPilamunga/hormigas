package com.mycompany.examen.DataAccess.DAOs;

import com.mycompany.examen.DataAccess.DTOs.UserDTO;
import com.mycompany.examen.DataAccess.SQLiteDataHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> {
    protected abstract String getTableName();
    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public void insert(T entity) throws SQLException {
        String insertQuery = "INSERT INTO " + getTableName() + " " + generateInsertQuery();
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            setParametersForInsert(statement, entity);

            statement.executeUpdate();
        }
    }

    protected abstract String generateInsertQuery();

    protected abstract void setParametersForInsert(PreparedStatement statement, T entity) throws SQLException;

    public List<T> getAll() throws SQLException {
        List<T> entities = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM " + getTableName();
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = mapResultSetToEntity(resultSet);
                entities.add(entity);
            }
        }
        return entities;
    }

    public T getById(int id) throws SQLException {
        String getByIdQuery = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(getByIdQuery)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToEntity(resultSet);
                }
            }
        }
        return null;
    }

    public void update(T entity) throws SQLException {
        String updateQuery = "UPDATE " + getTableName() + " SET " + generateUpdateQuery() + " WHERE id = ?";
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            setParametersForUpdate(statement, entity);

            statement.executeUpdate();
        }
    }

    protected abstract String generateUpdateQuery();

    protected abstract void setParametersForUpdate(PreparedStatement statement, T entity) throws SQLException;

    public void delete(int id) throws SQLException {
        String deleteQuery = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        }
    }

    public UserDTO getByUsername(String username) throws SQLException {
        String getByUsernameQuery = "SELECT * FROM " + getTableName() + " WHERE username = ?";
        try (Connection connection = SQLiteDataHelper.openConnection();
             PreparedStatement statement = connection.prepareStatement(getByUsernameQuery)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return (UserDTO) mapResultSetToEntity(resultSet);
                }
            }
        }
        return null;
    }

}
