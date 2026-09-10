package ListadeExercicios.listaEncadeadaSimples4;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirNoFim(new Animal("Amora"));
        lista.inserirNoFim(new Animal("Toby"));
        lista.inserirNoFim(new Animal("Fubá"));

        System.out.println("Fila inicial: ");
        lista.imprimirLista(); // Amora -> Toby -> Fubá -> null

        System.out.println("\nAdotando Toby...");
        lista.removerPorNome("Toby"); //[cite: 1]

        System.out.print("Fila após adoção: ");
        lista.imprimirLista(); // Amora -> Fubá -> null
    }
}
