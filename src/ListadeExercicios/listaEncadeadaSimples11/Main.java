package ListadeExercicios.listaEncadeadaSimples11;

public class Main {
    static void main(String[] args) {
        ListaEncadeada11 lista = new ListaEncadeada11();

        lista.adicionarNoFim(new Animal("Keka"));
        lista.adicionarNoFim(new Animal("Zeus"));
        lista.adicionarNoFim(new Animal("Fred"));
        lista.adicionarNoFim(new Animal("Keka"));
        lista.adicionarNoFim(new Animal("Keka"));

        System.out.println("Lista inteira");
        lista.imprimirLista();

        System.out.println("--------------");
        System.out.println("removendo duplicados");

        lista.removerDuplicados();
        lista.imprimirLista();




    }
}
