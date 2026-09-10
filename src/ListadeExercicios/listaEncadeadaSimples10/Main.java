package ListadeExercicios.listaEncadeadaSimples10;

public class Main {
    static void main(String[] args) {
        ListaEncadeada10 abrigoAmigos = new ListaEncadeada10();
        ListaEncadeada10 patasUnidas = new ListaEncadeada10();

        abrigoAmigos.adicionarNoFim(new Animal("Fred"));
        abrigoAmigos.adicionarNoFim(new Animal("Zeus"));
        abrigoAmigos.adicionarNoFim(new Animal("Panda"));

        patasUnidas.adicionarNoFim(new Animal("Mel"));
        patasUnidas.adicionarNoFim(new Animal("Keka"));

        System.out.println("ABRIGO AMIGOS:");
        abrigoAmigos.imprimirLista();
        System.out.println("=================");
        System.out.println("PATAS UNIDAS:");
        patasUnidas.imprimirLista();

        System.out.println("----------------");

        abrigoAmigos.concatenar(patasUnidas);

        System.out.println("RESULTADO DA CONCATENAÇÃO");
        abrigoAmigos.imprimirLista();
    }
}
