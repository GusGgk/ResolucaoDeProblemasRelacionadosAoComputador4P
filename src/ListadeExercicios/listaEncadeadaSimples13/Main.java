package ListadeExercicios.listaEncadeadaSimples13;

public class Main {
    static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular();

        listaCircular.adicionarNoFim(new Animal("Fred"));
        listaCircular.adicionarNoFim(new Animal("Keka"));
        listaCircular.adicionarNoFim(new Animal("Zeus"));
        listaCircular.adicionarNoFim(new Animal("Mel"));

        listaCircular.tornarCircular();

        listaCircular.simularRodizio(3);
    }
}
