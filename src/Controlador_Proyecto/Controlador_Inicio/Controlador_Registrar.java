/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador_Proyecto.Controlador_Inicio;

//Vistas a utlizar
import Vista.Login;
import Vista.Registrar_Usuario;
import Vista.Registrar_Usuario_Dos;
//Fin de vistas

// Modelos
import Modelo.DAO_Usuario;
import java.awt.event.ActionEvent;
//Fin de modelo

//Controladores
//Fin de controladores

//Librerias
import java.awt.event.ActionListener;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import java.util.Calendar;

//Fin de librerias
/**
 *
 * @author José Luis López
 */
public class Controlador_Registrar implements ActionListener {
    
    private  Registrar_Usuario_Dos registrar_usuario_dos;
    Registrar_Usuario ru= new Registrar_Usuario();
    DAO_Usuario du= new DAO_Usuario();
    
    //Variables auxiliares
    public static String genero, fecha, membresia,descripcion="";
    //fin de variables auxiliares
    
    public Controlador_Registrar(Registrar_Usuario_Dos registrar_usuario_dos) {
        this.registrar_usuario_dos = registrar_usuario_dos;
        //botones de Registrar_Usuario
        this.registrar_usuario_dos.Registrar.addActionListener(this);
        this.registrar_usuario_dos.Regresar.addActionListener(this);
        //Fin de botones de Registrar_Usuario
        //Botonoes de Registrar_Usuario_Dos
        this.ru.Continuar.addActionListener(this);
        this.ru.Regresar.addActionListener(this);
        //Fin de botonoes de Registrar_Usuario_Dos
    }
    
  
public boolean Comprobaciones (String comprobar, String campo, int caso){
   
    if((comprobar == null || comprobar.isEmpty())){ //Comprobar vacio caso 
        JOptionPane.showMessageDialog(null,"Error de campo: Falto llenar "+campo);
        return false;
    }else {
      switch(caso) { //Comienzo del switch
            
            case 1: //Caso valido solo para usuario, Primer_Nomrbre, Segundo_Nombre,Primer Appellido, Segundo_Apellido y contraseña
                if(campo.length() > 60) { //Comprueba el tamaño maximo del usuario, nombre y contraseña
                    JOptionPane.showMessageDialog(null, "Error de campo: Supero el MAX permito en " + campo);
                    return false;
                } else {
                    return true;
                }
                
            case 2: //Caso valido para correo_electronico
                if(campo.length() > 256) { //Comprueba el tamaño maximo del correo electronico
                    JOptionPane.showMessageDialog(null,"Error de campo: Supero el MAX permito en " + campo);
                    return false;
                } else {
                    if (comprobar.endsWith("@gmail.com") || comprobar.endsWith("@hotmail.com") || comprobar.endsWith("@outlook.com")) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Correo electrónico debe ser de tipo: gmail.com, Outlook.com o hotmail.com");
                        return false;
                    }     
                }
                
            case 3: //Caso para validar si el genero es el indicado
                if(comprobar.equals("None") || comprobar.equals("Femenino") || comprobar.equals("Masculino")
                   || comprobar.equals("Otros") || comprobar.equals("Desnocido")) {
               
                    /*Nota se usara una variable global para asi aprovechar la funcion
                    Femenino=F, Masculino= M, Desconocido=D
                    Otros=O y None=Error*/
                                 
                    if(comprobar.equals("Femenino")) {
                        Controlador_Registrar.genero = "F";
                        return true;
                    }
                    
                    if(comprobar.equals("Masculino")) {
                        Controlador_Registrar.genero = "M";
                        return true;
                    }
                    
                    if(comprobar.equals("Otros")) {
                        Controlador_Registrar.genero = "O";
                        return true;
                    }
                    
                    if(comprobar.equals("Desnocido")) {
                        Controlador_Registrar.genero = "D";
                        return true;
                    }
                    JOptionPane.showMessageDialog(null,"Error: Seleccionar un genero");
                    return false;
                } else {
                    JOptionPane.showMessageDialog(null,"Error de campo: Genero invalido ");
                    return false;
                }
            
            case 4: //Comrpobar si el numero de tarjeta cumple con los correquisitos del mercado
                if ((comprobar.length()>=13 && comprobar.length()<=18) && (comprobar.matches("\\d+"))){
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null,"Error: Numero de tarjeta invalido");
                    return false;
                }
            
            case 5: //Verifica el tipo de membresia para luego utilizarlo en el insert
                if(comprobar.equals("Free")) {
                        Controlador_Registrar.membresia = "F";
                        return true;
                    }
                    
                    if(comprobar.equals("Gold")) {
                        Controlador_Registrar.membresia = "G";
                        return true;
                    }
                    
                    if(comprobar.equals("Premium")) {
                        Controlador_Registrar.membresia = "P";
                        return true;
                    }
                    
                    if(comprobar.equals("Vip")) {
                        Controlador_Registrar.membresia = "V";
                        return true;
                    }
                
        default:
            JOptionPane.showMessageDialog(null,"Error Fatal");
            return false;
        } //Fin de switch       
    }//Fin de comprobar vacio     
}

