/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/
package alimentos;


import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class DetallesIngredientes {
    private ArrayList<String> listaIngredientesPlato = new ArrayList<>();
    private ArrayList<Integer> listaNumeroIngredientes = new ArrayList<>();
    private ArrayList<String[]> listaNutris = new ArrayList<>();
    private String ingredientesPlato;
    private int cantidadIngredientes;
    private int numeroIngrediente;
    
    
    public void ingresoIngredientes(Receta r){
        Scanner sc = new Scanner(System.in);
        System.out.println(r.getNombrePlato());
        System.out.print("¿Cuantos ingredientes va a usar para "+r.getNombrePlato()+"?  ");
        this.cantidadIngredientes = sc.nextInt();
        int conta = 0;
        for(int i = 0; i<cantidadIngredientes; i++){
            conta++;
            Scanner lector = new Scanner(System.in);
            System.out.print("Ingrediente "+conta+" :");
            this.ingredientesPlato = lector.nextLine();
            listaIngredientesPlato.add(ingredientesPlato.toUpperCase());
        }
    }
    

    public void ingresoNumeroIngredientes(Receta r){
        
        for(int i = 0; i<this.listaIngredientesPlato.size(); i++){
            Scanner lector = new Scanner(System.in);
            System.out.print("Ingrese cantidad de "+this.listaIngredientesPlato.get(i)+": ");
            this.numeroIngrediente = lector.nextInt();
            this.listaNumeroIngredientes.add(this.numeroIngrediente);
            
        }
    }

    public ArrayList<String> getListaIngredientesPlato() {
        return listaIngredientesPlato;
    }

    public ArrayList<Integer> getListaNumeroIngredientes() {
        return listaNumeroIngredientes;
    }

    public int getNumeroIngrediente() {
        return numeroIngrediente;
    }

    public void tomarInfoNutri(){
        for(int i = 0; i<this.listaIngredientesPlato.size(); i++){
            if(Ingrediente.listaIngredientes.contains(this.listaIngredientesPlato.get(i))){
                int indicesComun = Ingrediente.listaIngredientes.indexOf(this.listaIngredientesPlato.get(i));
                String[] nutri = Ingrediente.infonutri.get(indicesComun).split(",");
                this.listaNutris.add(nutri);
            }
            else{
                String[] ceros = {"0","0","0","0","0"}; 
                Ingrediente.listaIngredientes.add(this.listaIngredientesPlato.get(i));
                this.listaNutris.add(ceros);
            }
        }
    }

    public ArrayList<String[]> getListaNutris() {
        return listaNutris;
    }
        
}

    

    

