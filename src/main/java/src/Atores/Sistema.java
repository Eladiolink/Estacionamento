package src.Atores;

import src.Pagamento.Ticket;

public class Sistema {

    public void atribuirVeiculoVaga(Ticket ticket){
        ticket.getPiso().estacionarUmVeiculo(ticket.getVeiculo());
    }

    public void removerVeiculoDaVaga(Ticket ticket){
        ticket.getPiso().removerUmVeiculo(ticket.getVeiculo());
    }
}
