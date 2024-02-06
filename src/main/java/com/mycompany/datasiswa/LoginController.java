package com.mycompany.datasiswa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnlogin;

    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    
    @FXML
    void btnLoginAction(ActionEvent event)throws Exception{
        String username = txtUser.getText();
        String password = txtPass.getText();

        // Anda bisa menambahkan logika validasi login di sini
        if (isValidLogin(username, password)) {
            // Tampilkan pesan sukses atau navigasi ke layar selanjutnya
            showSuccessAlert("Login successful!");

            //method menutup form login
            
            
            //method membuka form main
            openmain();
            
        } else {
            // Tampilkan pesan kesalahan jika login tidak berhasil
            showErrorAlert("Invalid username or password!");
        }
    }

    // Metode untuk menentukan apakah login valid (contoh sederhana)
    private boolean isValidLogin(String username, String password) {
        // Gantilah ini dengan logika validasi sesuai kebutuhan aplikasi Anda
        return username.equals("admin") && password.equals("123");
    }

    // Metode untuk menampilkan pesan sukses
    private void showSuccessAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Metode untuk menampilkan pesan kesalahan
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    // Method untuk membuka Form Baru
    private void openmain(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Primary Scene");
            stage.show();

            // Tutup jendela login saat login berhasil
            ((Stage) btnlogin.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Tambahkan logika atau pesan kesalahan jika gagal membuka primary.fxml
        }
    }
    

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
