package src.Piso;

import java.util.Scanner;

public class ModificarPiso {
    private Scanner Leitor;
    private Piso piso;

    public ModificarPiso(Piso piso) {
        Leitor = new Scanner(System.in);
        this.piso = piso;
    }

    public void modificarInit(int andar) {
        System.out.println("\n\nO que deseja fazer?");
        System.out.println("1 - Modificar Quantidade de Vagas");
        System.out.println("2 - Modificar Quantidade de Entradas");
        System.out.println("3 - Modificar Quantidade de Saidas");
        System.out.println("4 - Adicionar Vagas");
        System.out.println("5 - Remover Vagas");
        System.out.println("6 - Sair");
        System.out.print("Digite sua opcao: ");
        int opcao = Leitor.nextInt();

        switch (opcao) {
            case 1:
                modificarQtVagas();
                break;
            case 2:
                modificarQtEntrada(andar);
                break;
            case 3:
                modificarQtSaida(andar);
                break;
            case 4:
                adicionarVagas();
                break;
            case 5:
                removerVagas();
                break;
            case 6:
                break;
            default:
                System.out.println("Opcao escolhina nao e valida");
        }
    }

    public void adicionarVagas() {
        System.out.println("\n\nO que deseja fazer?");
        System.out.println("1 - Adicionar em Veiculos Pequenos");
        System.out.println("2 - Adicionar em Veiculos Grandes");
        System.out.println("3 - Adicionar em Veiculos Eletricos");
        System.out.println("4 - Adicionar em Motocicletas");
        System.out.println("5 - Sair");
        System.out.print("Digite sua opcao: ");
        int opcao = Leitor.nextInt();
        int quantidade = 0;

        if (opcao != 5) {
            System.out.print("Quantidade deseja adicionar: ");
            quantidade = Leitor.nextInt();
        }

        switch (opcao) {
            case 1:
                piso.vagas.adicionarVeiculosPequenos(quantidade);
                piso.MostrarVagas();
                adicionarVagas();
                break;
            case 2:
                piso.vagas.adicionarVeiculosGrandes(quantidade);
                piso.MostrarVagas();
                adicionarVagas();
                break;
            case 3:
                piso.vagas.adicionarVeiculosEletricos(quantidade);
                piso.MostrarVagas();
                adicionarVagas();
                break;
            case 4:
                piso.vagas.adicionarMotocicleta(quantidade);
                piso.MostrarVagas();
                adicionarVagas();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção escolhina não é válida");
        }
    }

    public void removerVagas() {
        System.out.println("\n\nO que deseja fazer?");
        System.out.println("1 - Remover em Veiculos Pequenos");
        System.out.println("2 - Remover em Veiculos Grandes");
        System.out.println("3 - Remover em Veiculos Eletricos");
        System.out.println("4 - Remover em Motocicletas");
        System.out.println("5 - Sair");
        System.out.print("Digite sua opcao: ");
        int opcao = Leitor.nextInt();
        int quantidade = 0;

        if (opcao != 5) {
            System.out.print("Quantidade deseja remover: ");
            quantidade = Leitor.nextInt();
        }

        switch (opcao) {
            case 1:
                piso.vagas.removerVeiculosPequenos(quantidade);
                piso.MostrarVagas();
                removerVagas();
                break;
            case 2:
                piso.vagas.removerVeiculosGrandes(quantidade);
                piso.MostrarVagas();
                removerVagas();
                break;
            case 3:
                piso.vagas.removerVeiculosEletricos(quantidade);
                piso.MostrarVagas();
                removerVagas();
                break;
            case 4:
                piso.vagas.removerMotocicleta(quantidade);
                piso.MostrarVagas();
                removerVagas();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção escolhina não é válida");
        }
    }

    public void modificarQtVagas() {
        System.out.println("\n\nO que deseja fazer?");
        System.out.println("1 - Modificar Quantidade Veiculos Pequenos");
        System.out.println("2 - Modificar Quantidade Veiculos Grandes");
        System.out.println("3 - Modificar Quantidade Veiculos Eletricos");
        System.out.println("4 - Modificar Quantidade Motocicletas");
        System.out.println("5 - Sair");
        System.out.print("Digite sua opcao: ");
        int opcao = Leitor.nextInt();
        int quantidade = 0;

        if (opcao != 5) {
            System.out.print("Quantidade: ");
            quantidade = Leitor.nextInt();
        }

        switch (opcao) {
            case 1:
                piso.vagas.setVeiculosPequenos(quantidade);
                piso.MostrarVagas();
                modificarQtVagas();
                break;
            case 2:
                piso.vagas.setVeiculosGrandes(quantidade);
                piso.MostrarVagas();
                modificarQtVagas();
                break;
            case 3:
                piso.vagas.setVeiculosEletricos(quantidade);
                piso.MostrarVagas();
                modificarQtVagas();
                break;
            case 4:
                piso.vagas.setMotocicleta(quantidade);
                piso.MostrarVagas();
                modificarQtVagas();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção escolhina não é válida");
        }
    }

    public void modificarQtEntrada(int value) {
        boolean condition = true;

        while (condition) {
            System.out.println("Quantidade de saidas: ");
            int qtEntrada = Leitor.nextInt();
            if (qtEntrada > 0) {
                piso.setQtEntrada(qtEntrada);
                condition = false;
            } else {
                System.out.println("Quantidade Invalida, tente novamente!");
            }

        }
    }

    public void modificarQtSaida(int value) {

        boolean condition = true;

        while (condition) {
            System.out.println("Quantidade de saidas: ");
            int qtSaida = Leitor.nextInt();
            if (qtSaida > 0) {
                piso.setQtSaida(qtSaida);
                condition = false;
            } else {
                System.out.println("Quantidade Invalida, tente novamente!");
            }

        }
    }
}
