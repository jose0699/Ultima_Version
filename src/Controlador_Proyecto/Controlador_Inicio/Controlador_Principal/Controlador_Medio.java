/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio.Controlador_Principal;

//Vistas 
import Vista.Admin.Principal;
import Vista.Admin.Medio;
import java.awt.event.ActionEvent;
//Fin de vista
//Librerias
import java.awt.event.ActionListener;

//Finde librerias
//Fin de vistas
/**
 *
 * @author José Luis López
 */
public class Controlador_Medio implements ActionListener {
    private Medio medio;
    
    public Controlador_Medio (Medio medio){
        this.medio=medio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
