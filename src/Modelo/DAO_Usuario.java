/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

//Conexion a la base de datos
import Vista.Admin.Usuario;
//Fin de la conexion a la base de datos

//Librerias a utilizar
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.CallableStatement;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import static java.time.Clock.system;
import java.time.LocalDateTime;

import java.util.Date;

import javax.swing.JOptionPane;
//fin de librerias a utilizar
/**
 *
 * @author José Luis López
 */
public class DAO_Usuario {
    Usuario us= new Usuario();

//Aqui empieza a buscar existencia
    
public String Toma_Tu_Valor_String (String valorBuscado, int caso) {
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String sql = null;
    String valorEncontrado = null;
    String nombre = "";
    String valor = "";
    
    switch (caso) {
        case 1:
            sql = "Select Nombre from pais where uid_pais=?";
            break;
            
        case 2:
            sql = "Select correo_electronico from usuario where usuario=?";
            break;
        
        case 3:
            sql = "Select Primer_Nombre from usuario where usuario=?";
            break;
        
        case 4:
            sql = "Select Segundo_Nombre from usuario where usuario=?";
            break;
        
        case 5:
            sql = "Select Primer_Apellido from usuario where usuario=?";
            break;
        
        case 6:
            sql = "Select Segundo_Apellido from usuario where usuario=?";
            break;
        
        case 7:
            sql = "Select contrasena from usuario where usuario=?";
            break;
        
        case 8:
            sql = "Select Fecha_Nacimiento from usuario where usuario=?";
            break;
        
        case 9:
            sql = "Select Genero from usuario where usuario=?";
            break;
        
        case 10:
            sql = "Select Nro_Tarjeta from usuario where usuario=?";
            break;
        
        case 11:
            sql = "Select UID_Pais from usuario where usuario=?";
            break;
    }
    
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuario = "postgres";
    String contrasena = "joseluis0699";
    
    try {
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        consulta = conexion.prepareStatement(sql);        
        consulta.setString(1, valorBuscado);
        resultado = consulta.executeQuery(); //ejecuta el select
       
            if (caso == 13) {
                if (resultado.next()) {
                    valor = String.valueOf(resultado.getInt(1)); //Obtiene el valor y lo convierte a String
                }
            } else {         
                if (resultado.next()) {
                    valor = resultado.getString(1); //Obtiene el valor
                    return valor;
                }
            }
        
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    } finally {
        // Cerrar objetos ResultSet, PreparedStatement y Connection
    }
    
    return valor;
}

public int Toma_Tu_Valor (String valorBuscado, int caso){ // aqui simplemente busca el valor de la pk y lo convierte a string
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String sql = null;
    String valorEncontrado = null;
    String nombre="";
    int valor = 0;
    switch (caso){
        case 1:
            sql="Select UID_Pais from pais where nombre= ? ;";
            break;
        
        case 2:    
            sql="Select codigo from membresia where tipo_membresia=? and Fecha_fin is NULL";
            break;
        
        case 3:
            sql="Select Nombre from pais where uid_pais=?";
            break;
         
    }
    
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuario = "postgres";
    String contrasena = "joseluis0699";
    
    try{
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        consulta = conexion.prepareStatement(sql);        
        consulta.setString(1, valorBuscado);
        resultado = consulta.executeQuery(); //ejecuta el select
        
        if(caso>=3){
            
            if(caso==13){
                if (resultado.next()) {
                    valor = resultado.getInt(1); //Obtiene el valor 
                    return valor;
                }
            } else {         
                if (resultado.next()) {
                    nombre=resultado.getString(1);
                    valor = Integer.parseInt(nombre); //Obtiene el valor 
                    return valor;
                }
            }
            
        }else{

            if (resultado.next()) {
                valor = resultado.getInt(1); //Obtiene el valor 
                return valor;
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    } finally{
        // Cerrar objetos ResultSet, PreparedStatement y Connection
    }
    
    return valor;
}//busca el valor de la pk y lo convierte a string

    public boolean Existencia(String valorBuscado, int caso) { //Fin de verifica si existe en la tabla Usuario (Usuario o Correo) Y Pais(Nombre)
    boolean existe = false;
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado, result  = null;
    String sql = null;
    
    switch(caso){
        
        case 1: //usuario
            sql = "SELECT COUNT(*) FROM Usuario WHERE Usuario = ?";
        break;
        
        case 2: //usuario
             sql = "SELECT COUNT(*) FROM Usuario WHERE Correo_Electronico = ?";
        break;
        
        case 3: //pais
            if(valorBuscado.equals("None")){
                JOptionPane.showMessageDialog(null,"Error: Seleccionar un pais");
                return false;
            } else {
                sql = "SELECT COUNT(*) FROM Pais WHERE Nombre = ?";
            }
        break;
        
        case 4: //Color
            sql = "SELECT COUNT(*) FROM Color WHERE Nombre = ?";
            break;
            
        case 5:  //Poder
            sql = "SELECT COUNT(*) FROM Poder WHERE Nombre = ?";
            break;
            
        case 6: //Ocupacion
            sql = "SELECT COUNT(*) FROM ocupacion WHERE Nombre = ?";
            break;
            
        case 7:// Organizacion
            sql = "SELECT COUNT(*) FROM organizacion WHERE Nombre = ?";
            break;
            
        case 8: //Plataforma
            sql = "SELECT COUNT(*) FROM plataforma  WHERE Nombre = ?";
            break;
            
        /* case 9: //membresia
            sql = "SELECT Fecha_fin FROM Membresia WHERE Usuario = ? ORDER BY Fecha_inicio DESC LIMIT 1;";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, valorBuscado);
                result = statement.executeQuery();
                if (result.next()) {
                    Date fechaFin = result.getDate("Fecha_fin");
                    if (fechaFin == null) { 
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        break;*/
            
        default:
            return false;
    }
    
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuario = "postgres";
    String contrasena = "joseluis0699";
    
    try {
        // Establecer conexión con la base de datos
        conexion = DriverManager.getConnection(url, usuario, contrasena);
        
        // Preparar la consulta SQL
        consulta = conexion.prepareStatement(sql);
        consulta.setString(1, valorBuscado);
        
        // Ejecutar la consulta SQL
        resultado = consulta.executeQuery();
        

        // Obtener el resultado de la consulta
        if (resultado.next()) {
            int cantidad = resultado.getInt(1);
            existe = (cantidad > 0);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Cerrar la conexión y los recursos
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return existe;  
}//Fin de verifica si existe en la tabla Usuario (Usuario o Correo) Y Pais(Nombre)
    
   
   public boolean existe_Usuario_Y_Contraseña(String usuario, String contraseña, int caso) { //Verifica la existencia del Usuario y su Contraseña en la tabla de Usuario 
    boolean existe = false;
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String sql=null;
    switch(caso){
        case 1:
            sql = "SELECT Contrasena FROM Usuario WHERE Usuario = ?";
        break;
            
        case 2:
            sql = "SELECT Contrasena FROM Usuario WHERE Correo_Electronico = ?";
        break;
        
        default:
            return false;
    }
    
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuarioBD = "postgres";
    String contraseñaBD = "joseluis0699";
    
    try {
        conexion = DriverManager.getConnection(url, usuarioBD, contraseñaBD);
        consulta = conexion.prepareStatement(sql);
        consulta.setString(1, usuario);
        resultado = consulta.executeQuery();
        
        if (resultado.next()) {
            String contrasenaReal = resultado.getString("Contrasena");
            existe = contrasenaReal.equals(contraseña);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    return existe;
}//Fin de verifica la existencia del Usuario y su Contraseña en la tabla de Usuario    

    //Aqui terminan los procemiento para comprobar existencia(select)
    //Aqui empiezan los procedimiento para actualizar (update)
   
/*Cambiar la contraseña del usuario especifico, tienes que especificar la nueva contraseña al principio
    luego al usuario que quieres que se la cambia y por ultimo un boleano donde si es 1 cambia a traves
    del nombre de usuario y si es falso cambia a traves del correro electronico (Afecta a la tabla usuario)*/     
   public void Cambiar_Contraseña(String nueva_contraseña, String cambio, boolean tipo) {
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuarioBD = "postgres";
    String contrasenaBD = "joseluis0699";
    String sql="";
    try {
        conexion = DriverManager.getConnection(url, usuarioBD, contrasenaBD);
        if(tipo){
            sql = "UPDATE Usuario SET Contrasena = ? WHERE Usuario = ?";
        }else{
            sql = "UPDATE Usuario SET Contrasena = ? WHERE Correo_Electronico = ?";
        }
        consulta = conexion.prepareStatement(sql);
        consulta.setString(1, nueva_contraseña);
        consulta.setString(2, cambio);
        consulta.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error: No se actualizó la contraseña " + e.getMessage());
    } finally {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}//fin de cambiar la contraseña del usuario especifico

   //Aqui terminan los procedimiento para actualiza (update)
   
   //Aqui empiezas los procedimientos para insertar (insert)
   /*Nota: Lamentablemente tendre que crear un pocoton de funciones para las inserciones ya que
   como algunas tablas usan datos especificos para su tabla esta como dificil crear una generica
   pero hay algunas que si comparte el mismo diseño, como las de intercespcion que la mayoria 
   maneja dos datos, entonces  hare un listado en el siguiente comentario UwU*/
   
   /* Lista de */

//Inserta un nuevo usuario en la tabla de usuario   
public void crearNuevoUsuario(String usuario, String correoElectronico, String primerNombre,
                              String segundoNombre, String primerApellido, String segundoApellido,
                              String contrasena, String fecha, String genero, 
                              String nroTarjeta, int pais, int caso1, int caso2) {
    
    if (caso1== 1) {
        segundoNombre= null;
        if (caso2==1){
           segundoApellido= null; 
        } else{
        }
    }
    
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String sql = "INSERT INTO usuario (usuario, correo_electronico, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, contrasena, fecha_nacimiento, genero, Nro_Tarjeta, UID_Pais) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
    String usuarioBD = "postgres";
    String contrasenaBD = "joseluis0699";
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaDate = null;
    try {
        fechaDate = formato.parse(fecha);
    } catch (ParseException ex) {
        System.err.println("Error al parsear fecha: " + ex.getMessage());
        return;
    }
    try {
        conexion = DriverManager.getConnection(url, usuarioBD, contrasenaBD);
        consulta = conexion.prepareStatement(sql);
        consulta.setString(1, usuario);
        consulta.setString(2, correoElectronico);
        consulta.setString(3, primerNombre);
        consulta.setString(4, segundoNombre);
        consulta.setString(5, primerApellido);
        consulta.setString(6, segundoApellido);
        consulta.setString(7, contrasena);
        consulta.setDate(8, new java.sql.Date(fechaDate.getTime()));
        consulta.setString(9, genero);
        consulta.setString(10, nroTarjeta);
        consulta.setInt(11, pais);
        consulta.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error al crear nuevo usuario: " + e.getMessage());
    } finally {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}//Fin de insertar un nuevo usuario

public void insertar_mensaulidad(String usuario_mensualidad, int codigoMembresia){
        String url = "jdbc:postgresql://localhost:5432/Proyecto_Marvel";
        String usuarioBD = "postgres";
        String contrasenaBD = "joseluis0699";
        String sql = "iNSERT INTO Mensualidad(Fecha_inicio,Fecha_fin,usuario,Codigo) VALUES (?,NULL,?,?)";
        
    try (Connection conn = DriverManager.getConnection(url, usuarioBD, contrasenaBD);
        CallableStatement stmt = conn.prepareCall(sql)) {

        // Establecer los parámetros del procedimiento almacenado
            Timestamp fechaInicio = new Timestamp(System.currentTimeMillis());
            System.out.println (fechaInicio);        

            stmt.setTimestamp(1, fechaInicio);       
            stmt.setString(2, usuario_mensualidad);
            stmt.setInt(3, codigoMembresia);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

        } catch (SQLException e) {
            System.err.println("Error al insertar mensualidad: " + e.getMessage());
        }
}


}
