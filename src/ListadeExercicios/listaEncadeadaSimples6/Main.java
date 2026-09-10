package ListadeExercicios.listaEncadeadaSimples6;

public class Main {
    static void main(String[] args) {
        Viveiro viveiro = new Viveiro();

        viveiro.inserirOrdenado(new Passarinho("Piu"));
        viveiro.inserirOrdenado(new Passarinho("Canário"));
        viveiro.inserirOrdenado(new Passarinho("Bem-te-vi"));

        System.out.println("LISTA do VIVEIROS:");
        viveiro.imprimirLista();

    }
}
