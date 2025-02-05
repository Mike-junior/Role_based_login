package view;

import controller.UserController;
import model.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NormalUserDashboard extends Application {
    private UserController userController;
    private String currentUsername;

    // No-argument constructor
    public NormalUserDashboard() {
    }

    public NormalUserDashboard(UserController userController, String username) {
        this.userController = userController;
        this.currentUsername = username;
    }

    @Override
    public void start(Stage primaryStage) {
        // If userProfileController or currentUsername is not set, handle it
        if (userController == null || currentUsername == null) {
            System.out.println("Error: UserProfileController or username is not set.");
            return;
        }

        User user = userController.getUserProfile(currentUsername);

        Label usernameLabel = new Label("Username: " + user.getUsername());
        TextField emailField = new TextField(user.getEmail());
        Button saveButton = new Button("Update Email");
        Button logoutButton = new Button("Logout");

        saveButton.setOnAction(e -> {
            user.setEmail(emailField.getText());
            userController.updateUserProfile(user);
            System.out.println("Email updated successfully!");
        });

//        logoutButton.setOnAction(e -> {
//            primaryStage.close(); // Close the dashboard
//            new Main().start(new Stage()); // Redirect to login
//        });

        VBox layout = new VBox(10, usernameLabel, new Label("Email:"), emailField, saveButton, logoutButton);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setTitle("Normal User Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Launch method to create the dashboard with parameters
    public static void launchNormalUserDashboard(UserController userController, String username) {
        NormalUserDashboard dashboard = new NormalUserDashboard(userController, username);
        launch();
    }
}