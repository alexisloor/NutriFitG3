/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;
import interfaz.NutriFit;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import personas.*;
/**
 *
 * @author Ana Vargas
 */
public class Sistema {
    
    static Scanner sc = new Scanner(System.in);
    static Sistema s= new Sistema();
    
    public static boolean registrarCliente(){        
        System.out.println("**REGISTRO DE CLIENTES**");
        System.out.println("Cedula: ");
        String ced = sc.nextLine().trim();
        while (!s.validarEntero(ced) || ced.length()!=10) {
            System.out.println("Cedula: ");
            ced = sc.nextLine().trim();
        }
        
        if(s.validarCliente(ced)!=null){
            System.out.println("-- Cliente ya registrado --");
            return false;
        }
        System.out.println("Nombres: ");
        String nombres = sc.nextLine().trim();
        
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine().trim();
        
        System.out.println("Celular: ");
        String celular = sc.nextLine().trim();
        while (!s.validarEntero(celular) || celular.length()!=10) {
            System.out.println("Incorrecto, vuelva a ingresar Celular: ");
            celular = sc.nextLine().trim();
        }
        System.out.print("Correo: \n");
        CorreoElectronico email = s.correoValidado();
        
        System.out.print("Direccion: \n");
        String direccion = sc.nextLine().trim();
        
        System.out.println("¿Que tipo de suscripcion desea, VIP[V] o Fresh[F]?: ");
        String elegirSuscripcion = sc.nextLine().trim().toUpperCase();
        
        while(!elegirSuscripcion.equals("VIP") && !elegirSuscripcion.equals("FRESH") &&
                elegirSuscripcion.charAt(0)!='V' &&elegirSuscripcion.charAt(0)!='F'){
            System.out.println("¿Que tipo de suscripcion desea, VIP[V] o Fresh[F]?: ");
            elegirSuscripcion = sc.nextLine().trim().toUpperCase();
        }
        Cliente cliente = null;
        if (elegirSuscripcion.charAt(0)=='V')
            cliente = s.pedirDatosVIP(ced,nombres,apellidos,celular,email,direccion);            
        else
            cliente = s.pedirDatosFresh(ced,nombres,apellidos,celular,email,direccion);
        
        Suscripcion suscripcion = new Suscripcion(new Date());
        cliente.agregarSuscripcion(suscripcion);
        NutriFit.clientes.add(cliente);
        s.guardarEnArchivo();
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Su suscripcion vencerá el: " + smp.format(suscripcion.getFechaFin()));
        System.out.println("-- Cliente ingresado con exito --");
        return true;       
    }
    
    private Cliente pedirDatosVIP(String cedula, String nombre, String apellido, String celular, CorreoElectronico email, String direccion){
        float peso = s.ingresoDecimales("Ingrese su peso [Kg]: ");
        float estatura = s.ingresoDecimales("Ingrese su estatura [m]: ");
        System.out.println("Ingrese numero de horas de ejercicios semanales: ");
        String strHoras = sc.nextLine();
        while(!s.validarEntero(strHoras)){
            System.out.println("Ingrese numero de horas de ejercicios semanales: ");
            strHoras = sc.nextLine();
        }
        
        int horasEjercicios = Integer.parseInt(strHoras);
        System.out.println("Ingrese la profesion: ");
        String profesion = sc.nextLine();
        
        Cliente vip = new Vip(peso,estatura,horasEjercicios,profesion,cedula,nombre,apellido,celular,email,direccion);
        return vip;
    }
    
    private Cliente pedirDatosFresh(String cedula, String nombre, String apellido, String celular, CorreoElectronico email, String direccion){
        Cliente fresh = new Fresh(cedula,nombre,apellido,celular,email,direccion);
        System.out.println("¿Desea contratar el servicio de entrega a domicilio (+$30)? [S-N]: ");
        String siNo = sc.nextLine().trim().toUpperCase();
        if (siNo.charAt(0)=='S'){
            ((Fresh)fresh).pagarEntrega();
        }
        return fresh;
    }
    
