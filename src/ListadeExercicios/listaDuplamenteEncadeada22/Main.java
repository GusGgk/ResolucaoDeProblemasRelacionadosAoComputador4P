package ListadeExercicios.listaDuplamenteEncadeada22;

public class Main {
    static void main(String[] args) {
        ListaDeque22 deque = new ListaDeque22();

        deque.inserirFim(new Animal("Mel"));
        deque.inserirFim(new Animal("Thor"));
        deque.inserirInicio(new Animal("Bidu"));

        deque.exibirFila();

        System.out.println("Escovando o primeiro: " + deque.removerInicio().getNome());
        System.out.println("Escovando o último: " + deque.removerFim().getNome());

        deque.exibirFila();
    }
}
