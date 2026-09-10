package ExerciciosAMaisListaEncadeada.PatinhasLimpas;

public class Main {
    static void main(String[] args) {
        FilaTosa lista = new FilaTosa();

        lista.adicionarGato(new Gato("Mimi",2));
        lista.adicionarGato(new Gato("Tom",4));
        lista.adicionarGato(new Gato("Soneca",1));

        lista.mostrarFila();
        System.out.println("Numero de gatos na fila:");
        System.out.println(lista.contarGatos());
    }
}
