package ExerciciosFilasEPilhas;

public class Main3 {
    public static void main(String[] args) {

        FilaEncadeada fila = new FilaEncadeada();

        fila.enqueue("Batman");
        fila.enqueue("Flash");
        fila.enqueue("Aquaman");

        fila.mostrarFila();

        System.out.println("Chamado pelo Superman: " + fila.dequeue());

    }
}
