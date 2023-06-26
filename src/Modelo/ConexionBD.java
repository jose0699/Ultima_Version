/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author José Luis López
 */
//Modelo
import Modelo.DAO_Usuario;
//Fin de Modelos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    public static boolean verificarConexion() {
        boolean conexionExitosa = false;
        Connection conexion = null;
        String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel"; // URL de la base de datos
        String usuario = "postgres";
        String contrasena = "joseluis0699";
        
        try {
            // Establecer conexión con la base de datos
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            conexionExitosa = true;
        } catch (SQLException e) {
            // Error al intentar conectar con la base de datos
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return conexionExitosa;
    }
}
