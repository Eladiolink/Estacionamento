package src.Conta.Gerenciamento;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import src.Helper.CleanCLI;
import src.Helper.TimerSleep;
import src.Piso.ModificarPiso;
import src.Piso.Piso;

public class Pisos implements InterfaceGerenciamento {
    private Scanner Leitor = new Scanner(System.in);
    private ArrayList<Piso> Pisos;

    public Pisos(ArrayList<Piso> Piso){
        this.Pisos = Piso;
    }

    public void Piso(){
        CleanCLI.clear();

        System.out.println("\n================= PISO =================");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar piso");
        System.out.println("2 - Modificar piso");
        System.out.println("3 - Remover piso");
        System.out.println("4 - Sair");
        System.out.print("Digite sua opcao: ");

        String opcao = Leitor.next();

        switch (opcao) {
            case "1":
                Adicionar();
                Piso();
                break;
            case "2":
                Modificar();
                Piso();
                break;
            case "3":
                Remover();
                Piso();
                break;
            case "4":
                break;
            default:
                System.out.println("Opcao escolhina nao e valida");
                TimerSleep.Sleep(1);
                Piso();
        }
    }
    
    public void Adicionar() {
        System.out.print("Quantidade de Entradas: ");
        int qtEntrada = Leitor.nextInt();
        System.out.print("Quantidade de Saidas: ");
        int qtSaida = Leitor.nextInt();
        Piso piso = new Piso(Piso.qtPisos,qtEntrada,qtSaida);
        this.Pisos.add(piso);
        
        piso.MostrarVagas();
        TimerSleep.Sleep(1);
    }

    public void Modificar() {
        if(Pisos.size() == 0){
            System.out.println("\n\nNAO HA NENHUM PISO PARA ALTERAR!!");
            TimerSleep.Sleep(1);
            return;
        }

        MostrarPisos();

        try{
            System.out.print("Qual piso voce deseja alterar? ");
            int andar = Leitor.nextInt();

            if( andar>=0 && andar <= Piso.qtPisos){
                Piso piso = Pisos.get(andar);
                ModificarPiso modificarPiso = new ModificarPiso(piso);
                modificarPiso.modificarInit(andar);
            }
        }catch (Exception e){
            System.out.println("Opcao passada nao e um numero");
            TimerSleep.Sleep(1);
        }
    }
    
    public void Remover(){
        if (Pisos.size() == 0) {
            System.out.println("\n\n Nao ha nenhum piso a remover");
            TimerSleep.Sleep(1);
            return;
        }

        MostrarPisos();

        System.out.println("\n\nQual deseja Remover?");

        try{
            System.out.print("Opcao: ");
            int opcao = Leitor.nextInt();

            if (opcao >= Pisos.size()) {
                System.out.println("Piso Invalido!");
            } else {
                Pisos.remove(opcao);
            }
        }catch (Exception e){
            System.out.println("Opcao passada nao e um numero");
            TimerSleep.Sleep(1);
        }
    }

    public void MostrarPisos(){
        if(Pisos.size() == 0){
            System.out.println("\n\nNAO HA NENHUM PISO PARA ALTERAR!!");
            TimerSleep.Sleep(1);
            return;
        }
        
        System.out.println("\n\n================= PISOS =================");
        for(int i=0;i<Pisos.size();i++){
            System.out.println(i+" - Piso Andar:"+ Pisos.get(i).getAndar());
        }
        TimerSleep.Sleep(1);
    }
    
}
