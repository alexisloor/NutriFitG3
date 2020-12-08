/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.io.Serializable;

/**
 *
 * @author Ana Vargas
 */
public abstract class Cliente implements Serializable {
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String telefonos;
    protected CorreoElectronico correos;
    protected String direccion;
    protected Suscripcion suscripcion;

    public Cliente(String cedula, String nombres, String apellidos, String telefonos, CorreoElectronico correos, String direccion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonos = telefonos;
        this.correos = correos;
        this.direccion = direccion;
    }
    
    public void agregarSuscripcion(Suscripcion sus){
        this.suscripcion = sus;
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public CorreoElectronico getCorreos() {
        return correos;
    }

    public void setCorreos(CorreoElectronico correos) {
        this.correos = correos;
    }

    public String getDireccion() {
        return direccion;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Integer.parseInt(this.cedula);
        return hash;
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return !(this.cedula == null ? other.cedula != null : !this.cedula.equals(other.cedula));
    }

    @Override
    public String toString() {
        return "Cedula:" + cedula + "\nNombres: " + nombres + "\nApellidos: " + apellidos + 
                "\nTelefonos: " + telefonos + "\nCorreos: " + correos.getCorreoCliente() + "\nDireccion: " + direccion + "\n";
    }
        

}