    /*
    Metodo retorna verdadero si la cedula ingreaada por parametro ya existe en la lista de clientes registrados
    */
    private Cliente validarCliente(String cedula){
        Cliente cliente = null;
        for(Cliente element: NutriFit.clientes){
            if (element.getCedula().equals(cedula)){
                return element;
            }          
        }
        return cliente;
    }
    
    /*Metodo que retorna verdadero si la ceena del parametro "numero" es un entero, en caso de no serlo retorna falso*/
    
    private boolean validarEntero(String numero){
        try{
            int ced = Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    /*Pide el ingreso de numero de tipo float, si el usuario no ingresa un vslor tipo float se volvera a pedir hasta que el formato sea correcta, 
    luego de ello retorna dicho valor*/
    private float ingresoDecimales(String mensaje){
        float numero = 0;        
        boolean bandera = true;
        while(bandera){
            try{
                System.out.print(mensaje);
                numero = sc.nextFloat();
                sc.nextLine();
                return numero;
            }catch(Exception ex){
                sc.nextLine();
            }   
        }
             
        return numero;
    }
    
    /*Retorna un tipo de dato CorreoElectronico después haberlo peido por teclado y de haber validado la estructura del mismo*/
    private CorreoElectronico correoValidado(){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        String email = sc.nextLine();
 
        Matcher mather = pattern.matcher(email);
 
        while (!mather.find()){
            System.out.println("El email ingresado es inválido.");
            email = sc.nextLine();
            mather = pattern.matcher(email);
        }
        CorreoElectronico correo = new CorreoElectronico(email);
        return correo;
    }
       
    /*Pide el ingreso de numero de tipo float, si el usuario no ingresa un vslor tipo float se volvera a pedir hasta que el formato sea correcta, 
    luego de ello retorna dicho valor*/
    
    
    /*Guarda la lista de clientes en un archivo serializado*/
    public void guardarEnArchivo(){
        try(ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("DatosClientes.dat"))){
            obj.writeObject(NutriFit.clientes);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static void mostrarSuscripciones(){
        System.out.println("** SUSCRIPCIONES ACTIVAS **");
        System.out.println(NutriFit.clientes.size());
        if(NutriFit.clientes.size()>0){
            System.out.println("Filtros: "
                + "\n- VIP [V]"
                + "\n- Fresh [F]"
                + "\n- Ambas [A]");
            System.out.println("¿Que tipo de suscripcion desea consultar?: ");
            String tipo = sc.nextLine().trim().toUpperCase();
        
            for(Cliente c: NutriFit.clientes){
                if ((c.getSuscripcion().getFechaFin()).compareTo(new Date())>0){
                    System.out.println("\n*******************************************************************\n");
                    if (tipo.charAt(0)=='V' && c instanceof Vip){
                        Vip vip = (Vip)c; 
                        System.out.println("Cliente VIP:   "+vip.getSuscripcion());
                        System.out.println(vip.toString());
                    }else if (tipo.charAt(0)=='F'&& c instanceof Fresh){
                        Fresh fresh = (Fresh)c; 
                        System.out.println("Cliente FRESH:  "+fresh.getSuscripcion().toString());
                        System.out.println(fresh.toString());
                    }
                    else  if(tipo.charAt(0)=='A'){
                            System.out.println(c.getSuscripcion());
                            System.out.println(c.toString());
                    }
                    else if(tipo.charAt(0)!='A' && tipo.charAt(0)!='F' && tipo.charAt(0)!='V'){
                        System.out.println("Ingreso incorrecto");
                    }
                }
            }
        }
        else{
            System.out.println("No existen registros");
        }
        
        
    }
    
    public static void enviarMenuSemanal(String menuSemanal) {
        for(Cliente c: NutriFit.clientes){
           c.getCorreos().enviarCorreo("Menu Semanal", menuSemanal);
            
        }
    }
}
