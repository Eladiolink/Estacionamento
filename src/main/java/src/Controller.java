package src;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import src.Atores.ClientActions;
import src.Atores.Cliente;
import src.Conta.Administrador;
import src.Conta.Atendente;
import src.Helper.CleanCLI;
import src.Helper.TimerSleep;
import src.Piso.Piso;

public class Controller {
    //Objetos
    private Scanner Leitor;
    private ClientActions ClienteActions;

    // Elementos úteis
    private ArrayList<Piso> Pisos = new ArrayList<>();
    private ArrayList<Administrador> Administradores = new ArrayList<>();
    private ArrayList<Atendente> Atendentes = new ArrayList<>();
    private ArrayList<Cliente> Clientes = new ArrayList<>();
    
    public Controller() {
        Leitor = new Scanner(System.in);
        ClienteActions = new ClientActions(this.Pisos, this.Atendentes , this.Clientes);
        Administrador Adm = new Administrador(Pisos, Administradores, Atendentes, "admin", "admin");
        Administradores.add(Adm);
    }

    public void init() {
        CleanCLI.clear();

        System.out.println("================= MENU =================");
        System.out.println("Como deseja entrar?");
        System.out.println("1 - Admnistrador");
        System.out.println("2 - Cliente");
        System.out.println("3 - Encerrar Programa");
        System.out.print("Digite sua opcao: ");
        String opcao = Leitor.next();

        switch (opcao) {
            case "1":
                ChamarAdmnistrador();
                init();
                break;
            case "2":
                ChamarCliente();
                init();
                break;
            case "3":
                System.out.println("Fechando Programa...");
                break;
            default:
                System.out.println("\nOpcao escolhina nao e valida");
                TimerSleep.Sleep(2);
                init();
        }
    }

    private void ChamarAdmnistrador(){
        System.out.println("Admnistrador");
        System.out.print("Usuario: ");
        String user = Leitor.next();
//        System.out.print("Senha: ");
//        String pass = Leitor.next();
        Console console = System.console();

        String pass= new String(console.readPassword("Senha: "));
        Administrador User = new Administrador(Pisos, Administradores, Atendentes, user, pass);
        int userId = -1;
        Administrador adm;

        for(int i=0;i<Administradores.size();i++){
            adm = Administradores.get(i);
            boolean res = adm.equals(User);
            
            if(res){
                userId = i;
                break;
            }
        }

        if(userId != -1)
            Administradores.get(userId).AdministradorAction();
        else {
            System.out.println("Usuario nao Encontrado");
            TimerSleep.Sleep(1);
        }
   }

    private void ChamarCliente(){
        ClienteActions.clientInit();
    }
}