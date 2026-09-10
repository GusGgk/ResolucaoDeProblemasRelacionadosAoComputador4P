package ListadeExercicios.listaDuplamenteEncadeada16;

public class Main {
    static void main(String[] args) {
        ListaDupla16 lista = new ListaDupla16();

        lista.adicionarPorFim(new Animal("Fred"));
        lista.adicionarPorFim(new Animal("Bidu"));
        lista.adicionarPorFim(new Animal("Keka"));

        lista.imprimir();

        System.out.println("remover bidu:");

        lista.removerPorNome("Bidu");

        lista.imprimir();


    }
}
