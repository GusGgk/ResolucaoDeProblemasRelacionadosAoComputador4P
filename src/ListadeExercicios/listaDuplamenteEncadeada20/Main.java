package ListadeExercicios.listaDuplamenteEncadeada20;

public class Main {
    static void main(String[] args) {
        ListaDupla20 lista = new ListaDupla20();

        lista.adicionarNoFim(new Animal("Thor"));
        lista.adicionarNoFim(new Animal("Mel"));
        lista.adicionarNoFim(new Animal("Amora"));
        lista.adicionarNoFim(new Animal("Bob"));

        System.out.println("--- Antes da troca ---");
        lista.imprimir(); // thor, mel, amora e bob

        //trocar mel e amora
        lista.trocarPosicao("Mel","Amora");

        System.out.println("--- Depois da Troca ---");
        lista.imprimir();
    }
}
