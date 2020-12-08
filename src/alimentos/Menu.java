/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

import java.util.ArrayList;

/**
 *
 * @author Ana Vargas
 */
public class Menu {
    private ArrayList<Receta> desayunos = new ArrayList<>();
    private ArrayList<Receta> almuerzos = new ArrayList<>();
    private ArrayList<Receta> cenas = new ArrayList<>();
    private final String[] semana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
    
    public void agregarRecetaMenu(Receta r){
        switch(r.getTipoComida()){
            case("Desayuno"):
                this.desayunos.add(r);
                break;
            case("Almuerzo"):
                this.almuerzos.add(r);
                break;
            case("Cena"):
                this.cenas.add(r);
                break;
            default:
                System.out.println("No se encuentra el tipo de comida");
        }
    }
    
    public String generarDesayunos(){
        int numeroDesayunos = this.desayunos.size();
        int[] randomDesayunos = new int[5];
        int i=0;
        randomDesayunos[i] = (int)(Math.random()*numeroDesayunos);
        for(i=1;i<5;i++){
            randomDesayunos[i] =(int)(Math.random()*numeroDesayunos);
            for(int j=0; j<i;j++){
                if(randomDesayunos[i]==randomDesayunos[j]){
                    i--;}
            }
        }
        for(int x=0;x<semana.length;x++){
            System.out.println("Desayuno para el "+semana[x]);
            System.out.println(this.desayunos.get(randomDesayunos[x]).getNombrePlato()+"\n");
        }
        return this.desayunos.toString();
    }

    public String generarAlmuerzos(){
        int numeroAlmuerzos = this.almuerzos.size();
        int[] randomAlmuerzos = new int[5];
        int i=0;
        randomAlmuerzos[i] = (int)(Math.random()*numeroAlmuerzos);
        for(i=1;i<5;i++){
            randomAlmuerzos[i] =(int)(Math.random()*numeroAlmuerzos);
            for(int j=0; j<i;j++){
                if(randomAlmuerzos[i]==randomAlmuerzos[j]){
                    i--;}
            }
        }
        for(int x=0;x<semana.length;x++){
            System.out.println("Almuerzo para el "+semana[x]);
            System.out.println(this.almuerzos.get(randomAlmuerzos[x]).getNombrePlato()+"\n");
        }
        return this.almuerzos.toString();
    }

    public String generarCenas(){
        int numeroCenas = this.cenas.size();
        int[] randomCenas = new int[5];
        int i=0;
        randomCenas[i] = (int)(Math.random()*numeroCenas);
        for(i=1;i<5;i++){
            randomCenas[i] =(int)(Math.random()*numeroCenas);
            for(int j=0; j<i;j++){
                if(randomCenas[i]==randomCenas[j]){
                    i--;}
            }
        }
        for(int x=0;x<semana.length;x++){
            System.out.println("Cena para el "+semana[x]);
            System.out.println(this.cenas.get(randomCenas[x]).getNombrePlato()+"\n");
        }
        return this.cenas.toString();
    }
}
