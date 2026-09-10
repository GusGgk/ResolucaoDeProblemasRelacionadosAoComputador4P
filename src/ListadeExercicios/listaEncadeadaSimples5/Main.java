package ListadeExercicios.listaEncadeadaSimples5;

public class Main {
    static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        System.out.println("Contador:");
        System.out.println(lista.contarAnimais());

        lista.inserirNoFim(new Animal("Bolinha", "Cachorro"));
        lista.inserirNoFim(new Animal("Mr.Picles", "Gato"));
        lista.inserirNoFim(new Animal("Keka", "Cachorro"));
        lista.inserirNoFim(new Animal("Piu-Piu", "Passaro"));

        System.out.println("CONTANDO ANIMAIS NOVAMENTE:");
        System.out.println(lista.contarAnimais());

    }


}
