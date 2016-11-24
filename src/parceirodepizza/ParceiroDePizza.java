/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parceirodepizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduar
 */
public class ParceiroDePizza {

    // Variavel do tipo Scanner para receber dados do teclacdo
    private static  Scanner leitor = new Scanner (System.in);

    // Criação de variaveis do tipo lista para recebimento dos dados;
    private static List<Pizza> pizzas;
    private static List<Usuario> usuarios;
    private static List<Voto> votos;
    
    public static void main(String[] args) {
        //Criação de Array para reserva de memomória
        
        ParceiroDePizza.pizzas = new ArrayList<Pizza>();
        ParceiroDePizza.usuarios = new ArrayList<Usuario>();
        ParceiroDePizza.votos = new ArrayList<Voto>();
        GerarMassaTeste();
        
        System.out.println("Sistema para levantamento de dados.");
        System.out.println("E formulação de possiveis parceiros.");
        System.out.println("Para compra de Pizza");
        
        int opcaoMenu = 0;
        
        do{
            opcaoMenu = Menu();
            
            switch(opcaoMenu){
                case 1:
                    CreatePizza();
                    break;
                case 2:
                    ReadPizzas();
                    break;
                case 3:
                    ReadPizzaPorCodigo();
                    break;
                case 4:
                    UpdatePizzaPorCodigo();
                    break;
                case 5:
                    DeletePizzaPorCodigo();
                    break;
                case 6:
                    CreateUsuario();
                    break;
                case 7:
                    ReadUsuarios();
                    break;
                case 8:
                    ReadUsuarioPorCodigo();
                    break;
                case 9:
                    UpdateUsuarioPorCodigo();
                    break;
                case 10:
                    DeleteUsuarioPorCodigo();
                    break;
                case 11:
                    CreateVoto();
                    break;
                case 12:
                    ReadVotos();
                    break;
                case 13:
                    ReadVotoPorCodigoUsuario();
                    break;
                case 14:
                    UpdateVotoPorUsuario();
                    break;
                case 15:
                    DeleteVotoPorUsuario();
                    break;
                case 16:
                    LocalizarParceiroPorUsuario();
                    break;
                    
                case 20:
                    break;
            }
        }while(opcaoMenu != 20);
    }
    
    //Metodos para geração de cadastros para testes.
    private static void GerarMassaTeste(){
        for (int i = 1; i <6; i++) {
            Pizza p = new Pizza();
            p.setId(i);
            p.setSabor("Sabor" + i);
            
            ParceiroDePizza.pizzas.add(p);
        }
        
        for (int i = 1; i < 10; i++) {
            Usuario u = new Usuario();
            u.setId(i);
            u.setNome("Usuario" + i);
            
            ParceiroDePizza.usuarios.add(u);
        }
    }
    //##########################################################
    //Metodo utilizado para verificação de opção do usuario
    //##########################################################    
    private static int Menu(){
        //Opções para pizza
        System.out.println("Escolha uma das opções listadas abaixo:");
        System.out.println("1 - Cadastrar Pizza;");
        System.out.println("2 - Listar Sabores de Pizza Cadastrados;");
        System.out.println("3 - Localizar Pizza por Código;");
        System.out.println("4 - Alterar Sabor da Pizza;");
        System.out.println("5 - Excluir Sabor de Pizza;");
        //Opções para Usuario
        System.out.println("6 - Cadastrar Usuario;");
        System.out.println("7 - Listar Sabores de Usuario Cadastrados;");
        System.out.println("8 - Localizar Usuario por Código;");
        System.out.println("9 - Alterar Sabor da Usuario;");
        System.out.println("10 - Excluir Sabor de Usuario;");
        //Opções para Voto
        System.out.println("11 - Votar Nos Sabores;");
        System.out.println("12 - Listar Todos os Votos do Sitema;");
        System.out.println("13 - Detalhar meu Voto;");
        System.out.println("14 - Alterar meu Voto;");
        System.out.println("15 - Deletar meu Voto;");
        System.out.println("16 - Localizar Meus Possiveis Parceiros de Pizza;");
        System.out.println("20 - Sair do Sistema.");
        System.out.print("Digite aqui sua opção: ");
        int opcaoMenu = leitor.nextInt();
        leitor.nextLine();
        System.out.println("");
        return opcaoMenu;
    }
    
    //##########################################################
    //Abaixo códigos utilizados para gerenciamento de usuario
    //##########################################################
    
