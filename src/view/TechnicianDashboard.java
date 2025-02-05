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

import model.User;

import java.util.List;

public class TechnicianDashboard {

    private final UserController userController;
    private final String currentUsername;

    public TechnicianDashboard(UserController userController, String username) {
        this.userController = userController;
        this.currentUsername = username;
    }

    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label("Welcome Technician: " + currentUsername);
        Button viewNormalUsersButton = new Button("View Normal Users");
        Button logoutButton = new Button("Logout");

        // Action to view normal users
        viewNormalUsersButton.setOnAction(e -> showNormalUsers());

        // Action to logout
        logoutButton.setOnAction(e -> {
            primaryStage.close(); // Close the dashboard
            new Main().start(new Stage()); // Redirect to login
        });

        VBox layout = new VBox(10, welcomeLabel, viewNormalUsersButton, logoutButton);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setTitle("Technician Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
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