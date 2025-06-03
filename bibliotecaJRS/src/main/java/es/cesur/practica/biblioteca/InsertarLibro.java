package es.cesur.practica.biblioteca;

import java.sql.*;
import java.util.Scanner;

public class InsertarLibro {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // Scanner para leer datos desde teclado
            // Conexión a la base de datos bibliotecaJRS
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            // Bucle para insertar 5 libros
            for (int i = 0; i < 5; i++) {
                // Pedimos los datos del libro al usuario por consola
                System.out.print("Introduce título: ");
                String titulo = sc.nextLine();

                System.out.print("Introduce editorial: ");
                String editorial = sc.nextLine();

                System.out.print("Introduce número de páginas: ");
                int paginas = Integer.parseInt(sc.nextLine());

                System.out.print("Introduce año: ");
                int anio = Integer.parseInt(sc.nextLine());

                // Creamos una sentencia preparada para insertar los datos en la tabla
                PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO librosJRS (titulo, editorial, paginas, anio) VALUES (?, ?, ?, ?)"
                );
                ps.setString(1, titulo);      // Asignamos el título
                ps.setString(2, editorial);   // Asignamos la editorial
                ps.setInt(3, paginas);        // Asignamos el número de páginas
                ps.setInt(4, anio);           // Asignamos el año de publicación
                ps.executeUpdate();           // Ejecutamos la inserción

                System.out.println("Libro insertado.\n");
            }

            conn.close(); // Cerramos la conexión a la base de datos
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos cualquier error que ocurra
        }
    }
}

