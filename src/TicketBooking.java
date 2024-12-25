import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Random;

public class TicketBooking {

    public Scene createTicketScene(Stage primaryStage) {
        Label title = new Label("Aplikasi Pemesanan Tiket Konser");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Label nameLabel = new Label("Nama Pelanggan:");
        TextField nameField = new TextField();
        nameField.setPromptText("Masukkan nama pelanggan");

        Label concertLabel = new Label("Pilih Konser:");
        ComboBox<String> concertComboBox = new ComboBox<>();
        concertComboBox.getItems().addAll("Coldplay", "BTS", "Taylor Swift", "Juicy Luicy", "Bernadya", "Daniel Caesar", "Master Limbad");
        concertComboBox.setStyle("-fx-background-color:rgb(184, 141, 253); -fx-text-fill: white; -fx-font-weight: bold;");

        Label categoryLabel = new Label("Pilih Kategori Tiket:");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("VIP - Rp 2,000,000", "Gold - Rp 1,500,000", "Silver - Rp 1,000,000", "Brown - Rp 500,000");
        categoryComboBox.setStyle("-fx-background-color:rgb(253, 255, 123); -fx-text-fill: white; -fx-font-weight: bold;");

        Label ticketLabel = new Label("Jumlah Tiket:");
        TextField ticketField = new TextField();
        ticketField.setPromptText("Masukkan jumlah tiket");

        Label totalPriceLabel = new Label("Total Harga: Rp 0");
        totalPriceLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Button buyButton = new Button("Beli Tiket");
        buyButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox ticketLayout = new VBox(15);
        ticketLayout.setPadding(new Insets(20));
        ticketLayout.getChildren().addAll(title, nameLabel, nameField, concertLabel, concertComboBox, categoryLabel, categoryComboBox, ticketLabel, ticketField, totalPriceLabel, buyButton);

        Scene ticketScene = new Scene(ticketLayout, 450, 450);

        // Scene Metode Pembayaran
        Label paymentTitle = new Label("Metode Pembayaran");
        RadioButton mBankingPayment = new RadioButton("M-Banking");
        RadioButton eWalletPayment = new RadioButton("E-Wallet");
        ToggleGroup paymentGroup = new ToggleGroup();
        mBankingPayment.setToggleGroup(paymentGroup);
        eWalletPayment.setToggleGroup(paymentGroup);

        Button confirmPaymentMethod = new Button("Pilih Metode");
        confirmPaymentMethod.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToTicketButton = new Button("Kembali ke Pemesanan");
        backToTicketButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox paymentLayout = new VBox(15, paymentTitle, mBankingPayment, eWalletPayment, confirmPaymentMethod, backToTicketButton);
        paymentLayout.setPadding(new Insets(20));

        Scene paymentScene = new Scene(paymentLayout, 400, 300);

        // Scene Penyedia Pembayaran
        Label subOptionTitle = new Label("Pilih Penyedia Pembayaran");
        ComboBox<String> subOptionCombo = new ComboBox<>();
        Button confirmSubOption = new Button("Konfirmasi");
        confirmSubOption.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToPaymentButton = new Button("Kembali ke Metode Pembayaran");
        backToPaymentButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox subOptionLayout = new VBox(15, subOptionTitle, subOptionCombo, confirmSubOption, backToPaymentButton);
        subOptionLayout.setPadding(new Insets(20));

        Scene subOptionScene = new Scene(subOptionLayout, 400, 300);

        // Scene Virtual Account
        Label vaTitle = new Label("Nomor Virtual Account");
        TextArea vaDetails = new TextArea();
        vaDetails.setEditable(false);

        Button completePaymentButton = new Button("Sudah Melakukan Pembayaran");
        completePaymentButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Button changePaymentButton = new Button("Ubah Metode Pembayaran");
        changePaymentButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button cancelOrderButton = new Button("Batalkan Pesanan");
        cancelOrderButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox vaLayout = new VBox(15, vaTitle, vaDetails, completePaymentButton, changePaymentButton, cancelOrderButton);
        vaLayout.setPadding(new Insets(20));

        Scene vaScene = new Scene(vaLayout, 400, 300);

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
                subOptionCombo.setStyle("-fx-background-color:rgb(184, 141, 253); -fx-text-fill: white; -fx-font-weight: bold;");
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
            alert.showAndWait();
            return false;
        }
        return true;
    }
}