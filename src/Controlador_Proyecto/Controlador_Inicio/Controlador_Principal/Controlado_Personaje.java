/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio.Controlador_Principal;

import Vista.Admin.Personaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author José Luis López
 */
public class Controlado_Personaje implements ActionListener{
    private Personaje personaje;
    
    public Controlado_Personaje (Personaje personaje){
        this.personaje = personaje;
        
            this.personaje.Regresar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== personaje.Regresar){
            personaje.setVisible(false);        
        }  
    }
}
