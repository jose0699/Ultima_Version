/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio.Controlador_Principal;
//Vistas
import Vista.Usuario.Principal;
import Vista.Admin.Persona;
//Fin de vista

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author José Luis López
 */
public class Controlador_Persona implements ActionListener{
    private Persona persona;
    
    public Controlador_Persona (Persona persona){
        this.persona=persona;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
