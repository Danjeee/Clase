package vuelos_javierse;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    private String fichero = "./src/main/resources/vuelos_javierse/flights.txt";
    @FXML
    private ChoiceBox<String> menu;
    @FXML
    private TableView table;
    @FXML
    private TextField nom;
    @FXML
    private TextField des;
    @FXML
    private TextField fec;
    @FXML
    private TextField dur;

    private ArrayList<Vuelo> leer(String fichero) {
        ArrayList<Vuelo> a = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fichero);
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String[] b = sc.nextLine().split(";");
                String nom = b[0];
                String des = b[1];
                LocalDateTime fec = LocalDateTime.parse(b[2], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                String dur = b[3];
                Vuelo v = new Vuelo(nom, des, fec, dur);
                a.add(v);
            }
            sc.close();
            return a;
        } catch (IOException e) {
            System.out.println(e);
        }
        return a;
    }
    private void escribirVuelo(ArrayList<Vuelo> vuelos, String fich){
        try {
            FileWriter fw = new FileWriter(fich);
            for (Vuelo i : vuelos){
                fw.write(i.getNum()+";"+i.getDest()+";"+i.getFec()+";"+i.getDur()+"\n");
            }
            fw.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @FXML
    private void borrarVuelo(){
        ArrayList<Vuelo> vuelos = leer(this.fichero);
        for (int i = 0; i<vuelos.size(); i++){
            if (vuelos.get(i).getNum().equals(nom.getText())) {
                vuelos.remove(i);
            }
        }
        escribirVuelo(vuelos, this.fichero);
        crearTabla(this.fichero);
    }

    private void crearTabla(String fich) {
        table.getColumns().clear();
        table.getItems().clear();
        TableColumn<Vuelo, String> num = new TableColumn<>("Flight Number");
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        table.getColumns().add(num);

        TableColumn<Vuelo, String> dest = new TableColumn<>("Destination");
        dest.setCellValueFactory(new PropertyValueFactory<>("dest"));
        table.getColumns().add(dest);

        TableColumn<Vuelo, String> fec = new TableColumn<>("Departure");
        fec.setCellValueFactory(new PropertyValueFactory<>("fec"));
        table.getColumns().add(fec);

        TableColumn<Vuelo, String> dur = new TableColumn<>("Duration");
        dur.setCellValueFactory(new PropertyValueFactory<>("dur"));
        table.getColumns().add(dur);
        ArrayList<Vuelo> vuelos = leer(fich);
        for (Vuelo i : vuelos) {
            table.getItems().add(i);
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
    private void addVuelo() {
        Boolean corr = true;
        ArrayList<Vuelo> vuelos = leer(this.fichero);
        if (nom.getText().isEmpty() || des.getText().isEmpty() || fec.getText().isEmpty() || dur.getText().isEmpty()) {
            Alert a = alerta("ERROR", "Información faltante", "Error", "Falta informacion por rellenar");
            corr = false;
            a.showAndWait();
        } else {
            if (nom.getText().length() != 6) {
                Alert a = alerta("ERROR", "Numero invalido", "Error", "El numero de vuelo debe tener 6 caracteres");
                corr = false;
                a.showAndWait();
            }
            for (Vuelo i : vuelos){
                if (i.getNum().equals(nom.getText())) {
                    Alert a = alerta("ERROR", "Numero invalido", "Error", "Numero duplicado");
                    corr = false;
                    a.showAndWait();
                }
            }
            LocalDateTime fecha = null;
            try {
                fecha = LocalDateTime.parse(fec.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            } catch (Exception e) {
                Alert a = alerta("ERROR", "Fecha invalida", "Error", "La fecha esta mal escrita");
                corr = false;
                a.showAndWait();
            }
            Pattern p = Pattern.compile("\\d\\d:\\d\\d");
            Matcher m = p.matcher(dur.getText());
            if (!m.matches()) {
                Alert a = alerta("ERROR", "Duracion invalida", "Error", "La duracion esta mal escrita");
                corr = false;
                a.showAndWait();
            }
        }
        if (corr) {
            vuelos.add(new Vuelo(nom.getText(), des.getText(), LocalDateTime.parse(fec.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), dur.getText()));
            escribirVuelo(vuelos, this.fichero);
            crearTabla(this.fichero);
        }
    }
    @FXML
    private void setActualVuelo(){
        Vuelo v = (Vuelo)table.getSelectionModel().getSelectedItem();
        nom.setText(v.getNum());
        des.setText(v.getDest());
        fec.setText(v.getFec());
        dur.setText(v.getDur());
    }
    @FXML
    public void todos(){
        crearTabla(this.fichero);
    }
    @FXML
    public void ciudadSel(){
        ArrayList<Vuelo> vuelos = leer(this.fichero);
        String ciudad = des.getText();
        System.out.println(ciudad);
        for (int i = 0; i<vuelos.size(); i++){
            if (!vuelos.get(i).getDest().equals(ciudad)) {
                vuelos.remove(i);
                i -= 1;
            }
        }
        String fich = "./src/main/resources/vuelos_javierse/actualcity.txt";
        escribirVuelo(vuelos, fich);
        crearTabla(fich);
    }
    @FXML
    public void largos(){
        ArrayList<Vuelo> vuelos = leer(this.fichero);
        for (int i = 0; i<vuelos.size(); i++){
            if (LocalDateTime.parse(vuelos.get(i).getDur(), DateTimeFormatter.ofPattern("HH:mm")).getHour() < 3) {
                vuelos.remove(i);
                i -= 1;
            }
        }
        String fich = "./src/main/resources/vuelos_javierse/largos.txt";
        escribirVuelo(vuelos, fich);
        crearTabla(fich);
    }
    @FXML
    public void filter(){
        String filter = menu.getSelectionModel().getSelectedItem();
        switch (filter) {
            case "Todos":
                crearTabla(this.fichero);
                break;
            case "Ciudad sel":
                ciudadSel();
                break;
            case "Largos":
                largos();
                break;
            default:
                break;
        }
    }

    @FXML
    public void initialize() {
        crearTabla(this.fichero);
        menu.getItems().add("Todos");
        menu.getItems().add("Ciudad sel");
        menu.getItems().add("Largos");
        menu.getItems().add("Proximos");
        menu.getItems().add("Dur media");
    }

}
