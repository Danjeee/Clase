package com.example.ejercicios1fx_javierse;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;

    public static void a() {
    }

    @FXML
    private void handleClosing() {
        Stage stage = (Stage) apellidos.getScene().getWindow();
        stage.setOnCloseRequest(e -> cerrarapp());
    }

    @FXML
    protected void send() {
        handleClosing();
        if (nombre.getText().equals("") || apellidos.getText().equals("")) {
            error();
        } else {
            confirmacion();
        }
    }

    @FXML
    protected void clean() {
        nombre.setText("");
        apellidos.setText("");
        handleClosing();
    }

    @FXML
    protected void error() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Debes introducir nombre y apellido");
        alert.showAndWait();
    }
    @FXML
    protected void cerrarapp() {
        handleClosing();
        Stage stage = (Stage) apellidos.getScene().getWindow();
        if (!nombre.getText().equals("") || !apellidos.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Quieres salir de la aplicación?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                stage.close();
            }
        } else {
            stage.close();
        }
    }

    @FXML
    protected void confirmacion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("Has introducido los siguientes datos: " + "\n Nombre: " + nombre.getText()
                + "\n Apellidos: " + apellidos.getText());
        alert.showAndWait();
    }
}