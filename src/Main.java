import controller.AuthController;
import controller.UserController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.AdminDashboard;
import view.NormalUserDashboard;
import view.TechnicianDashboard;

public class Main extends Application {
    private AuthController authController;
    private UserController userController;


    @Override
    public void start(Stage primaryStage) {
        authController = new AuthController();
        userController = new UserController();

        // Login UI
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Password");
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            model.User user = authController.login(username, password);
            if (user != null) {
                primaryStage.close();
                switch (user.getRole()) {
                    case "Admin":
                        new AdminDashboard(userController, username).start(new Stage());
                        break;
                    case "Technician":
                        new TechnicianDashboard(userController, username).start(new Stage());
                        break;
                    case "Normal User":
                        new NormalUserDashboard(userController, username).start(new Stage());
                        break;
                }
            } else {
                messageLabel.setText("Invalid login. Please try again.");
            }
        });

        VBox loginLayout = new VBox(10, usernameField, passwordField, loginButton, messageLabel);
        Scene loginScene = new Scene(loginLayout, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}