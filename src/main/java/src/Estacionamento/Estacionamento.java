package src.Estacionamento;

public class Estacionamento {
    private Endereco endereco;
    private String nome;
    
    public Estacionamento(
        String nome,
        String rua,
        int numero,
        String bairro,
        String cidade
        ){
        this.nome = nome;
        this.endereco = new Endereco(rua, numero, bairro, cidade);
    }

    public void MostrarMennsagemInicial(){
        System.out.println("\nSEJA BEM VINDO AO ESTACIONAMENTO "+this.nome+"!");
    }

    public Endereco getEndereco(){
        return this.endereco;
    }
}
