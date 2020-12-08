/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

/**
 *
 * @author Ana Vargas
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Ingrediente {
    //estas lista se van a llenar luego con los ingredientes y informacion nutricional
    static final ArrayList<String> listaIngredientes = new ArrayList<>();
    static final ArrayList<String> infonutri = new ArrayList<>();
    
    public static void archivo() throws IOException{
    try{BufferedReader bf = new BufferedReader(new FileReader("Ingredientes.csv"));
    String linea = "";
    String encabezado = bf.readLine();
    while(linea != null){ 
        String[] ingred1 = linea.split("\n");
        for(String s:ingred1){
            String[] ingred2 = s.split(",");
            if(ingred2.length==6){
                ingred2 = s.split(",",2);
                Ingrediente.listaIngredientes.add(ingred2[0]);//agrego los ingredientes a la lista}
                Ingrediente.infonutri.add(ingred2[1]); //agrego la info nutricional a la otra lista
                }    
        }
        
        linea = bf.readLine();        
       
    }
    
    bf.close();
    }
    catch(FileNotFoundException e){
        System.out.println("No se encuentra el fichero Ingredientes");}
    catch(IOException e ){
        System.out.println("No se puede leer el archivo Ingredientes");}
}
}
