package ExerciciosFilasEPilhas;

public class Main4 {
    public static void main(String[] args) {

        DequeArenaVingadores arena = new DequeArenaVingadores();

        arena.addFirst("Thor");
        arena.addLast("Hulk");
        arena.addFirst("Homem de Ferro");

        arena.mostrarDeque();

        System.out.println(
                "Saiu pelo início: " + arena.removeFirst()
        );

        System.out.println(
                "Saiu pelo final: " + arena.removeLast()
        );

        arena.mostrarDeque();
    }
}
