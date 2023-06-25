/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio;

//Vista a Utilizar
import Vista.Login;
import Vista.Registrar_Usuario_Dos;
import Vista.Cambiar_Contrasena;
import Vista.Admin.Principal;
//Fin de las Vistas

//Controladores
import Controlador_Proyecto.Controlador_Inicio.Controlador_Registrar;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Admin.Controlador_Admin;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Contrasena;
//Fin de controladores

//Comienzo de modelos
import Modelo.ConexionBD;
import Modelo.DAO_Usuario;
//Fin de modelos

//Librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
//Fin de librerias
/**
 *
 * @author José Luis López
 */
public class Controlador_Login implements ActionListener{
 
    private Login login;
    
    
    //Intenacias
    ConexionBD co= new ConexionBD();
    DAO_Usuario du= new DAO_Usuario();
    //Fin de las instancias
    
    
    public Controlador_Login(Login login) {
        this.login = login;        
        //Inicio de bototes de login
        this.login.Crear_Usuario.addActionListener(this);
        this.login.Iniciar_Sesion.addActionListener(this);
        this.login.Olvido_Contrasena.addActionListener(this);
        ///fin de botones de login
        //inicio de botones de registrar
        
        //fin de botones de registrar
        //Inicio de botones de Cambiar_Contraseña
        
        //Fin de botones de cambiar contradesña
    }
  
    public void iniciar (){
        login.setTitle("Login"); //El titulo que tendra en la ventana
        login.setLocationRelativeTo(null); //Para que se inicie la ventana en el centro
        login.setResizable(false);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    if(ae.getSource()==login.Crear_Usuario){
        Registrar_Usuario_Dos rud= new Registrar_Usuario_Dos();
         Controlador_Registrar cr=new Controlador_Registrar(rud);
         rud.setVisible(true);  
         login.setVisible(false);
    }
    if(ae.getSource() == login.Iniciar_Sesion) {
        if(login.Usuario.getText().isEmpty()) {// Verifica si el campo de usuario está vacío
            JOptionPane.showMessageDialog(null,"Error de campo: Usuario vacio");   
        } else {
            if(login.Contrasena.getText().isEmpty()) {// Verifica si el campo de contraseña está vacío, Mensaje
                JOptionPane.showMessageDialog(null,"Error de campo:Contraseña vacia");
            } else {
                if (co.verificarConexion()){ //Verifica si esta abierta la conexion con la BD
                    if (du.Existencia(login.Usuario.getText(), 1) || du.Existencia(login.Usuario.getText(), 2)) { //verifica existencia del usuario
                        if(du.existe_Usuario_Y_Contraseña(login.Usuario.getText(), 
                        login.Contrasena.getText(),1) || du.existe_Usuario_Y_Contraseña(login.Usuario.getText(), 
                        login.Contrasena.getText(),2)){  //Verificar si el usuario introdujo la contraseña correcta   
                            Principal p = new Principal();
                            Controlador_Admin cp = new Controlador_Admin(p);
                            p.setVisible(true);
                            login.setVisible(false);                            
                        }else {
                            JOptionPane.showMessageDialog(null,"Error: Contraseña incorrecta");
                        }//Fin de verificar si el usuario introdujo la contraseña correcta   
                    }else {
                        JOptionPane.showMessageDialog(null,"Error de Existencia: Usuario no existe");
                    }//fin de verifica existencia del usuario    
                } else{
                    JOptionPane.showMessageDialog(null,"Error de conexion con la BD");
                }//Fin de verifica si esta abierta la conexion con la BD
            }// El campo de contraseña está vacío, Mensaje
        }// Verifica si el campo de contraseña está vacío, Mensaje
    }
   
    
        
    if(ae.getSource()==login.Olvido_Contrasena){
         Cambiar_Contrasena cc= new Cambiar_Contrasena();
         Controlador_Contrasena CC=new Controlador_Contrasena(cc);
         cc.setVisible(true);
         login.setVisible(false);         
    }
}
}