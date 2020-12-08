/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import alimentos.Ingrediente;
import interfaz.NutriFit;
import java.io.IOException;
import java.util.Scanner;
import personas.CorreoElectronico;

/**
 *
 * @author Ana Vargas
 */
public class MenuPrincipal {
    static Scanner sc = new Scanner(System.in);
    private static boolean menuCreado = false;
    
    public static void mostrarMenu(){
        System.out.println("** MENU - NutriFit - **");
        System.out.println("1. Subida de Productos");
        System.out.println("2. Registro de Recetas");
        System.out.println("3. Registro de Clientes");
        System.out.println("4. Creación Automática de Menú Semanal");
        System.out.println("5. Envio de Menú Semanal");
        System.out.println("6. Consultar Suscripciones");
        System.out.println("7. Salir");
    }
    
    public static void elegirOpciones() throws IOException{
        String op = "0";        
        while (!"7".equals(op)){
            mostrarMenu();
            System.out.println("Elija una opcion: ");
            op = sc.nextLine();
            switch(op){
                case "1":   
                    Ingrediente.archivo();
                    System.out.println("Se han subido los productos");
                    break;
                    
                case "2":
                    NutriFit.ingresaRecetas();
                    System.out.println("Se han ingresado las recetas");
                    break;
                    
                case "3":
                    Sistema.registrarCliente();
                    break;
                    
                case "4":
                    NutriFit.crearMenu();
                    System.out.println("Se ha creado el menu");
                    menuCreado = true;
                    break;
                
                case "5":
                    if (!menuCreado) 
                        System.out.println("Primero cree el menu semanal (op 4)");
                    else{
                        Sistema.enviarMenuSemanal(NutriFit.presentarMenu());
                    }
                    break;
                
                case "6":
                    Sistema.mostrarSuscripciones();
                    break;
                    
                case "7":
                    System.out.println("Gracias por preferirnos c:");
                    break;
                    
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }       
            System.out.println("\n");
        }
    }
    
    
}
