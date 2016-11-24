/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parceirodepizza;

/**
 *
 * @author eduar
 */
public class Pizza {
    private int id;
    private String sabor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    public void ImprimirPizza(Pizza p){
        System.out.println("--- --- --- --- ---");
        System.out.println("Codigo: " + p.getId());
        System.out.println("Sabor: " + p.getSabor());
        System.out.println("--- --- --- --- ---");
    }
            
}
