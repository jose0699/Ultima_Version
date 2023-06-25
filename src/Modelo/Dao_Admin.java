/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;


//Librerias

//Fin de librerias
/**
 *
 * @author José Luis López
 */
public class Dao_Admin {
    
    //Comienzo de inserciones 
    
        public void insertarMembresia(String tipoMembresia , float tarifa, String descripcion, boolean termino) { // comienzo de la insercion de membresia
    String url = "jdbc:postgresql://localhost:5432/nombre_de_la_base_de_datos";
    String usuario = "usuario";
    String contrasena = "contraseña";
    String sql = "INSERT INTO Membresia (Tipo_Membresia, Tarifa, Descripcion, fecha_fin) VALUES (?, ?, ?,?)";
  
    try (Connection conn = DriverManager.getConnection(url, usuario, contrasena);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, tipoMembresia);
        stmt.setFloat(2, tarifa);
        stmt.setString(3, descripcion);
        Timestamp fechaFin = null; // declarar la variable fechaFin y asignarle el valor null
        if (termino == true) {
            fechaFin = new Timestamp(System.currentTimeMillis()); // asignar la fecha y hora actual en formato timestamp si termino es 1
        }
        stmt.setTimestamp(4, fechaFin); // agregar fecha y hora actual o null como parámetro en el PreparedStatement
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al insertar membresía: " + e.getMessage());
    }
} // Aqui termina la insercion de membresia
    // fin de inserciones
        
   
    //Fin de Delete
}
