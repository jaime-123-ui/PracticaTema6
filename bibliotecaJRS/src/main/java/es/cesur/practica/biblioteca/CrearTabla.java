package es.cesur.practica.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearTabla {
    public static void main(String[] args) {
        try {
            // Nos conectamos a la base de datos 'bibliotecajrs' en el servidor local
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bibliotecajrs", "root", "123456");

            // Creamos un objeto Statement para ejecutar instrucciones SQL
            Statement stmt = conn.createStatement();

            // Definimos la sentencia SQL para crear la tabla librosJRS con los campos requeridos
            String sql = "CREATE TABLE librosJRS (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY," +  // ID autoincremental y clave primaria
                         "titulo VARCHAR(100)," +                // Campo para el título del libro
                         "editorial VARCHAR(100)," +             // Campo para la editorial
                         "paginas INT," +                        // Campo para número de páginas
                         "anio INT)";                             // Campo para el año de publicación

            // Ejecutamos la sentencia para crear la tabla
            stmt.executeUpdate(sql);
            System.out.println("Tabla creada correctamente."); // Mensaje de confirmación

            // Cerramos la conexión
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(); // Mostramos el error si ocurre
        }
    }
}


