package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.sql.*;

public class PrimaryController {
    @FXML
    private TableView tab;

    private Connection conectar() {
        Connection con = null;
        try {// Establece la conexión
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/empleados", "root",
                    "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    @FXML
    private void tab() throws IOException, SQLException {
        Connection con = conectar();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM fabricantes");
        // Procesa los resultados
        while (rs.next()) {
            stmt.getco
            String nombre = rs.getString("nombre");
            System.out.println(nombre);
        }

    }

    @FXML
    private void addtodb() throws IOException {
        Statement s = null;
        Connection con = conectar();

        try {
            // Ejecuta la consulta
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fabricantes");
            // Procesa los resultados
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
