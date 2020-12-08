/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;

import java.io.Serializable;
import operaciones.Sistema;

/**
 *
 * @author Ana Vargas
 */
public class Fresh extends Cliente implements Serializable{
    private final double precio = 70;
    private double pago = 70;
    private static final long serialVersionUID = 771223652324025287L;

    
    public Fresh(String cedula, String nombres, String apellidos, String telefonos, CorreoElectronico correos, String direccion) {
        super(cedula, nombres, apellidos, telefonos, correos, direccion);
    }
    
    public void pagarEntrega(){
        pago = precio + 30;
    }

    public double getPago() {
        return pago;
    }
    public String toString() {
        if(pago>precio){
            
            return super.toString()+"\nEntrega a Domicilio: Si"+
                "\nPago: "+pago; 
        }
        else{
            return super.toString()+"\nEntrega a Domicilio: No"+
                "\nPago: "+pago; 
        }
    }
    
}
