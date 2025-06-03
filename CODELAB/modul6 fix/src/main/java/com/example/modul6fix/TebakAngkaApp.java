package com.example.modul6fix;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaApp extends Application {
    private int angkaAcak;
    private int jumlahPercobaan;
    private Label labelFeedback;
    private Label labelPercobaan;
    private TextField inputTebakan;
    private Button tombolAksi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Inisialisasi awal
        mulaiPermainanBaru();

        // Komponen UI
        Label judul = new Label("🔄 Tebak Angka 1–100");
        judul.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #0033cc;");

        labelFeedback = new Label("Masukkan tebakkanmu!");
        labelPercobaan = new Label("Jumlah percobaan: 0");

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka di sini");

        tombolAksi = new Button("Coba Tebak!");
        tombolAksi.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");

        tombolAksi.setOnAction(e -> prosesTebakan());

        // Layout input dan tombol
        HBox hBoxInput = new HBox(10, inputTebakan, tombolAksi);
        hBoxInput.setStyle("-fx-alignment: center;");

        // Layout utama
        VBox root = new VBox(10, judul, labelFeedback, hBoxInput, labelPercobaan);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-background-color: #eaf4ff;");

        Scene scene = new Scene(root, 350, 220);
        stage.setTitle("Tebak Angka");
        stage.setScene(scene);
        stage.show();
    }

    private void mulaiPermainanBaru() {
        angkaAcak = new Random().nextInt(100) + 1;
        jumlahPercobaan = 0;
    }

    private void prosesTebakan() {
        String input = inputTebakan.getText();
        try {
            int tebakan = Integer.parseInt(input);
            jumlahPercobaan++;
            if (tebakan < angkaAcak) {
                labelFeedback.setText("⚠ Terlalu kecil!");
            } else if (tebakan > angkaAcak) {
                labelFeedback.setText("⚠ Terlalu besar!");
            } else {
                labelFeedback.setText("✅ Tebakan benar!");
                tombolAksi.setText("Main Lagi");
                tombolAksi.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
                tombolAksi.setOnAction(e -> resetGame());
            }
        } catch (NumberFormatException e) {
            labelFeedback.setText("🚫 Masukkan angka yang valid!");
        }

        labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);
        inputTebakan.clear();
    }

    private void resetGame() {
        mulaiPermainanBaru();
        labelFeedback.setText("Masukkan tebakkanmu!");
        labelPercobaan.setText("Jumlah percobaan: 0");
        tombolAksi.setText("Coba Tebak!");
        tombolAksi.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        tombolAksi.setOnAction(e -> prosesTebakan());
    }
}