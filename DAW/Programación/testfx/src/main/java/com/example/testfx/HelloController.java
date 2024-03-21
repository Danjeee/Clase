package com.example.testfx;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbB;
    @FXML
    private RadioButton rbC;
    @FXML ToggleGroup tgRadios = new ToggleGroup();
    @FXML CheckBox cbA;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Suspende a david doichita");
        RadioButton selected = (RadioButton) tgRadios.getSelectedToggle();
        String a = "b";
        if (cbA.isSelected()) {
            a = "a";
        }
        welcomeText.setText(selected.getText() +" " +a );

    }
    @FXML
    protected void borra() {
        rbA.setVisible(false);;
    }
    public void initialize(){
        welcomeText.setText("Yi");
        rbA.setToggleGroup(tgRadios);
        rbB.setToggleGroup(tgRadios);
        rbC.setToggleGroup(tgRadios);
    }
}