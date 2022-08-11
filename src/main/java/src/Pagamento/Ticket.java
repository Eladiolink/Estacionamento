package src.Pagamento;

import src.Piso.Piso;
import src.Veiculo.Veiculo;

public class Ticket {
    private Veiculo veiculo;
    private Piso piso;
    
    public Ticket(Veiculo veiculo, Piso piso){
        this.veiculo = veiculo;
        this.piso = piso;
    }

    public Veiculo getVeiculo(){
        return this.veiculo;
    }

    public Piso getPiso(){
        return this.piso;
    }
}
