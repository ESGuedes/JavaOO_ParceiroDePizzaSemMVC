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
public class Usuario {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void ImprimirUsuario(Usuario u){
        System.out.println("--- --- --- --- ---");
        System.out.println("Codigo: " + u.getId());
        System.out.println("Sabor: " + u.getNome());
        System.out.println("--- --- --- --- ---");
    }
}
