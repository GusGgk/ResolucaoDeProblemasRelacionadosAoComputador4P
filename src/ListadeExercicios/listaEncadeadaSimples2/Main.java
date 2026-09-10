package ListadeExercicios.listaEncadeadaSimples2;

public class Main {
    static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.entrarNaFila(new Animal("Fred"));
        lista.entrarNaFila(new Animal("Zeus"));
        lista.entrarNaFila(new Animal("Keka"));

        lista.exibirFila();

        lista.atenderProximo();

        lista.exibirFila();
        lista.atenderProximo();

        lista.exibirFila();
    }
}
