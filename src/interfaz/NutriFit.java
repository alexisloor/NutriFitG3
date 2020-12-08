/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.IOException;
import java.util.ArrayList;
import alimentos.DetallesIngredientes;
//import alimentos.Ingrediente;
import alimentos.Menu;
import alimentos.Receta;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import personas.*;
import operaciones.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import personas.Cliente;
public class NutriFit {
    public static ArrayList<Cliente> clientes = new ArrayList();
    public static ArrayList<Receta> recetas = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
 
        
        leerClientes();
        MenuPrincipal.elegirOpciones();
        
        
    }  
    
        public static void ingresaRecetas()  throws IOException{
        recetas.add(new Receta("Magdalena con helado de fruta","Desayuno"));//MAGDALENA-HELADO FRUTA 
        recetas.add(new Receta("Camarones cocidos con arroz integral","Almuerzo")); //CAMARONES COCIDOS-ARROZ INTEGRAL
        recetas.add(new Receta("Pollo con ensalada","Cena")); //CEBOLLA-ACELGAS-COLIFLOR-POLLO
        recetas.add(new Receta("Pan con chocolate y fresas","Desayuno"));//PAN CON CHOCOLATE-FRESAS 
        recetas.add(new Receta("Arroz integral con sardina y papas fritas","Almuerzo"));//ARROZ INTEGRAL-SARDINAS-PATATAS FRITAS
        recetas.add(new Receta("Macarrones con tomate y queso mozzarella","Cena"));//MACARRONES-TOMATE FRITO-QUESO MOZZARELLA
        recetas.add(new Receta("Cereales Cornflakes con leche","Desayuno")); //CEREALES CORNFLAKES-LECHE DE VACA
        recetas.add(new Receta("Patatas fritas con salami y pollo","Almuerzo"));//PATATAS FRITAS-SALAMI-POLLO
        recetas.add(new Receta("Hamburguesa","Cena"));//HAMBURGUESA BURGER- KING
        recetas.add(new Receta("Yogurt con avellanas","Desayuno"));//YOGUR FRUTAS-AVELLANAS
        recetas.add(new Receta("Lentejas con salchicha de cerdo","Almuerzo"));//LENTEJAS-SALCHICHA CERDO
        recetas.add(new Receta("Pavo","Cena"));//PAVO
        recetas.add(new Receta("Pan integral","Desayuno"));//PAN INTEGRAL
        recetas.add(new Receta("Pollo con patatas fritas","Almuerzo"));//POLLO-PATATAS FRITAS
        recetas.add(new Receta("Raviolis con salsa de tomate","Cena")); //RAVIOLIS TOMATE SALSA 
        recetas.add(new Receta("Croissant","Desayuno"));//CROISSANT
        recetas.add(new Receta("Sardinas con tomate","Almuerzo"));//SARDINAS-TOMATE FRITO
        recetas.add(new Receta("Pizza","Cena"));//PIZZA QUESO TOMATE
        NutriFit.serializaRecetas();
        }
        
        public static void calcularInfoNutriRecetas(){
        for(Receta r:recetas){
            DetallesIngredientes di = new DetallesIngredientes();
            di.ingresoIngredientes(r);
            di.ingresoNumeroIngredientes(r);
            di.tomarInfoNutri();
            r.calcularInfonutri(di);
            }
        }   
        
        public static void crearMenu(){
        Menu menu = new Menu();
        for(Receta r:recetas){
            menu.agregarRecetaMenu(r);
            
            }
        }
        
        //este metodo tiene el menu que hay que enviar por correo
        public static String presentarMenu(){
        Menu menu= new Menu();
        for(Receta r:recetas){
            menu.agregarRecetaMenu(r);}
        return menu.generarDesayunos()+"\n"+menu.generarAlmuerzos()+"\n"+menu.generarCenas();   
        }
     
     
        
        
        
    
        public static void leerClientes(){
            File archivo = new File("DatosClientes.dat");
            //archivo.delete();
            if(archivo.exists()){
                try(ObjectInputStream ob = new ObjectInputStream(new FileInputStream(archivo.getPath()))){
                    NutriFit.clientes = (ArrayList<Cliente>) ob.readObject();
                } catch (FileNotFoundException ex) {
                    System.err.println(ex.getMessage());
                } catch (IOException | ClassNotFoundException ex) {
                      System.err.println(ex.getMessage());
                }
            }
        }
        
        
        public static void serializaRecetas(){
        try{
            FileOutputStream fos = new FileOutputStream("recetas");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(recetas);
            oos.close();
            fos.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        } 
    }
}
