/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

import java.io.Serializable;
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
public class Receta implements Serializable {
    private ArrayList<int[]> listaP = new ArrayList<>();
    private String nombrePlato;
    private String preparacion;
    private String tipoComida;
    
    
    public String getNombrePlato() {
        return nombrePlato;
    }

    
    public String getTipoComida() {
        return tipoComida;
    }
    
    public void calcularInfonutri(DetallesIngredientes di){
        int[] intfoNutri=new int[5];
        int[] infoNutriTotal = new int[5];
        String[] datosInfoNutri = {"Calorias", "Hidratos", "Proteinas", "Grasas", "Fibras"};
        int[] arrayTotal = new int[5];
        
        for(int i=0;i< di.getListaNutris().size();i++){
            for(String[] x:di.getListaNutris()){
                for(int y=0;y<di.getListaNutris().get(0).length;y++){
                    int numero = Integer.parseInt(di.getListaNutris().get(i)[y])*di.getListaNumeroIngredientes().get(i);
                    intfoNutri[y] = numero;}
            }
            int j=0;
            for(int z=0;z<intfoNutri.length;z++){
                infoNutriTotal[j] +=intfoNutri[j];
                j++;
                this.listaP.add(infoNutriTotal);
            }
        }
        System.out.println("Informacion nutricional para "+this.nombrePlato);
        for(int xx =0;xx<datosInfoNutri.length;xx++){
            System.out.println(datosInfoNutri[xx]+": "+this.listaP.get(xx)[xx]);
        }    
    }

    public Receta(String nombrePlato, String tipoComida) {
        this.nombrePlato = nombrePlato;
        this.tipoComida = tipoComida;
    }
               

}
