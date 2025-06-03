package es.cesur.practica.biblioteca;

import java.sql.*;
import java.util.Scanner;

public class EliminarLibro {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Conexión a la base de datos bibliotecaJRS
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            // Solicitamos al usuario el ID del libro que desea eliminar
            System.out.print("ID del libro a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            // Preparamos la sentencia SQL para eliminar el libro con el ID indicado
            PreparedStatement ps = conn.prepareStatement("DELETE FROM librosJRS WHERE id = ?");
            ps.setInt(1, id); // Asignamos el ID al parámetro de la consulta
            int filas = ps.executeUpdate(); // Ejecutamos la eliminación

            // Mostramos cuántos libros han sido eliminados
            System.out.println("Libros eliminados: " + filas);

            conn.close(); // Cerramos la conexión
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos errores si ocurren
        }
    }
}


