package jav.se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {
    @FXML
    private TableView tabla;
    @FXML
    private MenuButton menu;
    @FXML
    private MenuItem articles;
    @FXML
    private MenuItem fabricantes;
    private String actualTable = "";

    @FXML
    public void test(){
        Connection con = conect();
        tab(con, "fabricantes");
    }

    @FXML
    public void initialize() {
        Connection con = conect();
        tab(con, "articles");

    }

    private static Connection conect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/tiendainformatica", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    @FXML
    public void tabPress(ActionEvent e){
        MenuItem m = (MenuItem) e.getSource();
        String mm = m.getId();
        Connection con = conect();
        tab(con, mm);
        menu.setDisable(true);
        menu.setOpacity(0);

    }
    public void tab(Connection con, String a) {
        try {
            tabla.getColumns().clear();
            tabla.getItems().clear();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " +a);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            for (int i = 1; i <= columnas; i++) {
                TableColumn<Article, String> c = new TableColumn<>(rsmd.getColumnName(i).toUpperCase());
                c.setCellValueFactory(new PropertyValueFactory<>(rsmd.getColumnName(i)));
                tabla.getColumns().add(c);
            }
            while (rs.next()) {
                if (a.equals("articles")) {
                    actualTable = "articles";
                    tabla.getItems().add(new Article((int)rs.getObject(1),(String)rs.getObject(2),(int)rs.getObject(3),(int)rs.getObject(4)));
                } else {
                    actualTable = "fabricantes";
                    tabla.getItems().add(new Fabricante((int)rs.getObject(1),(String)rs.getObject(2)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void mostrarMenu(){
        menu.setDisable(false);
        menu.setOpacity(1);
    }
}
