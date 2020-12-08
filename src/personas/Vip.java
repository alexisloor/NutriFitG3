/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.io.Serializable;
import personas.Cliente;

/**
 *
 * @author Ana Vargas
 */
public class Vip extends Cliente implements Serializable{
    private float peso;
    private float estatura;
    private int horasSemanalesEjercicio;
    private String profesion;
    private final double precio = 120;
    private static final long serialVersionUID = 771223652324028298L;

    public Vip(float peso, float estatura, int horasSemanalesEjercicio, String profesion, String cedula, String nombres, String apellidos, String telefonos, CorreoElectronico correos, String direccion) {
        super(cedula, nombres, apellidos, telefonos, correos,direccion);
        this.peso = peso;
        this.estatura = estatura;
        this.horasSemanalesEjercicio = horasSemanalesEjercicio;
        this.profesion = profesion;
        
    }

    public double calcularIMC(){
        double imc= this.peso/Math.pow(estatura, 2);
        return imc;
    }

    @Override
    public String toString() {
        return super.toString()+"Peso: "+peso+"\nEstatura: "+estatura+"\nIMC: "+this.calcularIMC() + 
                "\nHoras semanales de ejercicio: "+horasSemanalesEjercicio+"\nProfesion: "+profesion+
                "\nPago: "+precio;
    }
    
    
}
