package com.example.calculadora_javierse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Text text;
    private boolean corr;

    @FXML
    protected void click(ActionEvent event) {
        handleClosing();
        Button a = (Button) event.getSource();
        text.setText(text.getText() + a.getText());
    }

    @FXML
    protected void clear() {
        handleClosing();
        text.setText("");
    }

    @FXML
    protected void delete() {
        handleClosing();
        if (!text.getText().equals("")) {
            text.setText(text.getText().substring(0, text.getText().length() - 1));
        }
    }

    private String resultado(String n1, char op, String n2, String error) {
        handleClosing();
        double res = 0;
        try {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            switch (op) {
                case '+' -> {
                    res = num1 + num2;
                }
                case '-' -> {
                    res = num1 - num2;
                }
                case '*' -> {
                    res = num1 * num2;
                }
                case '/' -> {
                    if (n2.equals("0")) {
                        corr =  false;
                        return "Error, division por 0";
                    } else {
                        res = num1 / num2;
                    }
                }
                case '.' ->{return error;}
                default -> {
                    res = num1;
                }
            }
            return String.valueOf(res);
        } catch (Exception e) {
            corr = false;
            return error;
        }
    }

    @FXML
    private Alert alerta(String tipo, String header, String titulo, String cont) {
        Alert a = new Alert(Alert.AlertType.valueOf(tipo));
        a.setHeaderText(header);
        a.setTitle(titulo);
        a.setContentText(cont);
        return a;
    }

    @FXML
    private void handleClosing() {
        Stage stage = (Stage) text.getScene().getWindow();
        stage.setOnCloseRequest(e -> cerrarapp());
    }

    @FXML
    private void cerrarapp() {
        handleClosing();
        Stage stage = (Stage) text.getScene().getWindow();
        Alert alerta = alerta("CONFIRMATION", null, "¿Quieres salir?", "¿Estas seguro?");
        alerta.showAndWait();
        if (alerta.getResult() == ButtonType.OK) {
            stage.close();
        }
    }

    @FXML
    protected void res() {
        String error = "";
        corr = true;
        handleClosing();
        String operacion = text.getText();
        char op = ' ';
        String num1 = "";
        String num2 = "";
        boolean multi = false;
        if (operacion.substring(operacion.length() - 1, operacion.length()).matches("[0-9]*")) {
            for (int i = 0; i < operacion.length(); i++) {
                multi = false;
                boolean num1comp = false;
                boolean dot = false;
                boolean solo1 = false;
                if (operacion.charAt(0) == '-' || operacion.charAt(0) == '+') {
                    num1 += operacion.charAt(0);
                    i++;
                }
                if (operacion.charAt(0) == '*' || operacion.charAt(0) == '/') {
                    error = "Error, empieza por * o /";
                    corr = false;
                } else {
                    while (operacion.substring(i, i + 1).matches("[0-9]*") || operacion.charAt(i) == '.' && !num1comp) {
                        if (i == operacion.length() - 2 || operacion.length() == 1 || operacion.length() == 2) {
                            num1 += operacion.charAt(i);
                            if (operacion.length() != 1) {
                                num1 += operacion.charAt(i + 1);
                            }
                            solo1 = true;
                            if (operacion.charAt(i) == '.') {
                                if (dot) {
                                    error = "Error, más de un punto decimal";
                                    corr = false;
                                    break;
                                } else {
                                    dot = true;
                                }
                            }
                            break;
                        }
                        if (operacion.charAt(i) == '.') {
                            if (dot) {
                                error = "Error, más de un punto decimal";
                                corr = false;
                                break;
                            } else {
                                dot = true;
                            }
                        }
                        num1 += operacion.charAt(i);
                        i++;
                    }
                    if (solo1) {
                        text.setText(num1);
                        break;
                    }
                    dot = false;
                    num1comp = true;
                    if (i == operacion.length()) {
                        text.setText(num1);
                        break;
                    }
                    op = operacion.charAt(i);
                    i++;
                    while (operacion.charAt(i) == '-') {
                        if (op == '-') {
                            op = '+';
                            num2 = "";
                        } else {
                            num2 = "-";
                            if (op == '+') {
                                op = '-';
                            }
                        }
                        i++;
                    }
                    while (num1comp && i < operacion.length()) {
                        if (operacion.charAt(i) == '.') {
                            if (dot) {
                                error = "Error, más de un punto decimal";
                                corr = false;
                                break;
                            } else {
                                dot = true;
                            }
                        }
                        num2 += operacion.charAt(i);
                        if (!operacion.substring(i, i + 1).matches("[0-9]*") && operacion.charAt(i) != '.') {
                            num2 = num2.substring(0, num2.length() - 1);
                            operacion = String.valueOf(resultado(num1, op, num2, error))
                                    + operacion.substring(i, operacion.length());
                            text.setText(operacion);
                            num1comp = false;
                            multi = true;
                            break;
                        }
                        i++;
                    }
                    break;
                    
                }
            }
            String num2corr = "0";
            if (!multi) {
                if (corr) {
                    if (num2.length() != 0) {
                        if (num2.charAt(0) == '.') {
                            num2 = (0 + num2);
                        }
                        num2corr = "";
                        num2corr += num2.charAt(0);
                        for (int j = 1; j < num2.length(); j++) {
                            if (num2.charAt(j) == '+' || num2.charAt(j) == '-' || num2.charAt(j) == '*'
                                    || num2.charAt(j) == '/') {
                                break;
                            }
                            num2corr += num2.charAt(j);
                        }
                    }
                    if (num1.charAt(0) == '.') {
                        num1 = (0 + num1);
                    }
                    text.setText(String.valueOf(resultado(num1, op, num2corr, error)));
                } else {
                    text.setText(error);
                }
            } else {
                if (corr) {
                    res();
                } else {
                    text.setText(error);
                }
               
            }
        }
    }
}