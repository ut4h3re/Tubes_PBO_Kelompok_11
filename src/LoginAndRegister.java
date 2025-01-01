import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class LoginAndRegister {

    private Map<String, String> userDatabase = new HashMap<>();
    private Scene loginScene;
    private Scene registerScene;

    public LoginAndRegister(Stage primaryStage) {
        initializeScenes(primaryStage);
    }

    private void initializeScenes(Stage primaryStage) {
        // Scene Login
        Label loginTitle = new Label("Login Aplikasi Tiket Konser");
        loginTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");

        Label emailLabel = new Label("Email:");
        emailLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        TextField emailField = new TextField();
        emailField.setPromptText("Masukkan email Anda");

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password Anda");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Label loginMessage = new Label();
        loginMessage.setStyle("-fx-text-fill: red;");

        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");
        loginLayout.getChildren().addAll(
                loginTitle, emailLabel, emailField,
                passwordLabel, passwordField,
                loginButton, registerButton, loginMessage
        );

        loginScene = new Scene(loginLayout, 400, 300);

        // Scene Registrasi
        Label registerTitle = new Label("Daftar Akun Baru");
        registerTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");

        Label regEmailLabel = new Label("Email:");
        regEmailLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        TextField regEmailField = new TextField();
        regEmailField.setPromptText("Masukkan email Anda");

        Label regPasswordLabel = new Label("Password:");
        regPasswordLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        PasswordField regPasswordField = new PasswordField();
        regPasswordField.setPromptText("Masukkan password Anda");

        Label confirmPasswordLabel = new Label("Konfirmasi Password:");
        confirmPasswordLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Konfirmasi password Anda");

        Button submitRegisterButton = new Button("Daftar");
        submitRegisterButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToLoginButton = new Button("Kembali");
        backToLoginButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        Label registerMessage = new Label();
        registerMessage.setStyle("-fx-text-fill: red;");

        VBox registerLayout = new VBox(10);
        registerLayout.setPadding(new Insets(20));
        registerLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");
        registerLayout.getChildren().addAll(
                registerTitle, regEmailLabel, regEmailField,
                regPasswordLabel, regPasswordField,
                confirmPasswordLabel, confirmPasswordField,
                submitRegisterButton, backToLoginButton, registerMessage
        );

        registerScene = new Scene(registerLayout, 400, 350);

        // Login Button Action
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
                System.out.println("Login berhasil!");
                TicketBooking ticketBooking = new TicketBooking();
                Scene ticketScene = ticketBooking.createTicketScene(primaryStage);
                primaryStage.setScene(ticketScene);  // Menuju ke Ticket Booking Scene
            } else {
                loginMessage.setText("Email atau Password salah!");
            }
        });

        // Register Button Action - Pindah ke Scene Registrasi
        registerButton.setOnAction(e -> primaryStage.setScene(registerScene));

        // Kembali ke Login Button Action
        backToLoginButton.setOnAction(e -> primaryStage.setScene(loginScene));

        // Submit Register Button Action
        submitRegisterButton.setOnAction(e -> {
            String email = regEmailField.getText();
            String password = regPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                registerMessage.setText("Semua field harus diisi!");
                return;
            }

            if (!password.equals(confirmPassword)) {
                registerMessage.setText("Password dan konfirmasi tidak cocok!");
                return;
            }

            if (userDatabase.containsKey(email)) {
                registerMessage.setText("Email sudah terdaftar!");
                return;
            }

            userDatabase.put(email, password);
            System.out.println("Registrasi berhasil!");
            primaryStage.setScene(loginScene);  // Kembali ke login setelah registrasi sukses
        });
    }

    // Method untuk mendapatkan scene login
    public Scene getLoginScene() {
        return loginScene;
    }

    // Method untuk mendapatkan scene registrasi
    public Scene getRegisterScene() {
        return registerScene;
    }
}
