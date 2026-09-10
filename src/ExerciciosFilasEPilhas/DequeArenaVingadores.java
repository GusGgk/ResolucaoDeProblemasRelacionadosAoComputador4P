package ExerciciosFilasEPilhas;

import java.util.Deque;
import java.util.LinkedList;

public class DequeArenaVingadores {

    private Deque<String> herois = new LinkedList<>();

    public void addFirst(String heroi) {
        herois.addFirst(heroi);
    }

    public void addLast(String heroi) {
        herois.addLast(heroi);
    }

    public String removeFirst() {

        if (herois.isEmpty()) {
            throw new RuntimeException("Deque vazio!");
        }

        return herois.removeFirst();
    }

    public String removeLast() {

        if (herois.isEmpty()) {
            throw new RuntimeException("Deque vazio!");
        }

        return herois.removeLast();
    }

    public void mostrarDeque() {
        System.out.println(herois);
    }
}