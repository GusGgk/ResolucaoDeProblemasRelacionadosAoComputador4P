package ExerciciosAMaisListaEncadeada.Passarinhos;

public class Main {
    static void main(String[] args) {
        ListaViveiro lista = new ListaViveiro();

        lista.inserirNoFim(new Passarinho("Canario","Verde e amarelo"));
        lista.inserirNoFim(new Passarinho("Piu","Amarelo"));
        lista.inserirNoInicio(new Passarinho("Rio", "Azul"));

        lista.listarPassaros();

    }
}
