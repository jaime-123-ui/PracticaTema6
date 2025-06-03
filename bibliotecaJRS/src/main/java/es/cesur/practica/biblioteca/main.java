package es.cesur.practica.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        try {
            // Conectamos al servidor localhost para Dbeaver
        	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            Statement stmt = conn.createStatement();

            // Creamos la base de datos
            String sql = "CREATE DATABASE bibliotecaJRS"; 
            stmt.executeUpdate(sql);
            System.out.println("Base de datos creada correctamente.");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
