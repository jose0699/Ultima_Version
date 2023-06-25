/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio.Controlador_Principal;

//Modelos
import Modelo.ConexionBD;
import Modelo.DAO_Usuario;
import Modelo.Dao_Admin;
import Modelo.Usuario_BD;
//Fin de modelos

//Controladores
import Controlador_Proyecto.Controlador_Inicio.Controlador_Admin.Controlador_Admin;
//Fin de controladores
//Vistas a trabajar
import Vista.Admin.Principal;
import Vista.Admin.Usuario;
//Fin de vistas

//Libreria
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JOptionPane;
//Fin de Liberia
/**
 *
 * @author José Luis López
 */


public class Controlador_Admind_Usuario implements ActionListener {
    private Usuario usuario;
    private  Usuario_BD us;
    
    
    //Instancia
        DAO_Usuario du= new DAO_Usuario();
        ConexionBD co= new ConexionBD();
        Dao_Admin da= new Dao_Admin();
    //Fin de instanciar
        
    public Controlador_Admind_Usuario(Usuario usuario) {
        
        this.usuario = usuario;
        this.us= us;
        
        //botones
            this.usuario.Buscar.addActionListener(this);
            this.usuario.Actualizar.addActionListener(this);
            this.usuario.Regresar.addActionListener(this);
            this.usuario.Eliminar.addActionListener(this);
        //fin de botones
    }
    

    public void insertar_valores(String usuario_Buscar){
        String aux="";
        usuario.Nombre.setText(usuario_Buscar);
        
        aux= du.Toma_Tu_Valor_String(usuario_Buscar,2);
        usuario.correo.setText(aux);
        
        aux= du.Toma_Tu_Valor_String(usuario_Buscar,8);
        usuario.fecha_nacimiento.setText(aux);
        
        aux= du.Toma_Tu_Valor_String(usuario_Buscar,7);
        usuario.contraseña.setText(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        //usuario.contraseña.setText(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setSegundoApellido(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setContrasena(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setFechaNacimiento(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setGenero(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setNroTarjeta(aux);
        
        aux= String.valueOf(du.Toma_Tu_Valor(usuario_Buscar,3));
        us.setNombre_pais(aux);
        
        us.setUidPais(du.Toma_Tu_Valor(usuario_Buscar,13));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== usuario.Actualizar){
        }
        if(ae.getSource()== usuario.Eliminar){
            
        }
        
        if(ae.getSource()== usuario.Buscar){
            if(!usuario.Buscar_Usuario.getText().isEmpty()){
                if(co.verificarConexion() ){ //Verificar la conexion con la BD
                    if(du.Existencia(usuario.Buscar_Usuario.getText(), 1) || 
                       du.Existencia(usuario.Buscar_Usuario.getText(), 2)){//Verificar si existe
                        insertar_valores(usuario.Buscar_Usuario.getText());
                        System.out.println (us.getContrasena());
                    }else {
                        JOptionPane.showMessageDialog(null,"Error: Usuario no existe");
                    }//Fin de verificar existencia
                }//Fin de verificar la conexion con la base de datos :p
            }
        }
        
        if(ae.getSource()== usuario.Regresar){
            Principal principal= new Principal();
            Controlador_Admin ca= new Controlador_Admin(principal);
            principal.setVisible(true);
            usuario.setVisible(false);  
        }
    }
}
