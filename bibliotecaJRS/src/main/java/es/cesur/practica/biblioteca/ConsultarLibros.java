package es.cesur.practica.biblioteca;

import java.sql.*;

public class ConsultarLibros {
    public static void main(String[] args) {
        try {
            // Conexión a la base de datos bibliotecaJRS
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            // Creamos un Statement para ejecutar consultas
            Statement stmt = conn.createStatement();

            // Ejecutamos la consulta para obtener todos los registros de la tabla librosJRS
            ResultSet rs = stmt.executeQuery("SELECT * FROM librosJRS");

            // Recorremos el resultado y mostramos los datos de cada libro
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Editorial: " + rs.getString("editorial"));
                System.out.println("Páginas: " + rs.getInt("paginas"));
                System.out.println("Año: " + rs.getInt("anio"));
                System.out.println("------");
            }

            // Cerramos la conexión
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos errores si ocurren
        }
    }
}


