import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Membuat instance LoginAndRegister dan meneruskan primaryStage
        LoginAndRegister loginAndRegister = new LoginAndRegister(primaryStage);

        // Menampilkan scene login pertama kali
        primaryStage.setScene(loginAndRegister.getLoginScene());
        primaryStage.setTitle("Aplikasi Tiket Konser ♫ 🎸🎧🎹");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
