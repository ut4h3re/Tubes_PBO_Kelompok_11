import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Receipt {

    public Scene createReceiptScene(Stage primaryStage, String receiptDetails) {
        // Scene Struk Pembelian Tiket
        Label receiptTitle = new Label("Struk Pembelian Tiket");
        receiptTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");
        
        HBox receiptTitleContainer = new HBox();
        receiptTitleContainer.setAlignment(Pos.CENTER);
        receiptTitleContainer.getChildren().add(receiptTitle);

        // TextArea untuk menampilkan struk pembelian
        TextArea receiptArea = new TextArea(receiptDetails);
        receiptArea.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        receiptArea.setEditable(false);  // Agar user tidak bisa mengedit struk
        receiptArea.setWrapText(true);  // Agar teks tidak keluar dari area
        
        // Tombol untuk menuju ke feedback scene
        Button feedbackButton = new Button("Beri Ulasan");
        feedbackButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        // Layout dan scene untuk struk
        VBox receiptLayout = new VBox(15, receiptTitleContainer, receiptArea, feedbackButton);
        receiptLayout.setPadding(new Insets(20));
        receiptLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");

        Scene receiptScene = new Scene(receiptLayout, 500, 400);

        // Logika untuk menuju ke feedback scene
        feedbackButton.setOnAction(e -> {
            Feedback feedback = new Feedback();
            Scene feedbackScene = feedback.createFeedbackScene(primaryStage);
            primaryStage.setScene(feedbackScene);
        });
        
        return receiptScene;
    }
}