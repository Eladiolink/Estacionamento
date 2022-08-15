package src.Conta.Gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

import src.Conta.Administrador;
import src.Conta.Atendente;
import src.Conta.Conta;
import src.Helper.CleanCLI;
import src.Helper.TimerSleep;
import src.Piso.Piso;

public class Administradores implements InterfaceGerenciamento {
    private Scanner Leitor = new Scanner(System.in);
    private ArrayList<Administrador> Admnistradores;
    private ArrayList<Piso> Pisos;
    private ArrayList<Atendente> Atendentes;

    public Administradores(
        ArrayList<Administrador> Admnistradores,
        ArrayList<Piso> Pisos,
        ArrayList<Atendente> Atendentes) {
        this.Admnistradores = Admnistradores;
        this.Pisos = Pisos;
        this.Atendentes = Atendentes;
    }

    public void Admnistrador() {
        CleanCLI.clear();

        System.out.println("\n================= ADMNISTRADOR =================");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar administrador");
        System.out.println("2 - Modificar administrador");
        System.out.println("3 - Remover administrador");
        System.out.println("4 - Sair");
        System.out.print("Digite sua opcao: ");

        String opcao = Leitor.next();

        switch (opcao) {
            case "1":
                Adicionar();
                Admnistrador();
                break;
            case "2":
                Modificar();
                Admnistrador();
                break;
            case "3":
                Remover();
                Admnistrador();
                break;
            case "4":
                break;
            default:
                System.out.println("Opcao escolhina nao e valida");
                TimerSleep.Sleep(2);
                Admnistrador();
        }
    }

    public void Adicionar() {
        int quantidadeAtual = Admnistradores.size();

        System.out.print("Nome de Usuario: ");
        String User = Leitor.next();
        System.out.print("Senha: ");
        String Pass = Leitor.next();

        Administrador novoAdministrador = new Administrador(Pisos, Admnistradores, Atendentes, User, Pass);

        if(this.verifyAccountExist(this.Admnistradores,novoAdministrador) ){
            System.out.println("\nUsuario ja existe!");
            return;
        }

        Admnistradores.add(novoAdministrador);

        if (Admnistradores.size() > quantidadeAtual) {
            System.out.println("\nAtendente " + User + " adicionado com sucesso!");
        }
    }

    private boolean verifyAccountExist(ArrayList<Administrador> contas, Conta novaConta){
        for(int i=0;i<contas.size();i++){
            if(contas.get(i).equalsUser(novaConta)){
                return true;
            }
        }
        return false;
    }

    public void Modificar() {
        System.out.println("\n\nQual deseja Modificar?");
        for (int i = 0; i < Admnistradores.size(); i++) {
            System.out.println(i + " - " + Admnistradores.get(i).getUser());
        }

        try{
            System.out.print("Opcao: ");
            int opcao = Leitor.nextInt();

            if (opcao >= Admnistradores.size()) {
                System.out.println("Usuario Invalido!");
                TimerSleep.Sleep(2);
            } else {
                Administrador adm = Admnistradores.get(opcao);

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
        } catch (Exception e){
            System.out.println("Valor passado nao e um inteiro");
            TimerSleep.Sleep(2);
        }

    }

    public void Remover() {
        if (Admnistradores.size() == 1) {
            System.out.println("\n\n Nao pode remover o unico usuario administrador do sistema!");
            return;
        }

        System.out.println("\n\nQual deseja Remover?");
        for (int i = 0; i < Admnistradores.size(); i++) {
            System.out.println(i + " - " + Admnistradores.get(i).getUser());
        }

        try{
            System.out.print("Opcao: ");
            int opcao = Leitor.nextInt();

            if (opcao >= Admnistradores.size()) {
                System.out.println("Usuario Invalido!");
            } else {
                Admnistradores.remove(opcao);
            }
        }catch (Exception e) {
            System.out.println("Opcao passada nao e um numero!");
            TimerSleep.Sleep(2);
        }
    }
}
