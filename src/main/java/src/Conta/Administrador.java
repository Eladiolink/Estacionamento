package src.Conta;

import java.util.ArrayList;
import java.util.Scanner;

import src.Conta.Gerenciamento.Administradores;
import src.Conta.Gerenciamento.Atendentes;
import src.Conta.Gerenciamento.Pisos;
import src.Piso.Piso;

public class Administrador extends Conta {
    private Scanner Leitor;
    
    private ArrayList<Piso> Pisos;
    private ArrayList<Administrador> Administradores;
    private ArrayList<Atendente> Atendentes;
    
    // Gerenciamento
    Pisos gerenciamentoPiso;
    Administradores gerenciamentoAdministrador;
    Atendentes gerenciamentoAtendente;

    public Administrador(ArrayList<Piso> Pisos,ArrayList<Administrador> Administradores, ArrayList<Atendente> Atendentes, String User, String Pass) {
        Leitor = new Scanner(System.in);
        this.Pisos = Pisos;
        this.Administradores = Administradores;
        this.Atendentes = Atendentes;
        
        this.gerenciamentoPiso = new Pisos(this.Pisos);

        this.gerenciamentoAdministrador = new Administradores(this.Administradores, this.Pisos, this.Atendentes);

        this.gerenciamentoAtendente = new Atendentes(Atendentes);
        
        this.usuario = User;
        this.senha = Pass;
    }

    public void AdministradorAction() {
       
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n================= ADMINISTRADOR =================");
        System.out.println("1 - Opcoes de Piso");
        System.out.println("2 - Opcoes de Administrador");
        System.out.println("3 - Opcoes de Atendente");
        System.out.println("4 - Encerrar Sessao");
        System.out.print("Digite sua opcao: ");
        String opcao = Leitor.next();

        switch (opcao) {
            case "1":
                gerenciamentoPiso.Piso();
                AdministradorAction();
                break;
            case "2":
                gerenciamentoAdministrador.Admnistrador();
                AdministradorAction();
                break;
            case "3":
                gerenciamentoAtendente.Atendente();
                AdministradorAction();
                break;
            case "4":
                System.out.println("Encerrando sessão...");
                break;
            default:
                System.out.println("Opção escolhina não é válida");
                AdministradorAction();
        }       
    }
}
