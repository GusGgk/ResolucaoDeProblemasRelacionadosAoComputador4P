package ListadeExercicios.listaDuplamenteEncadeada17;

public class Main {
    static void main(String[] args) {
        ListaDupla17 lista = new ListaDupla17();

        lista.adicionarNoFim(new Animal("Fred"));
        lista.adicionarNoFim(new Animal("Zeus"));
        lista.adicionarNoFim(new Animal("Panda"));

        lista.imprimir();

        System.out.println("Adicionando uma cachorrinha antes do 'Zeus'");

        lista.inserirAntesDe("Zeus", new Animal("Mel"));
        lista.imprimir();

        System.out.println("Adicionando uma cachorrinha depois da 'Mel' adicionada anteriormente");

        lista.inserirDepoisDe("Mel", new Animal("Keka"));

        lista.imprimir();
    }
}
