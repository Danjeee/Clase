package com.example.ejercicios1fx_javierse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;

    @FXML
    protected void send() {
        if (nombre.getText().equals("") || apellidos.getText().equals("")) {
            confirmacion();
        }
    }
    @FXML protected void clean() {
        nombre.setText("");
        apellidos.setText("");
    }

    @FXML
    protected void confirmacion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmacion");
        alert.setContentText("¿Deseas realmente confirmar?");
        alert.showAndWait();
    }
}