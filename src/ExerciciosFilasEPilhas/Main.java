package ExerciciosFilasEPilhas;

import ExerciciosFilasEPilhas.FilaResgate;

public class Main {

    public static void main(String[] args) {

        FilaResgate fila = new FilaResgate(5);

        fila.enqueue(101);
        fila.enqueue(102);
        fila.enqueue(103);

        fila.mostrarFila();

        System.out.println("Pedido atendido: " + fila.dequeue());

        fila.mostrarFila();
    }
}