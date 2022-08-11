package src.Pagamento;

import java.util.Scanner;

import src.Atores.Cliente;

public class Pagamento {
    private Scanner Leitor = new Scanner(System.in);

    public double digitalizaTicket(Cliente cliente){
        System.out.println("Quantas horas ficaste? ");
        int horas = this.Leitor.nextInt();

        if(horas<=0){
            System.out.println("Valor em horas é invalido");
            return 0.0;
        }
        
        Taxa taxa = new Taxa(horas, cliente.ticket.getVeiculo());

        System.out.println("Terá que pagar:"+taxa.getTaxa());
        return taxa.getTaxa();
    }
}
