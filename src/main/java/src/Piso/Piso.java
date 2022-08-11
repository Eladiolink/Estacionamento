package src.Piso;

import java.util.Scanner;
import src.PortalExibicao;
import src.Veiculo.Caminhao;
import src.Veiculo.Carro;
import src.Veiculo.CarroEletrico;
import src.Veiculo.Motocicleta;
import src.Veiculo.Van;
import src.Veiculo.Veiculo;

public class Piso {
    private Scanner Leitor = new Scanner(System.in);
    private int andar;
    public Vaga vagas;
    private int qtEntrada;
    private int qtSaida;
    public static int qtPisos = 0;
    private  PortalExibicao portalExibicao;

    public Piso(int andar, int qtEntrada, int qtSaida){
        this.andar = andar;
        this.qtEntrada = qtEntrada;
        this.qtSaida = qtSaida;
        this.vagas();
        Piso.qtPisos+=1;
        this.portalExibicao = new PortalExibicao();
    }

    public int getQtEntrada(){
        return qtEntrada;
    }

    public int getQtSaida(){
        return qtSaida;
    }

    public int getAndar(){
        return andar;
    }
    
    public void setAndar(int value){
        this.andar = value;
    }
    
    public void setQtEntrada(int value){
        this.qtEntrada = value;
    }

    public void setQtSaida(int value){
        this.qtSaida = value;
    }
    
    public void MostrarVagas(){
        portalExibicao.MostrarVagas(this.vagas);
    }

    public void estacionarUmVeiculo(Veiculo veiculo){
        if(veiculo instanceof Caminhao || veiculo instanceof Van){
            this.vagas.atribuirVeiculoGrandes();
        }

        if(veiculo instanceof Carro){
            this.vagas.atribuirVeiculoPequeno();
        }

        if(veiculo instanceof CarroEletrico){
            this.vagas.atribuirVeiculoEletrico();
        }

        if(veiculo instanceof Motocicleta){
            this.vagas.atribuirVeiculoMotocicleta();
        }
    }
    
    public void removerUmVeiculo(Veiculo veiculo){
        if(veiculo instanceof Caminhao || veiculo instanceof Van){
            this.vagas.desatribuirVeiculoGrandes();
        }

        if(veiculo instanceof Carro){
            this.vagas.desatribuirVeiculoPequeno();
        }

        if(veiculo instanceof CarroEletrico){
            this.vagas.desatribuirVeiculoEletrico();
        }

        if(veiculo instanceof Motocicleta){
            this.vagas.desatribuirVeiculoMotocicleta();
        }
    }

    private void vagas(){
        System.out.print("Quantidade de Veiculos Pequenos: ");
        int veiculosPequenos = Leitor.nextInt();
        System.out.print("Quantidade de Veiculos Grandes: ");
        int veiculosGrandes = Leitor.nextInt();
        System.out.print("Quantidade de Veiculos Eletricos: ");
        int veiculosEletricos = Leitor.nextInt();
        System.out.print("Quantidade de Motocicletas: ");
        int motocicleta = Leitor.nextInt();
        this.vagas = new Vaga(veiculosPequenos, veiculosGrandes, veiculosEletricos, motocicleta);
    }
}
