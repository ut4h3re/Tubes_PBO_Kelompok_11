import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Random;

public class TicketBooking {

    public Scene createTicketScene(Stage primaryStage) {
        Label title = new Label("TicketVibe");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill:rgb(204, 114, 137)");

        HBox titleContainer= new HBox();
        titleContainer.setAlignment(Pos.CENTER); // Align title to the center
        titleContainer.getChildren().add(title);        


        Label nameLabel = new Label("Nama Pelanggan:");
        nameLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        TextField nameField = new TextField();
        nameField.setPromptText("Masukkan nama pelanggan");

        Label concertLabel = new Label("Pilih Konser:");
        concertLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        ComboBox<String> concertComboBox = new ComboBox<>();
        concertComboBox.getItems().addAll("Coldplay", "BTS", "Taylor Swift", "Juicy Luicy", "Bernadya", "Daniel Caesar");
        concertComboBox.setStyle("-fx-background-color:rgb(204, 114, 137); -fx-text-fill: white; -fx-font-weight: bold;");

        Label categoryLabel = new Label("Pilih Kategori Tiket:");
        categoryLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("VIP - Rp 2,000,000", "Gold - Rp 1,500,000", "Silver - Rp 1,000,000", "Brown - Rp 500,000");
        categoryComboBox.setStyle("-fx-background-color:rgb(204, 114, 137); -fx-text-fill: white; -fx-font-weight: bold;");

        Label ticketLabel = new Label("Jumlah Tiket:");
        ticketLabel.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        TextField ticketField = new TextField();
        ticketField.setPromptText("Masukkan jumlah tiket");

        Label totalPriceLabel = new Label("Total Harga: Rp 0");
        totalPriceLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill:rgb(204, 114, 137);");

        Button buyButton = new Button("Beli Tiket");
        buyButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox ticketLayout = new VBox(15);
        ticketLayout.setPadding(new Insets(20));
        ticketLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");
        ticketLayout.getChildren().addAll(titleContainer, nameLabel, nameField, concertLabel, concertComboBox, categoryLabel, categoryComboBox, ticketLabel, ticketField, totalPriceLabel, buyButton);

        Scene ticketScene = new Scene(ticketLayout, 600, 450);

        // Scene Metode Pembayaran
        Label paymentTitle = new Label("Metode Pembayaran");
        paymentTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");

        HBox paymentTitleContainer = new HBox();
        paymentTitleContainer.setAlignment(Pos.CENTER); // Align title to the center
        paymentTitleContainer.getChildren().add(paymentTitle);        

        RadioButton mBankingPayment = new RadioButton("M-Banking");
        mBankingPayment.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        RadioButton eWalletPayment = new RadioButton("E-Wallet");
        eWalletPayment.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        ToggleGroup paymentGroup = new ToggleGroup();
        mBankingPayment.setToggleGroup(paymentGroup);
        eWalletPayment.setToggleGroup(paymentGroup);
    
        Button confirmPaymentMethod = new Button("Pilih Metode");
        confirmPaymentMethod.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToTicketButton = new Button("Kembali ke Pemesanan");
        backToTicketButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox paymentLayout = new VBox(15, paymentTitleContainer, mBankingPayment, eWalletPayment, confirmPaymentMethod, backToTicketButton);
        paymentLayout.setPadding(new Insets(20));
        paymentLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");
    

        Scene paymentScene = new Scene(paymentLayout, 500, 400);

        // Scene Penyedia Pembayaran
        Label subOptionTitle = new Label("Pilih Penyedia Pembayaran");
        subOptionTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");

        HBox subOptionTitleContainer = new HBox();
        subOptionTitleContainer.setAlignment(Pos.CENTER); // Align title to the center
        subOptionTitleContainer.getChildren().add(subOptionTitle);        

        ComboBox<String> subOptionCombo = new ComboBox<>();
        Button confirmSubOption = new Button("Konfirmasi");
        confirmSubOption.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToPaymentButton = new Button("Kembali ke Metode Pembayaran");
        backToPaymentButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox subOptionLayout = new VBox(15, subOptionTitleContainer, subOptionCombo, confirmSubOption, backToPaymentButton);
        subOptionLayout.setPadding(new Insets(20));
        subOptionLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");

        Scene subOptionScene = new Scene(subOptionLayout, 500, 400);

        // Scene Virtual Account
        Label vaTitle = new Label("Nomor Virtual Account");
        vaTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: rgb(204, 114, 137)");

        HBox vaTitleContainer = new HBox();
        vaTitleContainer.setAlignment(Pos.CENTER);
        vaTitleContainer.getChildren().add(vaTitle); 

        TextArea vaDetails = new TextArea();
        vaDetails.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill:black");
        vaDetails.setEditable(false);

        Button completePaymentButton = new Button("Sudah Melakukan Pembayaran");
        completePaymentButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button changePaymentButton = new Button("Ubah Metode Pembayaran");
        changePaymentButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button cancelOrderButton = new Button("Batalkan Pesanan");
        cancelOrderButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox vaLayout = new VBox(15, vaTitleContainer, vaDetails, completePaymentButton, changePaymentButton, cancelOrderButton);
        vaLayout.setPadding(new Insets(20));
        vaLayout.setStyle("-fx-background-color:rgb(226, 209, 215)");

        Scene vaScene = new Scene(vaLayout, 500, 400);

        // Navigasi Antar Scene
        buyButton.setOnAction(e -> {
            if (validateInput(nameField, concertComboBox, categoryComboBox, ticketField)) {
                primaryStage.setScene(paymentScene);
            }
        });

        confirmPaymentMethod.setOnAction(e -> {
            RadioButton selectedPayment = (RadioButton) paymentGroup.getSelectedToggle();
            if (selectedPayment != null) {
                String method = selectedPayment.getText();
                subOptionTitle.setText("Pilih Penyedia " + method);
                if (method.equals("M-Banking")) {
                    subOptionCombo.getItems().setAll("Bank BCA", "Bank Mandiri", "Bank BNI", "Bank BRI");
                } else {
                    subOptionCombo.getItems().setAll("ShopeePay", "GoPay", "Dana", "Ovo");
                }
                subOptionCombo.setStyle("-fx-background-color:rgb(204, 114, 137); -fx-text-fill: white; -fx-font-weight: bold;");
                primaryStage.setScene(subOptionScene);
            }
        });

        confirmSubOption.setOnAction(e -> {
            String subOption = subOptionCombo.getValue();
            if (subOption != null) {
                String vaNumber = "VA-" + String.format("%09d", new Random().nextInt(1_000_000_000));
                vaDetails.setText("Penyedia: " + subOption + "\nNomor Virtual Account: " + vaNumber);
                primaryStage.setScene(vaScene);
            }
        });

        completePaymentButton.setOnAction(e -> {
            String receiptDetails = "Nama Pelanggan: " + nameField.getText() + "\n" +
                                    "Konser: " + concertComboBox.getValue() + "\n" +
                                    "Kategori: " + categoryComboBox.getValue() + "\n" +
                                    "Jumlah Tiket: " + ticketField.getText() + "\n" +
                                    "Jumlah Harga: " + totalPriceLabel.getText() + "\n" +
                                    vaDetails.getText();
            Receipt receipt = new Receipt();
            Scene receiptScene = receipt.createReceiptScene(primaryStage, receiptDetails);
            primaryStage.setScene(receiptScene);    
        });

        changePaymentButton.setOnAction(e -> primaryStage.setScene(paymentScene));
        cancelOrderButton.setOnAction(e -> primaryStage.setScene(ticketScene));
        backToTicketButton.setOnAction(e -> primaryStage.setScene(ticketScene));
        backToPaymentButton.setOnAction(e -> primaryStage.setScene(paymentScene));

        // Update total harga
        categoryComboBox.setOnAction(e -> updateTotalPrice(totalPriceLabel, categoryComboBox, ticketField));
        ticketField.textProperty().addListener((observable, oldValue, newValue) -> updateTotalPrice(totalPriceLabel, categoryComboBox, ticketField));

        return ticketScene;
    }

