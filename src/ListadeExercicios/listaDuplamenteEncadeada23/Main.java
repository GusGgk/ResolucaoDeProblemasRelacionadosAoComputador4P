package ListadeExercicios.listaDuplamenteEncadeada23;

public class Main {
    static void main(String[] args) {
        ListaDupla23 lista = new ListaDupla23();

        lista.inserirOrdenadoPorIdade(new Animal("Mel",8));
        lista.inserirOrdenadoPorIdade(new Animal("Keka",1));
        lista.inserirOrdenadoPorIdade(new Animal("Zeus",9));
        lista.inserirOrdenadoPorIdade(new Animal("Fred",16));
        lista.inserirOrdenadoPorIdade(new Animal("Panda",11));

        lista.imprimirLista();
    }
}
