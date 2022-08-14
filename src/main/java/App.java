import src.Controller;
import src.Estacionamento.Estacionamento;

public class App{
    public static void main(String[] args){
        Estacionamento estacionamento = new Estacionamento("JS Autos","Inacil de Sá",123,"Nova Olinda","Recife");
        estacionamento.MostrarMennsagemInicial();
        Controller controller = new Controller();
        controller.init();
    }
}