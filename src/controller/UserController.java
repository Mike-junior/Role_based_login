//
//
//package controller;
//
//import model.DatabaseConnection;
//import model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserController {
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        try (Connection conn = DatabaseConnection.getConnection()) {
//            String query = "SELECT * FROM users";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public void addUser(User user) {
//        try (Connection conn = DatabaseConnection.getConnection()) {
//            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword());
//            stmt.setString(3, user.getRole());
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUser(String username) {
//        try (Connection conn = DatabaseConnection.getConnection()) {
//            String query = "DELETE FROM users WHERE username = ?";
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setString(1, username);
//            stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateUserProfile(User userProfile) {
//    }
//
//    public User getUserProfile(String currentUsername) {
//        return null;
//    }
//
//    public List<User> getTechnicians() {
//    }
//}

package controller;

import model.DatabaseConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    // Fetch all users from the database
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    // Add a new user to the database
    public void addUser(User user) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Remove a user from the database
    public void removeUser(String username) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update a user's profile in the database
    public void updateUserProfile(User userProfile) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE users SET password = ?, role = ? WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, userProfile.getPassword());
            stmt.setString(2, userProfile.getRole());
            stmt.setString(3, userProfile.getUsername());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get a user's profile from the database
    public User getUserProfile(String currentUsername) {
        User userProfile = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, currentUsername);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userProfile = new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userProfile;
    }

    // Get a list of technicians from the database
    public List<User> getTechnicians() {
        List<User> technicians = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE role = 'Technician'"; // Adjust role name as needed
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                technicians.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return technicians;
    }

    // Get a list of normal users from the database
    public List<User> getNormalUsers() {
        List<User> normalUsers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE role = 'Normal User'"; // Adjust role name as needed
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                normalUsers.add(new User(rs.getString("username"), rs.getString("password"), rs.getString("role")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return normalUsers;
    }
}