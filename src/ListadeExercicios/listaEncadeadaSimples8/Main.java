package ListadeExercicios.listaEncadeadaSimples8;

public class Main {
    static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirNoFim(new Animal("Fred"));
        lista.inserirNoFim(new Animal("Fubá"));
        lista.inserirNoFim(new Animal("Keka"));

        System.out.println("Buscando nome certo:");
        System.out.println(lista.buscarNome("Keka"));
        System.out.println("Buscando nome errado:");
        System.out.println(lista.buscarNome("Thomas"));
    }
}
