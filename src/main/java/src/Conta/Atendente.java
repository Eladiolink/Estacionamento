package src.Conta;

import src.Helper.TimerSleep;

public class Atendente extends Conta {
    public Atendente(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario(){
        return usuario;
    }

    public void receberPagamento(double pagamento){
        if(pagamento>0){
            System.out.println("\nPagamento realizado!!");
            TimerSleep.Sleep(1);
        }
    }
}
