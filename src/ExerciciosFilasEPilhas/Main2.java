package ExerciciosFilasEPilhas;

import ExerciciosFilasEPilhas.FilaCircular;

public class Main2 {

    public static void main(String[] args) {

        FilaCircular fila = new FilaCircular();

        fila.enqueue(101);
        fila.enqueue(102);
        fila.enqueue(103);
        fila.enqueue(104);

        fila.mostrarFila();

        System.out.println("Batman atendeu: "
                + fila.dequeue());

        fila.enqueue(104);

        fila.mostrarFila();
    }
}