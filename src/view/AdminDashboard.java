////package view;
////import view.Main;
////import controller.UserController;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.scene.control.Label;
////import javafx.scene.layout.VBox;
////import javafx.stage.Stage;
////
////public class AdminDashboard {
////
////    private final UserController userController;
////    private final String currentUsername;
////
////    public AdminDashboard(UserController userController, String username) {
////        this.userController = userController;
////        this.currentUsername = username;
////    }
////
////    public void start(Stage primaryStage) {
////        // Create UI components
////        Label welcomeLabel = new Label("Welcome Admin: " + currentUsername);
////        Button viewUsersButton = new Button("View All Users");
////        Button manageUsersButton = new Button("Manage Users");
////        Button logoutButton = new Button("Logout");
////
////        // Add action to "View All Users" button
////        viewUsersButton.setOnAction(e -> {
////            System.out.println("Viewing all users...");
////            // Implement or navigate to the "View Users" screen here
////        });
////
////        // Add action to "Manage Users" button
////        manageUsersButton.setOnAction(e -> {
////            System.out.println("Managing users...");
////            // Implement or navigate to the "Manage Users" screen here
////        });
////
////        // Add action to "Logout" button
////        logoutButton.setOnAction(e -> {
////            primaryStage.close(); // Close the current stage (Admin Dashboard)
////
////            // Start the login screen
////            view.Main mainApp = new Main();
////            Stage loginStage = new Stage();
////            mainApp.start(loginStage); // Start the login screen in a new stage
////        });
////
////        // Create layout and set spacing
////        VBox layout = new VBox(10, welcomeLabel, viewUsersButton, manageUsersButton, logoutButton);
////
////        // Create the scene and set it to the stage
////        Scene scene = new Scene(layout, 300, 200);
////        primaryStage.setTitle("Admin Dashboard");
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////}
//
//package view;
//
//import controller.UserController;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import view.Main; // Ensure the correct package is referenced
//import model.User; // Assuming you have a User model
//
//import java.util.List;
//
//public class AdminDashboard {
//
//    private final UserController userController;
//    private final String currentUsername;
//
//    public AdminDashboard(UserController userController, String username) {
//        this.userController = userController;
//        this.currentUsername = username;
//    }
//
//    public void start(Stage primaryStage) {
//        // Create UI components
//        Label welcomeLabel = new Label("Welcome Admin: " + currentUsername);
//        Button viewUsersButton = new Button("View All Users");
//        Button viewTechniciansButton = new Button("View Technicians");
//        Button viewNormalUsersButton = new Button("View Normal Users");
//        Button logoutButton = new Button("Logout");
//
//        // Add action to "View All Users" button
//        viewUsersButton.setOnAction(e -> {
//            System.out.println("Viewing all users...");
//            // Implement or navigate to the "View Users" screen here
//            showAllUsers();
//        });
//
//        // Add action to "View Technicians" button
//        viewTechniciansButton.setOnAction(e -> {
//            System.out.println("Viewing all technicians...");
//            showTechnicians();
//        });
//
//        // Add action to "View Normal Users" button
//        viewNormalUsersButton.setOnAction(e -> {
//            System.out.println("Viewing all normal users...");
//            showNormalUsers();
//        });
//
//        // Add action to "Logout" button
//        logoutButton.setOnAction(e -> {
//            primaryStage.close(); // Close the current stage (Admin Dashboard)
//            // Start the login screen
//            Main mainApp = new Main();
//            Stage loginStage = new Stage();
//            mainApp.start(loginStage); // Start the login screen in a new stage
//        });
//
//        // Create layout and set spacing
//        VBox layout = new VBox(10, welcomeLabel, viewUsersButton, viewTechniciansButton, viewNormalUsersButton, logoutButton);
//
//        // Create the scene and set it to the stage
//        Scene scene = new Scene(layout, 300, 250);
//        primaryStage.setTitle("Admin Dashboard");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void showAllUsers() {
//        List<User> users = userController.getAllUsers(); // Fetch all users
//        displayUserList(users, "All Users");
//    }
//
//    private void showTechnicians() {
//        List<User> technicians = userController.getTechnicians(); // Fetch technicians
//        displayUserList(technicians, "Technicians");
//    }
//
//    private void showNormalUsers() {
//        List<User> normalUsers = userController.getNormalUsers(); // Fetch normal users
//        displayUserList(normalUsers, "Normal Users");
//    }
//
//    private void displayUserList(List<User> users, String title) {
//        Stage userStage = new Stage();
//        ListView<User> userListView = new ListView<>();
//        userListView.getItems().addAll(users); // Add users to the ListView
//
//        // Create a scene for the user list
//        VBox userLayout = new VBox(10, new Label(title), userListView);
//        Scene userScene = new Scene(userLayout, 300, 400);
//        userStage.setTitle(title);
//        userStage.setScene(userScene);
//        userStage.show();
//    }
//}

package view;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import view.Main; // Ensure the correct package is referenced
import model.User; // Assuming you have a User model

import java.util.List;

public class AdminDashboard {

    private final UserController userController;
    private final String currentUsername;

    public AdminDashboard(UserController userController, String username) {
        this.userController = userController;
        this.currentUsername = username;
    }

    public void start(Stage primaryStage) {
        // Create UI components
        Label welcomeLabel = new Label("Welcome Admin: " + currentUsername);
        Button viewUsersButton = new Button("View All Users");
        Button viewTechniciansButton = new Button("View Technicians");
        Button viewNormalUsersButton = new Button("View Normal Users");
        Button logoutButton = new Button("Logout");

        // Add action to "View All Users" button
        viewUsersButton.setOnAction(e -> showAllUsers());

        // Add action to "View Technicians" button
        viewTechniciansButton.setOnAction(e -> showTechnicians());

        // Add action to "View Normal Users" button
        viewNormalUsersButton.setOnAction(e -> showNormalUsers());

        // Add action to "Logout" button
        logoutButton.setOnAction(e -> {
            primaryStage.close(); // Close the current stage (Admin Dashboard)
            // Start the login screen
            Main mainApp = new Main();
            Stage loginStage = new Stage();
            mainApp.start(loginStage); // Start the login screen in a new stage
        });

        // Create layout and set spacing
        VBox layout = new VBox(10, welcomeLabel, viewUsersButton, viewTechniciansButton, viewNormalUsersButton, logoutButton);

        // Create the scene and set it to the stage
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAllUsers() {
        List<User> users = userController.getAllUsers(); // Fetch all users
        displayUserList(users, "All Users");
    }

    private void showTechnicians() {
        List<User> technicians = userController.getTechnicians(); // Fetch technicians
        displayUserList(technicians, "Technicians");
    }

    private void showNormalUsers() {
        List<User> normalUsers = userController.getNormalUsers(); // Fetch normal users
        displayUserList(normalUsers, "Normal Users");
    }

    private void displayUserList(List<User> users, String title) {
        Stage userStage = new Stage();
        TableView<User> userTableView = new TableView<>();

        // Create columns for the TableView
        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        // Add columns to the TableView
        userTableView.getColumns().add(usernameColumn);
        userTableView.getColumns().add(roleColumn);

        // Add users to the TableView
        userTableView.getItems().addAll(users);

        // Create layout and set spacing
        VBox userLayout = new VBox(10, new Label(title), userTableView);
        Scene userScene = new Scene(userLayout, 300, 400);
        userStage.setTitle(title);
        userStage.setScene(userScene);
        userStage.show();
    }
}