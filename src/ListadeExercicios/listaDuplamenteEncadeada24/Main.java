package ListadeExercicios.listaDuplamenteEncadeada24;

public class Main {
    static void main(String[] args) {
        ListaDupla24 original = new ListaDupla24();

        original.adicionarNoFim(new Animal("Thor"));
        original.adicionarNoFim(new Animal("Mel"));

        ListaDupla24 backup = original.clonarLista();

        System.out.println("LISTA ORIGINAL");
        original.imprimirFim();

        System.out.println("LISTA BACKUP");
        backup.imprimirFim();


        System.out.println("Vou adicionar mais um elemento na original e comparar:");
        // modificando original
        original.adicionarNoFim(new Animal("Fred"));

        System.out.println("LISTA ORIGINAL");
        original.imprimirFim();

        System.out.println("LISTA BACKUP");
        backup.imprimirFim();

    }

}
