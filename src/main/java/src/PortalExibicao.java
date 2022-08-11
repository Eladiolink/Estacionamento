package src;

import src.Piso.Vaga;

public class PortalExibicao {
  
    public void MostrarVagas(Vaga vagas){
        System.out.println("\n\n================= VAGAS LIVRES =================");
        System.out.println("Veiculos Pequenos: "+ vagas.getVeiculosPequenos());
        System.out.println("Veiculos Eletricos: "+ vagas.getVeiculosEletricos());
        System.out.println("Veiculos Grandes: "+ vagas.getVeiculosGrandes());
        System.out.println("Motocicletas: "+ vagas.getMotocicleta());
    }
}
