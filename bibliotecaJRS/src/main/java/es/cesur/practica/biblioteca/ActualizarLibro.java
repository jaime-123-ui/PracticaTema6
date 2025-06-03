package es.cesur.practica.biblioteca;

import java.sql.*;
import java.util.Scanner;

public class ActualizarLibro {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Conexión a la base de datos bibliotecaJRS
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            // Solicitamos al usuario el ID del libro que quiere actualizar
            System.out.print("ID del libro a actualizar: ");
            int id = Integer.parseInt(sc.nextLine());

            // Pedimos el nuevo título para el libro
            System.out.print("Nuevo título: ");
            String nuevoTitulo = sc.nextLine();

            // Creamos una sentencia preparada para actualizar el título del libro con el ID indicado
            PreparedStatement ps = conn.prepareStatement("UPDATE librosJRS SET titulo = ? WHERE id = ?");
            ps.setString(1, nuevoTitulo); // Establece el nuevo título
            ps.setInt(2, id);             // Establece el ID del libro a actualizar
            int filas = ps.executeUpdate(); // Ejecuta la actualización

            System.out.println("Libros actualizados: " + filas); // Muestra cuántos registros fueron actualizados

            conn.close(); // Cerramos la conexión
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos errores si ocurren
        }
    }
}


