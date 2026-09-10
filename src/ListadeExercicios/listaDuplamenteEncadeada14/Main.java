package ListadeExercicios.listaDuplamenteEncadeada14;

public class Main {
    static void main(String[] args) {
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();

        lista.inserirNoFim(new Passarinho("Piu-piu", "Passarinho"));
        lista.inserirNoInicio(new Passarinho("Pintinho", "Galinha"));
        lista.inserirNoInicio(new Passarinho("Falcao", "falcao"));

        lista.imprimir();
    }
}
