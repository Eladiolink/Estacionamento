package src.Atores;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import src.Conta.Administrador;
import src.Conta.Atendente;
import src.Conta.Conta;
import src.Helper.TimerSleep;
import src.Pagamento.Pagamento;
import src.Pagamento.Ticket;
import src.Piso.Piso;
import src.Veiculo.Caminhao;
import src.Veiculo.Carro;
import src.Veiculo.CarroEletrico;
import src.Veiculo.Motocicleta;
import src.Veiculo.Van;
import src.Veiculo.Veiculo;

public class ClientActions {
    private ArrayList<Piso> Pisos;
    private ArrayList<Cliente> Clientes;
    private ArrayList<Atendente> Atendentes;
    private Sistema sistema;
    private Scanner Leitor = new Scanner(System.in);

    public ClientActions(ArrayList<Piso> Pisos, ArrayList<Atendente> Atendentes, ArrayList<Cliente> Clientes) {
        this.Pisos = Pisos;
        this.Clientes = Clientes;
        this.Atendentes = Atendentes;
        this.sistema = new Sistema();
    }

    public void clientInit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("================= CLIENTE =================");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Estacionar");
        System.out.println("2 - Sair");
        System.out.println("3 - Mostrar Vagas Livres em um Piso");
        System.out.print("Digite sua opcao: ");
        String opcao = Leitor.next();

        switch (opcao) {
            case "1":
                estacionar();
                break;
            case "2":
                sair();
                break;
            case "3":
                MostrarVagasLivres();
                try { Thread.sleep (5000); } catch (InterruptedException ex) {}
                break;
            default:
                System.out.println("Opcao escolhina nao e valida");
                clientInit();
        }
    }

    private void estacionar() {
        if (Pisos.size() == 0) {
            System.out.println("\n\nSem Pisos");
            return;
        }

        Veiculo veiculo = criarVeiculo();

        if(veiculo.getPlaca().length() > 8){
            System.out.println("\nA placa informada e invalida!");
            TimerSleep.Sleep(2);
            return;
        }

        if(this.verifyVeiclesExist(this.Clientes,veiculo) ){
            System.out.println("\nVeiculo ja esta estacionado!");
            TimerSleep.Sleep(2);
            return;
        }

        System.out.println("\n\nEm qual piso deseja estacionar?");

        for (int i = 0; i < Pisos.size(); i++) {
            System.out.println("Piso " + i);
        }
        System.out.print("Digite o numero do piso: ");
        int andar = Leitor.nextInt();

        Piso piso = Pisos.get(andar);
        Ticket ticket = obterTicket(veiculo, piso);
        this.sistema.atribuirVeiculoVaga(ticket);
        Cliente cliente = new Cliente(ticket);
        int quantidadeAtual = Clientes.size();
        this.Clientes.add(cliente);

        if (quantidadeAtual < this.Clientes.size())
            System.out.println("\n\n Veiculo " + cliente.ticket.getVeiculo().getPlaca() + " adicionado a vaga no piso "
                    + andar + "");
        TimerSleep.Sleep(2);
    }

    private boolean verifyVeiclesExist(ArrayList<Cliente> clientes, Veiculo novoVeiculo){
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).ticket.getVeiculo().equals(novoVeiculo)){
                return true;
            }
        }
        return false;
    }

    private Veiculo criarVeiculo() {
        System.out.print("\n\nInforme a placa do seu Veiculo: ");
        String placa = Leitor.next();

        System.out.println("\nQual é o seu Veiculo?");
        System.out.println("1 - Caminhao");
        System.out.println("2 - Van");
        System.out.println("3 - Carro");
        System.out.println("4 - Carro Eletrico");
        System.out.println("5 - Motocicleta");

        boolean condition = true;

        Veiculo veiculo = null;
        while (condition) {
            System.out.print("Digite sua opcao: ");
            String opcao = Leitor.next();

            switch (opcao) {
                case "1":
                    veiculo = new Caminhao(placa);
                    condition = false;
                    break;
                case "2":
                    veiculo = new Van(placa);
                    condition = false;
                    break;
                case "3":
                    veiculo = new Carro(placa);
                    condition = false;
                    break;
                case "4":
                    veiculo = new CarroEletrico(placa);
                    condition = false;
                    break;
                case "5":
                    veiculo = new Motocicleta(placa);
                    condition = false;
                    break;
                default:
                    System.out.println("Opcao escolhina nao e valida, Tente Novamente!");
                    TimerSleep.Sleep(2);
            }
        }

        return veiculo;
    }

    private void sair() {
        if (this.Atendentes.size() == 0) {
            System.out.println("\nAgarde um momento, sem atendentes disponiveis!");
            TimerSleep.Sleep(2);
            return;
        }

        Cliente cliente = this.procurarCliente();

        if (cliente == null) {
            System.out.println("Nada encontrado!!");
            TimerSleep.Sleep(2);
            return;
        }

        Pagamento pag = new Pagamento();
        double valorPagar = pag.digitalizaTicket(cliente);

        System.out.print("Deseja fazer o pagamento agora? 1 - SIM | 0 - NAO: ");
        int opcao = this.Leitor.nextInt();

        if (opcao == 1) {
            Random gerador = new Random();
            Atendente atendente = this.Atendentes.get(gerador.nextInt(this.Atendentes.size()));
            atendente.receberPagamento(valorPagar);
            this.sistema.removerVeiculoDaVaga(cliente.ticket);
        }

    }

    private Cliente procurarCliente() {
        System.out.print("Informe a placa do seu veiculo: ");
        String placa = this.Leitor.next();

        Veiculo obj = new Veiculo(placa);
        Cliente cliente = null;
        for (int i = 0; i < this.Clientes.size(); i++) {
            boolean res = this.Clientes.get(i).ticket.getVeiculo().equals(obj);

            if (res) {
                cliente = this.Clientes.get(i);
                return cliente;
            }
        }

        return cliente;
    }

    private Ticket obterTicket(Veiculo veiculo, Piso piso) {
        Ticket ticket = new Ticket(veiculo, piso);
        return ticket;
    }

    private void MostrarVagasLivres() {

        if(Pisos.size() == 0){
            System.out.println("\n\nNAO HA NENHUM PISO!!");
            TimerSleep.Sleep(1);
            return;
        }

        System.out.println("================= PISOS =================");
        for (int i = 0; i < this.Pisos.size(); i++) {
            System.out.println(i+" - Piso Andar:"+ Pisos.get(i).getAndar());
        }

        try { 
            System.out.print("Informe qual piso deseja ver as vagas livres: ");
            int opcao = Leitor.nextInt(); 
            if (opcao >= this.Pisos.size()) {
                System.out.println("Piso inválido!");
                TimerSleep.Sleep(2);
                return;
            }
    
            Piso piso = this.Pisos.get(opcao);
            piso.MostrarVagas();
        } catch (Exception e) { 
            System.out.println("\nValor informado nao e um numero!");
            TimerSleep.Sleep(2);
        }
       
    }

}
