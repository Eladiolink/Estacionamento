package src.Piso;

import src.Helper.TimerSleep;

public class Vaga {
    private int veiculosPequenos;
    private int veiculosGrandes;
    private int veiculosEletricos;
    private int motocicleta;

    public Vaga(int veiculosPequenos, int veiculosGrandes, int veiculosEletricos, int motocicleta) {
        if (veiculosPequenos >= 0 && veiculosGrandes >= 0 && veiculosEletricos >= 0 && motocicleta >= 0) {
            this.veiculosPequenos = veiculosPequenos;
            this.veiculosGrandes = veiculosGrandes;
            this.veiculosEletricos = veiculosEletricos;
            this.motocicleta = motocicleta;
        }
    }

    public void setVeiculosPequenos(int value) {
        if (value >= 0) {
            this.veiculosPequenos = value;
        }

    }

    public void setVeiculosGrandes(int value) {
        if (value >= 0)
            this.veiculosGrandes = value;
    }

    public void setVeiculosEletricos(int value) {
        if (value >= 0)
            this.veiculosEletricos = value;
    }

    public void setMotocicleta(int value) {
        if (value >= 0)
            this.motocicleta = value;
    }

    //

    public int getVeiculosPequenos() {
        return this.veiculosPequenos;
    }

    public int getVeiculosGrandes() {
        return this.veiculosGrandes;
    }

    public int getVeiculosEletricos() {
        return this.veiculosEletricos;
    }

    public int getMotocicleta() {
        return this.motocicleta;
    }

    //

    public void adicionarVeiculosPequenos(int quantidade) {
        quantidade += this.getVeiculosPequenos();
        this.setVeiculosPequenos(quantidade);
    }

    public void adicionarVeiculosGrandes(int quantidade) {
        quantidade += this.getVeiculosGrandes();
        this.setVeiculosGrandes(quantidade);
    }

    public void adicionarVeiculosEletricos(int quantidade) {
        quantidade += this.getVeiculosEletricos();
        this.setVeiculosEletricos(quantidade);
    }

    public void adicionarMotocicleta(int quantidade) {
        quantidade += this.getMotocicleta();
        this.setMotocicleta(quantidade);
    }

    //

    public void removerVeiculosPequenos(int quantidade) {
        int totalNovo = this.getVeiculosPequenos() - quantidade;
        if (totalNovo < 0) {
            System.out.println("Quantidade não é valida");
            return;
        }
        this.setVeiculosPequenos(totalNovo);
    }

    public void removerVeiculosGrandes(int quantidade) {
        int totalNovo = this.getVeiculosGrandes() - quantidade;
        if (totalNovo < 0) {
            System.out.println("Quantidade não é valida");
            TimerSleep.Sleep(1);
            return;
        }
        this.setVeiculosGrandes(totalNovo);
    }

    public void removerVeiculosEletricos(int quantidade) {
        int totalNovo = this.getVeiculosEletricos() - quantidade;
        if (totalNovo < 0) {
            System.out.println("Quantidade não é valida");
            TimerSleep.Sleep(1);
            return;
        }
        this.setVeiculosEletricos(totalNovo);
    }

    public void removerMotocicleta(int quantidade) {
        int totalNovo = this.getMotocicleta() - quantidade;
        if (totalNovo < 0) {
            System.out.println("Quantidade não é valida");
            TimerSleep.Sleep(1);
            return;
        }
        this.setMotocicleta(totalNovo);
    }

    //

    public void atribuirVeiculoPequeno() {
        if (verifyCountVeicle(this.veiculosPequenos)) {
            return;
        }

        this.veiculosPequenos--;
    }

    public void atribuirVeiculoGrandes() {
        if (verifyCountVeicle(this.veiculosGrandes)) {
            return;
        }

        this.veiculosGrandes--;
    }

    public void atribuirVeiculoEletrico() {
        if (verifyCountVeicle(this.veiculosEletricos)) {
            return;
        }

        this.veiculosEletricos--;
    }

    public void atribuirVeiculoMotocicleta() {
        if (verifyCountVeicle(this.motocicleta)) {
            return;
        }

        this.motocicleta--;
    }
   
    //

    public void desatribuirVeiculoPequeno() {
        this.veiculosPequenos++;
    }

    public void desatribuirVeiculoGrandes() {
        this.veiculosGrandes++;
    }

    public void desatribuirVeiculoEletrico() {
        this.veiculosEletricos++;
    }

    public void desatribuirVeiculoMotocicleta() {
        this.motocicleta++;
    }

    private boolean verifyCountVeicle(int veiculo) {
        if (veiculo == 0) {
            System.out.println("Nao ha vagas!");
            TimerSleep.Sleep(1);
            return true;
        }

        return false;
    }
}
