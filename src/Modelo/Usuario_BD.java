/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author José Luis López
 */
public class Usuario_BD {
    public String usuario;
    public String correoElectronico;
    public String primerNombre;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public String contrasena;
    public String fechaNacimiento;
    public String genero;
    public String nroTarjeta;
    public int uidPais;
    public String nombre_pais;

   

    public Usuario_BD(String usuario, String correoElectronico, String primerNombre, String segundoNombre,
                   String primerApellido, String segundoApellido, String contrasena, String fechaNacimiento,
                   String genero, String nroTarjeta, int uidPais,String nombre_pais) {
        this.usuario = usuario;
        this.correoElectronico = correoElectronico;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.nroTarjeta = nroTarjeta;
        this.uidPais = uidPais;
        this.nombre_pais=nombre_pais;
    }

    // Getters y setters para las propiedades de la clase Usuario
     public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public int getUidPais() {
        return uidPais;
    }

    public void setUidPais(int uidPais) {
        this.uidPais = uidPais;
    }
}
