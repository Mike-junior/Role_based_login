package controller;

import model.DatabaseConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
    public User login(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password); // Use hashed passwords in a real application

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Invalid credentials
    }
}