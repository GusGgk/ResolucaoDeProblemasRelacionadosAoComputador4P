package ListadeExercicios.listaEncadeadaSimples1;

public class Program {
    static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        //inserir um cachorro no final da lista
        lista.inserirNoFim(new Cachorrinho("Fred","Yorkshire", 14));

        //outro no final da lista
        lista.inserirNoFim(new Cachorrinho("Zeus", "Vira-Lata", 7));

        //agora no inicio da fila
        lista.inserirNoInicio(new Cachorrinho("Keka","Vira-lata + pincher",1));

        //imprimir lista
        lista.imprimirLista();
    }
}
