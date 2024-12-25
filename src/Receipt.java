import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Receipt {

    public Scene createReceiptScene(Stage primaryStage, String receiptDetails) {
        // Scene Struk Pembelian Tiket
        Label receiptTitle = new Label("Struk Pembelian Tiket");
        receiptTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        // TextArea untuk menampilkan struk pembelian
        TextArea receiptArea = new TextArea(receiptDetails);
        receiptArea.setEditable(false);  // Agar user tidak bisa mengedit struk
        receiptArea.setWrapText(true);  // Agar teks tidak keluar dari area
        
        // Tombol untuk menuju ke feedback scene
        Button feedbackButton = new Button("Beri Ulasan");
        feedbackButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        // Layout dan scene untuk struk
        VBox receiptLayout = new VBox(15, receiptTitle, receiptArea, feedbackButton);
        receiptLayout.setPadding(new Insets(20));

        Scene receiptScene = new Scene(receiptLayout, 400, 300);

        // Logika untuk menuju ke feedback scene
        feedbackButton.setOnAction(e -> {
        });
        
        return receiptScene;
    }
}