    //Metodo a ser utilizado para cadastro de sabor de pizza
    private static void CreatePizza() {
        System.out.println("Seleicionada opção: 1 - Cadastrar Pizza.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe um código para o sabor de pizza: ");
        int idPizza = leitor.nextInt();
        leitor.nextLine();
        
        Pizza p = new Pizza();
        
        int segueAlteracao = 0;

        do{
            Pizza np = PizzaPorCodigo(idPizza);
            
            if ( np == null ){
                p.setId(idPizza);
                segueAlteracao = 1;
            }else{
                System.out.print("Código já utilizado informe outro código: ");
                idPizza = leitor.nextInt();
                leitor.nextLine();
            }
        }while(segueAlteracao != 1);
        
        System.out.print("Informe o nome do sabor da pizza: ");
        String sabor = leitor.nextLine();
        
        p.setSabor(sabor);
        
        ParceiroDePizza.pizzas.add(p);
    }
    
    //Metodo utilizado para listar toadas as pizzas cacadastradas
    private static void ReadPizzas(){
        System.out.println("Seleicionada opção: 2 - Listar Sabores de Pizza Cadastrados.");
        System.out.println("Sabores Cadastrados");
        for (Pizza p : pizzas){
            System.out.println("--- --- --- --- ---");
            System.out.println("Codigo: " + p.getId());
            System.out.println("Sabor: " + p.getSabor());
        }
        System.out.println("--- --- --- --- ---");
    }
    
    // Metodo utilizado para verificar se a pizza esta cadastrada atraves do codigo
    private static Pizza PizzaPorCodigo(int idPizza){
        for (Pizza p : pizzas){
            if(idPizza == p.getId()){
                return p;
            }
        }
        return null;
    }
    
