import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Feedback {

    public Scene createFeedbackScene(Stage primaryStage) {
        // Judul Feedback
        Label feedbackTitle = new Label("Beri Ulasan Anda");
        feedbackTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");
        HBox feedbackTitleContainer = new HBox();
        feedbackTitleContainer.setAlignment(Pos.CENTER);
        feedbackTitleContainer.getChildren().add(feedbackTitle); 


        // Slider untuk skor ulasan
        Label scoreLabel = new Label("Skor (1-5):");
        scoreLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        Slider scoreSlider = new Slider(1, 5, 3);  // Default di 3
        scoreSlider.setMajorTickUnit(1);
        scoreSlider.setMinorTickCount(0);
        scoreSlider.setSnapToTicks(true);
        scoreSlider.setShowTickLabels(true);
        scoreSlider.setShowTickMarks(true);

        // TextArea untuk komentar
        Label commentLabel = new Label("Komentar:");
        commentLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        TextArea commentArea = new TextArea();
        commentArea.setPromptText("Tulis komentar Anda di sini...");
        commentArea.setWrapText(true);

        // Tombol untuk mengirim ulasan
        Button submitFeedbackButton = new Button("Kirim Ulasan");
        submitFeedbackButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        // Tombol untuk melewati ulasan
        Button skipFeedbackButton = new Button("Lewati");
        skipFeedbackButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");


        // Layout untuk feedback scene
        VBox feedbackLayout = new VBox(15, feedbackTitleContainer, scoreLabel, scoreSlider, commentLabel, commentArea, submitFeedbackButton, skipFeedbackButton);
        feedbackLayout.setPadding(new Insets(20));
        feedbackLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");

        Scene feedbackScene = new Scene(feedbackLayout, 500, 400);

        // Logika tombol
        submitFeedbackButton.setOnAction(e -> {
            String feedbackMessage = "Terima kasih atas ulasan Anda!\n" + "Skor: " + (int) scoreSlider.getValue() + "\n" + "Komentar: " + commentArea.getText();
            showAlert(Alert.AlertType.INFORMATION, "Ulasan Terkirim", feedbackMessage);

            // Kembali ke menu utama setelah ulasan
            primaryStage.setScene(new TicketBooking().createTicketScene(primaryStage));
        });

        skipFeedbackButton.setOnAction(e -> {
            // Langsung kembali ke menu utama
            primaryStage.setScene(new TicketBooking().createTicketScene(primaryStage));
        });


        return feedbackScene;
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
    
        // Styling dialog
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #D1E7DD; -fx-border-color: #0F5132; -fx-border-width: 2px; -fx-padding: 10;"); // Background hijau muda dengan border hijau gelap
    
        // Mengubah warna teks pada konten
        dialogPane.lookupAll(".content.label").forEach(node ->
            node.setStyle("-fx-text-fill: #0F5132; -fx-font-weight: bold;") // Teks hijau gelap dengan tebal
        );
    
        // Mengubah warna tombol
        dialogPane.lookupButton(ButtonType.OK).setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;"); // Tombol hijau gelap dengan teks putih
    
        alert.showAndWait();
    }
    
}