    private void updateTotalPrice(Label totalPriceLabel, ComboBox<String> categoryComboBox, TextField ticketField) {
        try {
            String selectedCategory = categoryComboBox.getValue();
            int ticketCount = Integer.parseInt(ticketField.getText());
            int pricePerTicket = 0;

            if (selectedCategory != null) {
                if (selectedCategory.contains("VIP")) {
                    pricePerTicket = 2000000;
                } else if (selectedCategory.contains("Gold")) {
                    pricePerTicket = 1500000;
                } else if (selectedCategory.contains("Silver")) {
                    pricePerTicket = 1000000;
                } else if (selectedCategory.contains("Brown")) {
                    pricePerTicket = 500000;
                }
            }

            int totalPrice = ticketCount * pricePerTicket;
            totalPriceLabel.setText("Total Harga: Rp " + totalPrice);
        } catch (NumberFormatException e) {
            totalPriceLabel.setText("Total Harga: Rp 0");
        }
    }

    private boolean validateInput(TextField nameField, ComboBox<String> concertComboBox, ComboBox<String> categoryComboBox, TextField ticketField) {
        if (nameField.getText().isEmpty() || concertComboBox.getValue() == null || categoryComboBox.getValue() == null || ticketField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validasi Input");
            alert.setHeaderText("Input Tidak Lengkap");
            alert.setContentText("Mohon lengkapi semua field sebelum melanjutkan.");
    
            // Styling dialog
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle("-fx-background-color: rgb(226, 209, 215); -fx-border-color: white; -fx-border-width: 2px; -fx-padding: 10;"); // Latar belakang merah dengan border merah
    
            // Mengatur gaya header, konten, dan tombol agar seragam
            if (dialogPane.lookup(".header-panel") != null) {
                dialogPane.lookup(".header-panel").setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
            }
            dialogPane.lookupAll(".content.label").forEach(node ->
                node.setStyle("-fx-text-fill: red; -fx-font-weight: bold;")
            );
            dialogPane.lookupButton(ButtonType.OK).setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
    
            alert.showAndWait();
            return false;
        }
        return true;
    }
    
    
}