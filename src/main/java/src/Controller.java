package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Atores.ClientActions;
import src.Atores.Cliente;
import src.Conta.Administrador;
import src.Conta.Atendente;
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
        System.out.println("\n\n================= MENU =================");
        System.out.println("Como deseja entrar?");
        System.out.println("1 - Admnistrador");
        System.out.println("2 - Atendente");
        System.out.println("3 - Cliente");
        System.out.println("4 - Encerrar Programa");
        System.out.print("Digite sua opcao: ");
        int opcao = Leitor.nextInt();

        switch (opcao) {
            case 1:
                ChamarAdmnistrador();
                init();
                break;
            case 2:
                ChamarAtendente();
                init();
                break;
            case 3:
                ChamarCliente();
                init();
                break;
            case 4:
                System.out.println("Fechando Programa...");
                break;
            default:
                System.out.println("Opção escolhina não é válida");
            init();
        }
    }
    
    private void ChamarAtendente(){
        System.out.println("Atendente");
       // Atendente = new Atendente();
        System.out.println("");
    }

    private void ChamarAdmnistrador(){
        System.out.println("Admnistrador");
        System.out.print("Usuario: ");
        String user = Leitor.next();
        System.out.print("Senha: ");
        String pass = Leitor.next();
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
        else
            System.out.println("Usuario não Encontrado");
    }

    private void ChamarCliente(){
        ClienteActions.clientInit();
    }
}