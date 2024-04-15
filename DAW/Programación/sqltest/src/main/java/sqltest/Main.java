package sqltest;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con = conectar();
        realizarConsulta(con);

    }
    static Connection conectar(){
        Connection a = null;
        try{
            a = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4000/empleados", "root","");
            
        }catch(SQLException e){
            System.out.println(e.getErrorCode());
        }
        return a;
    }
    private static void realizarConsulta(Connection con) {
        try {
        // Ejecuta la consulta
        Statement s = con.createStatement();
        String var = "3";
        s.executeUpdate("UPDATE articles SET precio=2 WHERE CLAVE_ARTICULO="+var);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM articles");
        // Procesa los resultados
        while (rs.next()) {
        String nombre = rs.getString("precio");
        System.out.println(nombre);
        }//Cerrar la conexión
        con.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }   
    }
}