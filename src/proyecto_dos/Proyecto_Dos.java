/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_dos;

import Controlador_Proyecto.Controlador_Inicio.Controlador_Login;
import Vista.Login;

/**
 *
 * @author José Luis López
 */
public class Proyecto_Dos {

    /**
     * @param args the command line arguments
     */
    
    public void mostrarLogin() {
        Login login = new Login();
        Controlador_Login controlador = new Controlador_Login(login);
        controlador.iniciar();
    }
    
    public static void main(String[] args) {
        Proyecto_Dos proyecto = new Proyecto_Dos();
        proyecto.mostrarLogin(); 
    }
    
}
