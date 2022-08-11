package src.Estacionamento;

public class Endereco {
    public String rua;
    public int numero;
    public String bairro;
    public String cidade;

    public Endereco(
        String rua,
        int numero,
        String bairro,
        String cidade
    ){
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
}