    //Metodo utilizado para printar a pizza consultada pelo cliente através do código
    private static void ReadPizzaPorCodigo(){
        System.out.println("Seleicionada opção: 3 - Localizar Pizza por Código.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código que deseja consultar: ");
        int idPizza = leitor.nextInt();
        leitor.nextLine();
        
        Pizza p = PizzaPorCodigo(idPizza);
        
        if (p != null){
            p.ImprimirPizza(p);
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    
    //Metodo utilizado para alterar o sabor da pizza 
    private static void UpdatePizzaPorCodigo(){
        System.out.println("Seleicionada opção: 4 - Alterar Sabor da Pizza.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código do sabor que deseja alterar: ");
        int idPizza = leitor.nextInt();
        leitor.nextLine();
        
        Pizza p = PizzaPorCodigo(idPizza);
        
        if (p != null){
            System.out.print("Informe o novo codigo que deseja utilizar ( Anterior: " + p.getId() + " ): ");
            int nIdPizza = leitor.nextInt();
            leitor.nextLine();
            
            int segueAlteracao = 0; 
                    
            do{
                Pizza np = PizzaPorCodigo(nIdPizza);
                
                if ( np == null ){
                    p.setId(nIdPizza);
                    segueAlteracao = 1;
                }else{
                    System.out.print("Código já utilizado informe outro código( Anterior: " + p.getId() + " ): ");
                    nIdPizza = leitor.nextInt();
                    leitor.nextLine();
                }
            }while(segueAlteracao != 1);        
            
            System.out.println("Código alterado com sucesso.");
            segueAlteracao = 0;
            
            System.out.print("Informe o novo sabor que deseja utilizar ( Anterior: " + p.getSabor() +  " ): ");
            String nSabor = leitor.nextLine();
            p.setSabor(nSabor);
            System.out.println("Sabor alterado com sucesso.");
            
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    
    private static void DeletePizzaPorCodigo(){
        System.out.println("Seleicionada opção: 5 - Excluir Sabor de Pizza.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código do sabor que deseja excluir: ");
        int idPizza = leitor.nextInt();
        leitor.nextLine();
        
        Pizza p = PizzaPorCodigo(idPizza);
        
        if(p != null){
            ParceiroDePizza.pizzas.remove(p);
            System.out.println("--- --- --- --- ---");
            System.out.println("Sabor excluido com sucesso.");
            System.out.println("--- --- --- --- ---");
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    // Fim dos códigos referentes a pizza

    //##########################################################
    //Abaixo códigos utilizados para gerenciamento de usuario
    //##########################################################
    
    //Metodo utilizado para criar usuario
        private static void CreateUsuario() {
        System.out.println("Seleicionada opção: 6 - Cadastrar Usuario.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe um código para o usuario: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        
        Usuario u = new Usuario();
        
        int segueAlteracao = 0;

        do{
            Usuario nu = UsuarioPorCodigo(idUsuario);
            
            if ( nu == null ){
                u.setId(idUsuario);
                segueAlteracao = 1;
            }else{
                System.out.print("Código já utilizado informe outro código: ");
                idUsuario = leitor.nextInt();
                leitor.nextLine();
            }
        }while(segueAlteracao != 1);
        
        System.out.print("Informe o nome do usuario: ");
        String nome = leitor.nextLine();
        
        u.setNome(nome);
        
        ParceiroDePizza.usuarios.add(u);
    }
    
    //Metodo utilizado para listar toadas as usuarios cacadastradas
    private static void ReadUsuarios(){
        System.out.println("Seleicionada opção: 7 - Listar Usuarios Cadastrados.");
        System.out.println("Usuarios Cadastrados");
        for (Usuario u : usuarios){
            System.out.println("--- --- --- --- ---");
            System.out.println("Codigo: " + u.getId());
            System.out.println("Nome: " + u.getNome());
        }
        System.out.println("--- --- --- --- ---");
    }
    
    // Metodo utilizado para verificar se a usuario esta cadastrada atraves do codigo
    private static Usuario UsuarioPorCodigo(int idUsuario){
        for (Usuario p : usuarios){
            if(idUsuario == p.getId()){
                return p;
            }
        }
        return null;
    }
    
    //Metodo utilizado para printar a usuario consultada pelo cliente através do código
    private static void ReadUsuarioPorCodigo(){
        System.out.println("Seleicionada opção: 8 - Localizar Usuario por Código.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código que deseja consultar: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        
        Usuario p = UsuarioPorCodigo(idUsuario);
        
        if (p != null){
            p.ImprimirUsuario(p);
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    
    //Metodo utilizado para alterar o sabor da usuario 
    private static void UpdateUsuarioPorCodigo(){
        System.out.println("Seleicionada opção: 9 - Alterar Usuario.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código do sabor que deseja alterar: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        
        Usuario u = UsuarioPorCodigo(idUsuario);
        
        if (u != null){
            System.out.print("Informe o novo codigo que deseja utilizar ( Anterior: " + u.getId() + " ): ");
            int nIdUsuario = leitor.nextInt();
            leitor.nextLine();
            
            int segueAlteracao = 0; 
                    
            do{
                Usuario np = UsuarioPorCodigo(nIdUsuario);
                
                if ( np == null ){
                    u.setId(nIdUsuario);
                    segueAlteracao = 1;
                }else{
                    System.out.print("Código já utilizado informe outro código( Anterior: " + u.getId() + " ): ");
                    nIdUsuario = leitor.nextInt();
                    leitor.nextLine();
                }
            }while(segueAlteracao != 1);        
            
            System.out.println("Código alterado com sucesso.");
            segueAlteracao = 0;
            
            System.out.print("Informe o novo nome que deseja utilizar ( Anterior: " + u.getNome()+  " ): ");
            String nNome = leitor.nextLine();
            u.setNome(nNome);
            System.out.println("Nome alterado com sucesso.");
            
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    
    private static void DeleteUsuarioPorCodigo(){
        System.out.println("Seleicionada opção: 10 - Excluir Sabor de Usuario.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe o código do sabor que deseja excluir: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        
        Usuario p = UsuarioPorCodigo(idUsuario);
        
        if(p != null){
            ParceiroDePizza.usuarios.remove(p);
            System.out.println("--- --- --- --- ---");
            System.out.println("Sabor excluido com sucesso.");
            System.out.println("--- --- --- --- ---");
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Código procurado não localizado no sistema.");
            System.out.println("--- --- --- --- ---");
        }
    }
    // Fim dos códigos referentes a pizza
    
    //##########################################################
    //Abaixo códigos utilizados para gerenciamento de voto
    //##########################################################
    
    //Metodo utilizado para criação ou cadastro de voto
    private static void CreateVoto(){
        System.out.println("Seleicionada opção: 11 - Votar Nos Sabores.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe seu código de usuario: ");
        Usuario validaUsuario = null;
        Voto validaVoto = null;
        Usuario u2 = null;
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        do{
            //Verificação de usuario
            validaUsuario = UsuarioPorCodigo(idUsuario);
            
            
            if(validaUsuario != null){
                //Verifica se o usurio já votou
                validaVoto = VotoPorUsuario(validaUsuario);
                do{  
                    if(validaVoto == null){
                        System.out.println("Usuario localizado");
                        System.out.println("Inicie a atribuição das notas.");
                        System.out.println("Utilize notas de 1 a 5.");
                        System.out.println("Sendo 1 para Detesto e 5 para Adoro");
                        for (Pizza p : pizzas){
                            System.out.println("--- --- --- --- ---");
                            System.out.println("Sabor: " + p.getSabor());
                            System.out.print("Informe sua nota: ");
                            int notaSabor = leitor.nextInt();
                            leitor.nextLine();
                            boolean notaOk = false;
                            do{
                                if (notaSabor >= 1 && notaSabor <= 5 ){
                                    notaOk = true;
                                }else{
                                    System.out.println("Nota invalida");
                                    System.out.print("Informe sua nota: ");
                                    notaSabor = leitor.nextInt();
                                    leitor.nextLine();        
                                }
                            }while(notaOk != true);
                            //Criação de variavel do tipo Voto para inclusão
                            Voto v = new Voto();
                            v.setUsuario(validaUsuario);
                            v.setPizza(p);
                            v.setNota(notaSabor);
                            ParceiroDePizza.votos.add(v);
                            //Verifica se o usurio já votou
                            validaVoto = v;
                        }
                        System.out.println("--- --- --- --- ---");
                    }else{  
                        do{
                            System.out.println("--- --- --- --- ---");
                            System.out.print("Usuario ja votou, digite outro código de usuario: ");
                            idUsuario = leitor.nextInt();
                            leitor.nextLine();
                            validaUsuario = UsuarioPorCodigo(idUsuario);
                            //Verifica se o usurio já votou
                            validaVoto = VotoPorUsuario(validaUsuario);
                        }while(validaVoto !=null); 
                    }
                }while(validaVoto == null);
            }else{
                System.out.print("Usuario não localizado, informe seu código: ");
                idUsuario = leitor.nextInt();
                leitor.nextLine();
            }
        }while(validaUsuario == null);    
    }
    
    //Metodo utilizado para listar toados os votos cacadastrados
    private static void ReadVotos(){
        System.out.println("Seleicionada opção: 12 - Listar Todos os Votos do Sitema.");
        System.out.println("Votos Cadastrados");
        for (Usuario u : usuarios){
            Voto validaVoto = VotoPorUsuario(u);
            if (validaVoto != null){        
                System.out.println("### Usuario ###");
                System.out.println("Codigo: " + u.getId());
                System.out.println("Nome: " + u.getNome());
                System.out.println("### Sabores ###");
                for (Voto v : votos){
                    if(u.getId() == v.getUsuario().getId()){
                        System.out.println("--- --- --- --- ---");
                        System.out.println("Sabor: " + v.getPizza().getSabor());
                        System.out.println("Nota: " + v.getNota());
                    }
                }
                System.out.println("--- --- --- --- ---");
                System.out.println("");
                
            }    
        }
        
    }    
    
    //Metodo utilizado para localizar os votos por usurario
    private static Voto VotoPorUsuario(Usuario u){
        for (Voto v : votos){
            if(u.getId() == v.getUsuario().getId()){
                return v;
            }
        }
        return null;
    }
    
    //Meto para detalhar o voto pesquisando pelo id do usuario
    private static void ReadVotoPorCodigoUsuario(){
        System.out.println("Seleicionada opção: 13 - Detalhar meu Voto.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe seu código de Usuario: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();  
        
        Usuario validaUsuario = UsuarioPorCodigo(idUsuario);
        Voto validaVoto = VotoPorUsuario(validaUsuario);
        
        if (validaVoto != null){
                   
            System.out.println("### Usuario ###");
            System.out.println("Codigo: " + validaVoto.getUsuario().getId());
            System.out.println("Nome: " + validaVoto.getUsuario().getNome());
            System.out.println("### Sabores ###");
            for (Voto v : votos){
                if(validaVoto.getUsuario().getId() == v.getUsuario().getId()){
                    System.out.println("--- --- --- --- ---");
                    System.out.println("Sabor: " + v.getPizza().getSabor());
                    System.out.println("Nota: " + v.getNota());
                }
            }
            System.out.println("--- --- --- --- ---");
            System.out.println("");
        }else{
            System.out.println("--- --- --- --- ---");
            System.out.println("Usuario não localizado.");
            System.out.println("--- --- --- --- ---");
        }
    }
    
    //Metodo para alterar voto
    private static void UpdateVotoPorUsuario(){
        System.out.println("Seleicionada opção: 14 - Alterar meu Voto.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe seu código de Usuario: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        Usuario validaUsuario = null;
        Voto validaVoto = null;
        
        do{
            validaUsuario = UsuarioPorCodigo(idUsuario);
            validaVoto = VotoPorUsuario(validaUsuario);
            
            if(validaVoto != null){
                System.out.println("Usuario Localizado");
                System.out.println("Altere seu voto abaixo");
                
                for(Voto v : votos){
                    if(validaVoto.getUsuario().getId() == v.getUsuario().getId()){
                        System.out.println("--- --- --- --- ---");
                        System.out.println("Sabor: " + v.getPizza().getSabor());
                        System.out.print("Informe sua nova nota (Anterior: " + v.getNota() + "): ");
                        int novaNota = leitor.nextInt();
                        leitor.nextLine();
                        
                        boolean notaOk = false;
                        do{
                            if (novaNota >= 1 && novaNota <= 5 ){
                                notaOk = true;
                            }else{
                                System.out.println("Nota invalida");
                                System.out.print("Informe sua nova nota (Anterior: " + v.getNota() + "): ");
                                novaNota = leitor.nextInt();
                                leitor.nextLine();        
                            }
                        }while(notaOk != true);
                        
                        
                        v.setNota(novaNota);
                    }
                }
                System.out.println("--- --- --- --- ---");
            }else{
                System.out.println("--- --- --- --- ---");
                System.out.print("Usuario não localizado, digite um usurio correto: ");
                idUsuario = leitor.nextInt();
                leitor.nextLine();
            }
        }while(validaVoto == null);
    }
    
    //Metodo utilizado para deletar voto
    private static void DeleteVotoPorUsuario(){
        System.out.println("Seleicionada opção: 15 - Deletar meu Voto.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe seu código de Usuario: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        Usuario validaUsuario = null;
        Voto validaVoto = null;
        boolean votoExcluido = false;
        do{
            validaUsuario = UsuarioPorCodigo(idUsuario);
            validaVoto = VotoPorUsuario(validaUsuario);
            
            if(validaVoto != null){
                do{
                    ParceiroDePizza.votos.remove(validaVoto);
                    validaVoto = VotoPorUsuario(validaUsuario);                    
                }while(validaVoto != null); 
                System.out.println("--- --- --- --- ---");
                System.out.println("Voto Excluido com Sucesso.");
                System.out.println("--- --- --- --- ---");
                votoExcluido = true;
            }else{
                System.out.println("--- --- --- --- ---");
                System.out.print("Usuario não localizado, digite um usurio correto: ");
                idUsuario = leitor.nextInt();
                leitor.nextLine();
            }
        }while(votoExcluido != true);
        
    }
    
    //##########################################################
    //Abaixo códigos utilizados para localizar possiveis parceiros de pizza
    //##########################################################
    
    //Metodo para localizar parceiro para compra de Pizza
    private static void LocalizarParceiroPorUsuario(){
        System.out.println("Seleicionada opção: 16 - Localizar Meus Possiveis Parceiros de Pizza.");
        System.out.println("--- --- --- --- ---");
        System.out.print("Informe seu código de Usuario: ");
        int idUsuario = leitor.nextInt();
        leitor.nextLine();
        Usuario validaUsuario = null;
        Voto validaVoto = null;
        
        do{
            validaUsuario = UsuarioPorCodigo(idUsuario);
            validaVoto = VotoPorUsuario(validaUsuario);
            
            if(validaVoto != null){
                System.out.println("Possiveis parceiros:");
                for (Voto v1 : votos){
                    if(idUsuario == v1.getUsuario().getId()){
                        if(v1.getNota() > 2){
                            for (Voto v2 : votos){
                                if(idUsuario!= v2.getUsuario().getId() && v1.getPizza().getSabor() == v2.getPizza().getSabor() && v2.getNota() > 2){
                                    System.out.println("--- --- --- --- ---");
                                    System.out.println("Sabor: " + v2.getPizza().getSabor());
                                    System.out.println("Nome possivel parceiro: " + v2.getUsuario().getNome());
                                    String probabilidade = null;
                                    switch (v2.getNota()){
                                        case 3:
                                            probabilidade = "Baixa";
                                            break;
                                        case 4:
                                            probabilidade = "Média";
                                            break;
                                        case 5:
                                            probabilidade = "Alta";
                                            break;        
                                    };
                                    System.out.println("Probabilidade: " + probabilidade + "." );
                                    System.out.println("Você atribuiu nota " + v1.getNota() + "para esse sabor.");
                                    System.out.println(v2.getUsuario().getNome() + "atribuiu nota " + v2.getNota() + "para esse sabor.");
                                }
                            }
                        }
                    }
                }
                
            }else{
                System.out.println("--- --- --- --- ---");
                System.out.print("Usuario não votou, digite um usurio que efetou voto para realizar comparação: ");
                idUsuario = leitor.nextInt();
                leitor.nextLine();
            }
        }while(validaVoto == null);
        
    }
}
