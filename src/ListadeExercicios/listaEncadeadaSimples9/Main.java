package ListadeExercicios.listaEncadeadaSimples9;

public class Main {
    static void main(String[] args) {
        ListaEncadeada9 lista = new ListaEncadeada9();

        lista.adicionarAnimalFim(new Animal("Mel",8));
        lista.adicionarAnimalFim(new Animal("Panda",12));
        lista.adicionarAnimalFim(new Animal("Fred",16));
        lista.adicionarAnimalFim(new Animal("Keka",1));
        lista.adicionarAnimalFim(new Animal("Zeus",7));

        lista.imprimirLista();

        System.out.println();
        No9 maisVelho = lista.buscarMaisVelho();

        if(maisVelho != null){
            System.out.println("Animal mais velho é " + maisVelho.animal.getNome() + " com "+ maisVelho.animal.getIdade() + " anos.");
        }

    }
}