public boolean validarEdad(String dia, String mes, String anio) {
    LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
    LocalDate fechaActual = LocalDate.now();
    int edad = Period.between(fechaNacimiento, fechaActual).getYears();
    if (edad < 18) {
        JOptionPane.showMessageDialog(null, "Error: Debe ser mayor de 18 años");
        return false;
    }
    return true;
}

   public boolean Fecha_Usuario(String d, String m, String a) {
       int aux= Calendar.getInstance().get(Calendar.YEAR),
           aux2=Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
           aux3=Calendar.getInstance().get(Calendar.MONTH),
           dia = Integer.parseInt(d),
           mes = Integer.parseInt(m),
           anio = Integer.parseInt(a);

       if( d.isEmpty() || m.isEmpty() || a.isEmpty()){
            JOptionPane.showMessageDialog(null,"Error: Fecha incompleta");
            return false;
      
       } else {
            if(validarEdad(d,m,a)==false ){
                return false;
            } else {
                if ((dia>=1 && dia<=31) && (mes<=12 && mes>=1)){
                    if (anio % 2 == 0 ){
                        int[] diasPorMes = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
                        if(diasPorMes[mes-1]>=dia){
                            return true; 
                        }else{
                            JOptionPane.showMessageDialog(null,"Error: Dia del mes supera lo permitido");
                            return false;
                        }
                    } else {
                        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                    
                        if(diasPorMes[mes-1]>=dia){
                            return true;
                        }else{
                            JOptionPane.showMessageDialog(null,"Error: Dia del mes supera lo permitido");
                            return false;
                        }
                    }            
                } else {
                    JOptionPane.showMessageDialog(null,"Error campo: Fecha erronea (dia, mes o año)");
                    return false;
                }
            }
       }
}
  

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Comienzo de las configuraciones de Registrar_Usuario_Usuario_Dos
           if(ae.getSource()==registrar_usuario_dos.Regresar){
                Login login= new Login();    
                Controlador_Login cl=new Controlador_Login(login);
                registrar_usuario_dos.setVisible(false);
                login.setVisible(true);
           }
           
           if(ae.getSource()==registrar_usuario_dos.Registrar){
               if(Comprobaciones(registrar_usuario_dos.Primer_Nombre.getText(),"Primer nombre", 1) &&
                  Comprobaciones(registrar_usuario_dos.Primer_Apellido.getText(),"Primer apellido", 1)){ //Comprueba el tamaño maximo y que no este vario
                    if(registrar_usuario_dos.dia.getText().isEmpty() ||
                       registrar_usuario_dos.mes.getText().isEmpty() ||
                       registrar_usuario_dos.año.getText().isEmpty()){ //Comprueba que la fecha no este varia
                            JOptionPane.showMessageDialog(null,"Error campo: Fecha no puede estar vacio");
                    }else{
                        if(!registrar_usuario_dos.dia.getText().matches("\\d+") ||
                           !registrar_usuario_dos.mes.getText().matches("\\d+") ||
                           !registrar_usuario_dos.año.getText().matches("\\d+")){ //Compruebar que introduzca valores numericos en dia, mes y año
                                JOptionPane.showMessageDialog(null,"Error campo: Solo valores numericos en fecha");
                        }else{
                            if (Fecha_Usuario(registrar_usuario_dos.dia.getText(),registrar_usuario_dos.mes.getText(),registrar_usuario_dos.año.getText())){ //Manejar que la fecha sea correcta segun el calendario greco-romano
                                if (du.Existencia ((String) registrar_usuario_dos.Pais.getSelectedItem(), 3) &&
                                    Comprobaciones((String) registrar_usuario_dos.Genero.getSelectedItem(),"Genero", 3)){//Verificar si el usuario seleccino una opcion
                                    ru.setVisible(true);
                                    registrar_usuario_dos.setVisible(false);
                                }//Verificar si el usuario seleccino una opcion
                            }//Fin de manejar que la fecha sea correcta segun el calendario greco-romano
                        }// Fin de compruebar que introduzca valores numericos en dia, mes y año
                    }//fin de comprobar que la fecha no este varia                                
                }                                               
           }
           
        //Fin de las configuraciones de Registrar_Usuario_Usuario_Dos        
        //Comienzo de las configuraciones de Registrar
        
           if(ae.getSource()==ru.Regresar){            
               ru.setVisible(false);
               registrar_usuario_dos.setVisible(true);
           }
            if(ae.getSource()==ru.Continuar){
            
                if(!du.Existencia(ru.usuario.getText(), 1)){//Validar existencia de usuario
                    if(!du.Existencia(ru.correo.getText(), 2)){ //Validar existencia de correp
                        if(Comprobaciones(ru.usuario.getText(),"Usuario",1) &&
                            Comprobaciones(ru.correo.getText(),"correo electronico",2) &&
                            Comprobaciones(ru.contraseña.getText(),"contraseña",1) &&
                            Comprobaciones(ru.Numero_Credito.getText(),"el numero tarjeta de credito invalido",4) &&
                            Comprobaciones((String) ru.Tipo_Membresia.getSelectedItem(),"contraseña",5)){ //comienzo de comprobaciones
                        
                            if(ru.correo.getText().equals(ru.Confirmar_Correo.getText())){
                                if(ru.contraseña.getText().equals(ru.confirmar_contraseña.getText())){
                                    Login login= new Login();    
                                    Controlador_Login cl = new Controlador_Login(login);
                                    ru.setVisible(false);
                                    login.setVisible(true);
                                    
                                    // Obtener la fecha actual
                                        LocalDate fechaActual = LocalDate.now();

                                    // Formatear la fecha en formato aaaa/mm/dd
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                                        String fechaActualFormateada = fechaActual.format(formatter);
                                        String fecha_nac= registrar_usuario_dos.dia.getText()+"/"+
                                                          registrar_usuario_dos.mes.getText()+"/"+
                                                          registrar_usuario_dos.año.getText();
                                        
                                        String pais_insert= (String) registrar_usuario_dos.Pais.getSelectedItem();
                                        if(registrar_usuario_dos.Segundo_Nombre.getText().isEmpty()){
                                            if (registrar_usuario_dos.Segundo_Apellido.getText().isEmpty()){
                                                
                                                du.crearNuevoUsuario(ru.usuario.getText(), ru.correo.getText(), 
                                                registrar_usuario_dos.Primer_Nombre.getText(), registrar_usuario_dos.Segundo_Nombre.getText()
                                                 , registrar_usuario_dos.Primer_Apellido.getText(), registrar_usuario_dos.Segundo_Apellido.getText(), 
                                                 ru.contraseña.getText(), fecha_nac, genero, ru.Numero_Credito.getText(), du.Toma_Tu_Valor(pais_insert, 1),1,1);
                                                du.insertar_mensaulidad(ru.usuario.getText(),du.Toma_Tu_Valor(membresia,2));
                                            } else{
                                                du.crearNuevoUsuario(ru.usuario.getText(), ru.correo.getText(), 
                                                registrar_usuario_dos.Primer_Nombre.getText(), registrar_usuario_dos.Segundo_Nombre.getText()
                                                , registrar_usuario_dos.Primer_Apellido.getText(), registrar_usuario_dos.Segundo_Apellido.getText(), 
                                                ru.contraseña.getText(), fecha_nac, genero, ru.Numero_Credito.getText(), du.Toma_Tu_Valor(pais_insert, 1),1,0);
                                                du.insertar_mensaulidad(ru.usuario.getText(),du.Toma_Tu_Valor(membresia,2));
                                            }
                                        } else{
                                            if (registrar_usuario_dos.Segundo_Apellido.getText().isEmpty()){
                                                
                                                du.crearNuevoUsuario(ru.usuario.getText(), ru.correo.getText(), 
                                                registrar_usuario_dos.Primer_Nombre.getText(), registrar_usuario_dos.Segundo_Nombre.getText()
                                                , registrar_usuario_dos.Primer_Apellido.getText(), registrar_usuario_dos.Segundo_Apellido.getText(), 
                                                ru.contraseña.getText(), fecha_nac, genero, ru.Numero_Credito.getText(), du.Toma_Tu_Valor(pais_insert, 1),0,1);
                                                du.insertar_mensaulidad(ru.usuario.getText(),du.Toma_Tu_Valor(membresia,2));
                                            } else{
                                                du.crearNuevoUsuario(ru.usuario.getText(), ru.correo.getText(), 
                                                registrar_usuario_dos.Primer_Nombre.getText(), registrar_usuario_dos.Segundo_Nombre.getText()
                                                , registrar_usuario_dos.Primer_Apellido.getText(), registrar_usuario_dos.Segundo_Apellido.getText(), 
                                                ru.contraseña.getText(), fecha_nac, genero, ru.Numero_Credito.getText(), du.Toma_Tu_Valor(pais_insert, 1),0,0);
                                                du.insertar_mensaulidad(ru.usuario.getText(),du.Toma_Tu_Valor(membresia,2));
                                            }
                                        }
                                }else{
                                    JOptionPane.showMessageDialog(null,"Error: Contraseñas diferentes");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null,"Error: Correo electronico diferentes");
                            }      
                        }// fin de comprobaciones
                    }else{
                        JOptionPane.showMessageDialog(null,"Error: Correo ya existe");
                    } //fin de validar existencia de correo                    
                }else{
                    JOptionPane.showMessageDialog(null,"Error: El usuario ya existe");
                }// Fin de  validar existencia de usuario             
           }
            
        //Fin de las configuraciones de Registrar
    }   
}
