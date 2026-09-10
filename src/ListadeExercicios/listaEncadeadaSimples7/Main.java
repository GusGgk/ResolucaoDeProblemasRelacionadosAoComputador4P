package ListadeExercicios.listaEncadeadaSimples7;

public class Main {
    static void main(String[] args) {
        FilaParquinho filaParquinho = new FilaParquinho();

        filaParquinho.adicionarNoFim(new Gato("Mingau"));
        filaParquinho.adicionarNoFim(new Gato("Frajola"));
        filaParquinho.adicionarNoFim(new Gato("Garfield"));

        System.out.println("Lista original");
        filaParquinho.imprimirLista();

        filaParquinho.inverterLista();
        System.out.println("Lista invertida");
        filaParquinho.imprimirLista();

    }
}
