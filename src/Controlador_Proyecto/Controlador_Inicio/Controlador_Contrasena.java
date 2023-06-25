/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio;

//Vistas
import Vista.Cambiar_Contrasena;
import Vista.Cambiar_Contraseña_Dos;
import Vista.Login;
//fin de vista

//Modelos
import Modelo.ConexionBD;
import Modelo.DAO_Usuario;
//Fin de modelos

//Controladores
import Controlador_Proyecto.Controlador_Inicio.Controlador_Login;
//Fin de controladores

//Librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.Random;
//Fin de librerias

/**
 *
 * @author José Luis López
 */

public class Controlador_Contrasena implements ActionListener{
    private Cambiar_Contrasena cambiar_contrasena;
    
    //Variables auxiliares
    String aux;
    boolean aux2=false;
    //Fin de variables auxiliares
    
    //Instancias
        ConexionBD co= new ConexionBD();
        DAO_Usuario du= new DAO_Usuario();
        Cambiar_Contraseña_Dos ccd= new Cambiar_Contraseña_Dos();
    //fin de instancia

    public Controlador_Contrasena(Cambiar_Contrasena cambiar_contrasena) {
        this.cambiar_contrasena = cambiar_contrasena;
        
        //Botones de Cambiar_Contraseña            
            this.cambiar_contrasena.Regresar.addActionListener(this);
            this.cambiar_contrasena.Obtener.addActionListener(this);
            this.cambiar_contrasena.Continuar.addActionListener(this);
        //Fin de botones de cambiar_Contraseña
        //Botones de Cambiar_Contraseña_Dos
            this.ccd.Regresar.addActionListener(this);
            this.ccd.Cambiar_Contraseña.addActionListener(this);
        //fin de botones de Cambiar_Contraseña_Dos
    }

     public String Obtener_Codigo() {
        String codigo = "";
            for (int i=1; i<7; i++){
            Random random = new Random();
            int numeroAleatorio = random.nextInt(10);  
            codigo=codigo+String.valueOf(numeroAleatorio);
            }
        return codigo;
    }
     
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Inicio de configuraciones de Cambiar_Contrasena
        if(ae.getSource()==cambiar_contrasena.Regresar){
            cambiar_contrasena.setVisible(false);
            Login login= new Login();
            Controlador_Login cl= new Controlador_Login(login);
            login.setVisible(true);
        }
        
        if(ae.getSource()==cambiar_contrasena.Obtener){
            aux=Obtener_Codigo();
            cambiar_contrasena.Codigo.setText(aux);
        }
        
        if(ae.getSource()==cambiar_contrasena.Continuar){
            if (cambiar_contrasena.Correo_Usuario.getText().isEmpty()){ //Verificar si coloco el correo electronico
                JOptionPane.showMessageDialog(null,"Error de campo: No coloco el Correo electronico o Usuario");
            } else {
                if (cambiar_contrasena.Codigo.getText().isEmpty()){ //Verificar que coloco el codigo
                    JOptionPane.showMessageDialog(null,"Error de campo: No coloco el Correo electronico o Usuario");
                }else{
                    if(co.verificarConexion()){//Verificar conexion con la base de datos
                        if(!aux.equals(cambiar_contrasena.Codigo.getText())){ //Verificar si el codigo son iguales
                            if(aux2){
                                JOptionPane.showMessageDialog(null,"Error: La contraseña expiro");
                            }else{
                                JOptionPane.showMessageDialog(null,"Error:Codigo Invalido "+cambiar_contrasena.Codigo.getText());
                            }
                        }else if (cambiar_contrasena.Codigo.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,"Error de campo: Codigo vacio");
                        }else {
                            if ((du.Existencia(cambiar_contrasena.Correo_Usuario.getText(),1))){//Verificar que existe usuario o Correo_Electronico
                                cambiar_contrasena.setVisible(false);
                                ccd.setVisible(true);
                                aux2=true;
                            } else{
                                if(cambiar_contrasena.Correo_Usuario.getText().endsWith("@gmail.com") ||
                                   cambiar_contrasena.Correo_Usuario.getText().endsWith("@hotmail.com") ||
                                   cambiar_contrasena.Correo_Usuario.getText().endsWith("@Outlook.com")){
                                    if(du.Existencia(cambiar_contrasena.Correo_Usuario.getText(),2)){
                                        cambiar_contrasena.setVisible(false);
                                        ccd.setVisible(true);
                                        aux2=false;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Error de exitencia: Correo electronico o Usuario no existe");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,"Error: Correo electronico invalido");
                                }                                
                            }//fin de verificar que existe usuario o Correo_Electronico
                        }//Fin de verificar si el codigo son iguales
                    }else {
                        JOptionPane.showMessageDialog(null,"Error: Desconectado con la BD");
                    }//fin de verificar conexion con la base de datos
                } //Fin de verificar que coloco el codigo
            }//Fin de verificar si coloco el correo electronico
        }
        //Fin de configuraciones de Cambiar_Contrasena
        
        //Inicio de configuraciondes de Cambiar_Contrasena_Dos
        if(ae.getSource()==ccd.Regresar){
             ccd.setVisible(false);
             cambiar_contrasena.setVisible(true);
             aux= Obtener_Codigo();
             aux2=true;
        }
         
        if(ae.getSource()==ccd.Cambiar_Contraseña){
          if(ccd.Contraseña.getText().equals(ccd.Confirma_Contraseña.getText())){ //Confirmar que las contraseñas introducidas sean iguales
              du.Cambiar_Contraseña(ccd.Contraseña.getText(), cambiar_contrasena.Correo_Usuario.getText(), aux2);
              ccd.setVisible(false);
              Login login= new Login();
              Controlador_Login cl= new Controlador_Login(login);
              login.setVisible(true);
          }else {
            JOptionPane.showMessageDialog(null,"Error: Contraseñas no coinciden");
          }//Fin de Confirmar que las contraseñas introducidas sean iguales  
        }
        //Fin de configuraciondes de Cambiar_Contrasena_Dos
    }
}
