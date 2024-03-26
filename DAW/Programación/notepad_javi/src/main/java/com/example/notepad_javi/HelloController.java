package com.example.notepad_javi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController implements Initializable{
    @FXML
    private Label narch;
    @FXML
    private TabPane cont;
    private int ntabs = 0;

    @FXML
    protected void handleClosing() {
        Stage stage = (Stage) narch.getScene().getWindow();
        stage.setOnCloseRequest(e -> exit());
    }

    @FXML
    protected void exit() {
        handleClosing();
        Stage stage = (Stage) narch.getScene().getWindow();
        if (!cont.getTabs().isEmpty()) {
            for (Tab i : cont.getTabs()){
                closeTab(i, false);
            }
            stage.close();
        }
        stage.close();
    }

    @FXML
    private Alert alerta(String tipo, String header, String tit, String cont) {
        Alert al = new Alert(AlertType.valueOf(tipo));
        al.setHeaderText(header);
        al.setTitle(tit);
        al.setContentText(cont);
        return al;
    }

    private void closeTab(Tab t, Boolean newt) {
        Alert alerta = alerta("CONFIRMATION", null, "Exit", "¿Desea guardar antes de salir?");
        alerta.showAndWait();
        if (alerta.getResult().getButtonData() == ButtonData.OK_DONE) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(null);
            try {
                FileWriter fw = new FileWriter(file);
                TextArea a = (TextArea) t.getContent();
                Scanner scan = new Scanner(a.getText());
                while (scan.hasNextLine()) {
                    fw.write(scan.nextLine() +"\n");
                }
                fw.close();
                scan.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            cont.getTabs().remove(t);
            if (newt = true) {
                ntabs--;
            }
        }

    }

    @FXML
    protected void open() {
        handleClosing();
        Stage stage = (Stage) narch.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Elija el archivo");
        File file = fileChooser.showOpenDialog(stage);
        narch.setText(file.getName());
        try {
            TextArea a = new TextArea();
            Tab t1 = new Tab(file.getName(), a);
            cont.getTabs().add(t1);
            t1.setOnCloseRequest(e -> closeTab(t1, false));
            a.setText("");
            FileReader fr = new FileReader(file);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                a.appendText(String.valueOf(sc.nextLine()) + "\n");
            }
            fr.close();
            sc.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    protected void changename(){
        narch.setText(cont.getSelectionModel().getSelectedItem().getText());
    }

    @FXML
    protected void newfile() {
        handleClosing();
        Stage stage = (Stage) narch.getScene().getWindow();
        TextArea a = new TextArea();
        Tab t1 = new Tab("New", a);
        if (ntabs == 0) {
            narch.setText("New");
        } else {
            t1.setText("New" +ntabs);
            narch.setText("New" + ntabs);
        }
        ntabs++;
        cont.getTabs().add(t1);
        t1.setOnCloseRequest(e -> closeTab(t1, true));
        a.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cont.getSelectionModel().selectedItemProperty().addListener(
            (ChangeListener<? super Tab>) new ChangeListener<Tab>() {
                @Override
                public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) 
                {                        
                    changename();  
                }
             });
    }
    
}