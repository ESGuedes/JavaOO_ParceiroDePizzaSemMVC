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
public class Voto {
    private int nota;
    private Pizza pizza;
    private Usuario usuario;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void ImprimirVoto(Voto v){
        System.out.println("--- --- --- --- ---");
        System.out.println("Id Pizza: " + v.getPizza().getId());
        System.out.println("Sabor Pizza: " + v.getPizza().getSabor());
        System.out.println("Id Usuario: " + v.getUsuario().getId());
        System.out.println("Nome Usuario: " + v.getUsuario().getNome());
        System.out.println("Nota: " + v.getNota());
        System.out.println("--- --- --- --- ---");
    }
    
}
