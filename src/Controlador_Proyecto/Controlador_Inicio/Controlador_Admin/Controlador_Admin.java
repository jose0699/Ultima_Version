/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio.Controlador_Admin;

//Controladores
import Controlador_Proyecto.Controlador_Inicio.Controlador_Login;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Principal.Controlado_Personaje;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Principal.Controlador_Admind_Usuario;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Principal.Controlador_Medio;
import Controlador_Proyecto.Controlador_Inicio.Controlador_Principal.Controlador_Persona;
//Fin de controladores

//Modelos
import Modelo.ConexionBD;
import Modelo.DAO_Usuario;
import Modelo.Dao_Admin;
//Fin de Modelos

//Vistas
import Vista.Login;
//Vista para los principales CRUD
import Vista.Admin.Principal;
import Vista.Admin.Medio;
import Vista.Admin.Persona;
import Vista.Admin.Personaje;
import Vista.Admin.Principal;
import Vista.Admin.Usuario;
//Vista para los principales CRUD
//Fin de Vistas

//Librerias
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Fin de Librerias
/**
 *
 * @author José Luis López
 */
public class Controlador_Admin implements ActionListener {
    private Principal principal;
    
    //Instanciar los modelos
        ConexionBD co= new ConexionBD();
        DAO_Usuario du= new DAO_Usuario();
        Dao_Admin da= new Dao_Admin();
    //Fin de instanciar los modelos
        
    public Controlador_Admin(Principal principal) {
        this.principal = principal;
        
        //Botones
        this.principal.Medio.addActionListener(this);
        this.principal.Persona.addActionListener(this);
        this.principal.Personaje.addActionListener(this);
        this.principal.Usuario.addActionListener(this);
        this.principal.Salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==principal.Medio){
            Medio me= new Medio();
            Controlador_Medio cm= new Controlador_Medio(me);
            me.setVisible(true);
            principal.setVisible(false);
        }
        
        if(ae.getSource()==principal.Persona){
            Persona per= new Persona();
            Controlador_Persona cper= new Controlador_Persona(per);
            per.setVisible(true);
            principal.setVisible(false);
        }
        
        if(ae.getSource()==principal.Personaje){
            Personaje pe= new Personaje();
            Controlado_Personaje cp= new Controlado_Personaje(pe);
            pe.setVisible(true);
            principal.setVisible(false);
        }
        
        if(ae.getSource()==principal.Usuario){
            Usuario us= new Usuario();
            Controlador_Admind_Usuario cdu = new Controlador_Admind_Usuario(us);
            us.setVisible(true);
            principal.setVisible(false);
        }
        
        if(ae.getSource()== principal.Salir){
            Login login=new Login();
            Controlador_Login cl= new Controlador_Login(login);
            login.setVisible(true);
            principal.setVisible(false);
        }
    
    }
}
