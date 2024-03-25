package com.example.calculadora_javierse;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private Text text;
    @FXML
    private double resultado;

    @FXML
    protected void click(){
        text.setText("a");
    }
}