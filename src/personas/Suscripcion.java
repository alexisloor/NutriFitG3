/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Ana Vargas
 */
public class Suscripcion implements Serializable {
    private static final long serialVersionUID = 771223652354028298L;
    private Date fechaInicio;
    private Date fechaFin;
    

    public Suscripcion(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.fechaFin=calcularFechaFinal(fechaInicio,1);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    
    private Date calcularFechaFinal(Date date, int amount){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, amount);
        return calendar.getTime();
    }

    @Override
    public String toString() {
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");

        return "Suscripcion{" + "fechaInicio = " + smp.format(fechaInicio) + ", fechaFin = " + smp.format(fechaFin) + '}';
    }
    
}
