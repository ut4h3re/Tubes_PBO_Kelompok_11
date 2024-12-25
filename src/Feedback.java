import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Feedback {

    public Scene createFeedbackScene(Stage primaryStage) {
        // Judul Feedback
        Label feedbackTitle = new Label("Beri Ulasan Anda");
        feedbackTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        // Slider untuk skor ulasan
        Label scoreLabel = new Label("Skor (1-5):");
        Slider scoreSlider = new Slider(1, 5, 3);  // Default di 3
        scoreSlider.setMajorTickUnit(1);
        scoreSlider.setMinorTickCount(0);
        scoreSlider.setSnapToTicks(true);
        scoreSlider.setShowTickLabels(true);
        scoreSlider.setShowTickMarks(true);

        // TextArea untuk komentar
        Label commentLabel = new Label("Komentar:");
        TextArea commentArea = new TextArea();
        commentArea.setPromptText("Tulis komentar Anda di sini...");
        commentArea.setWrapText(true);

        // Layout untuk feedback scene
        VBox feedbackLayout = new VBox(15, feedbackTitle, scoreLabel, scoreSlider, commentLabel, commentArea);
        feedbackLayout.setPadding(new Insets(20));

        Scene feedbackScene = new Scene(feedbackLayout, 400, 300);

        return feedbackScene;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}