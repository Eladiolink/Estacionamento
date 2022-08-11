package src.Veiculo;

public class Veiculo {
    protected String placa;

    public Veiculo(String placa){
        this.placa = placa;
    }

    public String getPlaca(){
        return this.placa;
    }

    public boolean equals(Veiculo veiculo){
        return this.placa.equals(veiculo.getPlaca());
    }
}
