package com.pedroviena.cliusuarios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pedroviena.cliusuarios.db.DatabaseConnection;
import com.pedroviena.cliusuarios.model.user;

public class UserDao {

    public void insert(user user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        }
    }

    public void update(user user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public user findById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        user user = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToUser(resultSet); // Usando o método auxiliar
                }
            }
        }
        return user;
    }

    public List<user> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        List<user> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement(); // Pode ser Statement simples
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(mapResultSetToUser(resultSet)); // Usando o método auxiliar
            }
        }
        return users;
    }

    // Método auxiliar para evitar duplicação de código
    private user mapResultSetToUser(ResultSet resultSet) throws SQLException {
        user user = new user();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        return user;
    }
}