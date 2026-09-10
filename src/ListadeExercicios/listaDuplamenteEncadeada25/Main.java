package ListadeExercicios.listaDuplamenteEncadeada25;

public class Main {
    static void main(String[] args) {
        ListaSimples25 listaSimples = new ListaSimples25();
        listaSimples.adicionar(new Animal("Thor"));
        listaSimples.adicionar(new Animal("Mel"));

        NoSimples25 resultado1 = listaSimples.buscarPorNome("Mel");
        System.out.println("Busca Simples: " + resultado1.animal.getNome());

        ListaDupla25 listaDupla = new ListaDupla25();
        listaDupla.adicionarFim(new Animal("Thor"));
        listaDupla.adicionarFim(new Animal("Mel"));

        NoDuplo25 resultado2 = listaDupla.buscarPorNome("Mel");
        System.out.println("Busca Dupla: " + resultado2.animal.getNome());
    }
}
