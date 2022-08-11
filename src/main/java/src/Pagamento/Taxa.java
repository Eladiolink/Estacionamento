package src.Pagamento;

import src.Veiculo.Caminhao;
import src.Veiculo.Carro;
import src.Veiculo.CarroEletrico;
import src.Veiculo.Motocicleta;
import src.Veiculo.Van;
import src.Veiculo.Veiculo;

public class Taxa extends AbstractTaxa {
    private int horas;
    private double taxa;
    private Veiculo veiculo;

    public Taxa(int horas, Veiculo veiculo) {
        this.horas = horas;
        this.veiculo = veiculo;
        this.DefinirTaxa();
    }

    public double getTaxa() {
        return this.taxa;
    }
    private void DefinirTaxa(){
        if(veiculo instanceof Caminhao || veiculo instanceof Van){
            this.DefinirTaxaVeiculosGrandes();
        }

        if(veiculo instanceof Carro){
            this.DefinirTaxaVeiculosPequenos();
        }

        if(veiculo instanceof CarroEletrico){
            this.DefinirTaxaVeiculosEletricos();
        }

        if(veiculo instanceof Motocicleta){
            this.DefinirTaxaMotocicleta();
        }
    }

    protected void DefinirTaxaVeiculosPequenos() {
        this.taxa = this.horas * 3.50;
    }

    protected void DefinirTaxaVeiculosGrandes() {
        this.taxa = this.horas * 7.50;
    }

    protected void DefinirTaxaVeiculosEletricos() {
        this.taxa = this.horas * 5.50;
    }

    protected void DefinirTaxaMotocicleta() {
        this.taxa = this.horas * 3;
    }
}
