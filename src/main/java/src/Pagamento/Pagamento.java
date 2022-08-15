package src.Pagamento;

import java.util.Scanner;

import src.Atores.Cliente;
import src.Helper.TimerSleep;

public class Pagamento {
    private Scanner Leitor = new Scanner(System.in);

    public double digitalizaTicket(Cliente cliente){
        System.out.print("Quantas horas ficaste? ");
        int horas = this.Leitor.nextInt();

        if(horas<=0){
            System.out.println("Valor em horas e invalido");
            TimerSleep.Sleep(1);
            return 0.0;
        }
        
        Taxa taxa = new Taxa(horas, cliente.ticket.getVeiculo());

        System.out.println("Tera que pagar:"+taxa.getTaxa());
        return taxa.getTaxa();
    }
}
