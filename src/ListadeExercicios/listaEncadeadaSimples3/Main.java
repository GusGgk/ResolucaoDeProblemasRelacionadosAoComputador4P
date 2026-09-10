package ListadeExercicios.listaEncadeadaSimples3;

public class Main {
    static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirNoFim(new Gatinho("Café","Marrom"));
        lista.inserirNoFim(new Gatinho("Mimosa","Branco"));
        lista.inserirNoFim(new Gatinho("Garfield","Laranja"));

        int posicaoMimosa = lista.buscarPorNome("Mimosa");
        System.out.println("Posição da Mimosa: " + posicaoMimosa);

        int posicaoInexistente = lista.buscarPorNome("Bolinha");
        System.out.println("Posição da bolinha: " + posicaoInexistente);
    }
}
