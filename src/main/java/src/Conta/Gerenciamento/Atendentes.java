package src.Conta.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

import src.Conta.Atendente;

public class Atendentes implements InterfaceGerenciamento{
    private Scanner Leitor = new Scanner(System.in);
    private ArrayList<Atendente> Atendentes;

    public Atendentes(ArrayList<Atendente> Atendentes){
        this.Atendentes = Atendentes;
    }

    public void Atendente(){
        System.out.println("\n================= ATENDENTE =================");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar atendente");
        System.out.println("2 - Modificar atendente");
        System.out.println("3 - Remover atendente");
        System.out.println("4 - Sair");
        System.out.print("Digite sua opcao: ");

        int opcao = Leitor.nextInt();

        switch (opcao) {
            case 1:
                Adicionar();
                break;
            case 2:
                Modificar();
                break;
            case 3:
                Remover();
                break;
            case 4:
                break;
            default:
                System.out.println("Opção escolhina não é válida");
               
        }
    }

    public void Adicionar() {
        int quantidadeAtual = Atendentes.size();

        System.out.print("Nome de Usuario: ");
        String User = Leitor.next();
        System.out.print("Senha: ");
        String Pass = Leitor.next();
        
        Atendente novoAtendente = new Atendente(User, Pass);
        Atendentes.add(novoAtendente);

        if(Atendentes.size() > quantidadeAtual){
            System.out.println("\nAtendente "+User+" adicionado com sucesso!");
        }
    }
    
    public void Modificar(){
        if (Atendentes.size() == 0) {
            System.out.println("\n\n Nao tem Atendentes para modificar");
            return;
        }

        System.out.println("\n\nQual deseja Modificar?");
        for (int i = 0; i < Atendentes.size(); i++) {
            System.out.println(i + " - " + Atendentes.get(i).getUser());
        }

        try{
            System.out.print("Opcao: ");
            int opcao = Leitor.nextInt();

            if (opcao >= Atendentes.size()) {
                System.out.println("Usuario Inválido!");
            } else {
                Atendente adm = Atendentes.get(opcao);

                System.out.println("Modificar: \n 1 - Usuario \n 2 - Senha?");
                System.out.print("Opcao: ");
                opcao = Leitor.nextInt();
                if (opcao == 1) {
                    System.out.print("Novo Usuario: ");
                    String user = Leitor.next();
                    adm.setUser(user);
                }

                if (opcao == 2) {
                    System.out.print("Nova Senha: ");
                    String pass = Leitor.next();
                    adm.setPass(pass);
                }
            }
        }catch (Exception e){
            System.out.println("Opcao passada nao e um numero");
        }
    }

    public void Remover() {
        if (Atendentes.size() == 0) {
            System.out.println("\n\n Nao tem Atendentes para remover");
            return;
        }
        
        System.out.println("\n\nQual Deseja Remover?");
        for (int i = 0; i < Atendentes.size(); i++) {
            System.out.println(i + " - " + Atendentes.get(i).getUser());
        }

        System.out.print("Digite o nome do Atendente: ");
        String atendente = Leitor.next();
        boolean remocao = false;
    
        for(int i = 0; i < Atendentes.size(); i++)
        {
            Atendente p = Atendentes.get(i);
    
            if(p.getUsuario().equals(atendente))
            {
                // Encontrou uma pessoa cadastrada com nome "Pedro".
    
                // Remove.
                Atendentes.remove(p);
                remocao = true;
                // Sai do loop.
                break;
            }
        }
    
        if(remocao)
            System.out.println("Atendente removido!");
        else
            System.out.println("Atendente não removido, ou não encontrado!");
    }
}
