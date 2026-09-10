package ListadeExercicios.listaEncadeadaSimples12;

public class Main {
    static void main(String[] args) {
        ListaEncadeada12 lista = new ListaEncadeada12();

        lista.adicionarNoFim(new Animal("Keka"));
        lista.adicionarNoFim(new Animal("Mel"));
        lista.adicionarNoFim(new Animal("Zeus"));

        lista.imprimirLista();

        System.out.println("Adicionando + um cachorro na lista na posição 1 (segundo)");
        lista.inserirNaPosicao(new Animal("Fred"),1);
        lista.imprimirLista();
    }
}
