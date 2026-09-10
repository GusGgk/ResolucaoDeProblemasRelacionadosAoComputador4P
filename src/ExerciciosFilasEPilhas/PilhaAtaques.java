package ExerciciosFilasEPilhas;

public class PilhaAtaques {

    private String[] ataques;
    private int topo;

    public PilhaAtaques(int capacidade) {
        ataques = new String[capacidade];
        topo = -1;
    }

    public void push(String ataque) {

        if (topo == ataques.length - 1) {
            throw new RuntimeException("Pilha cheia!");
        }

        topo++;

        ataques[topo] = ataque;
    }

    public String pop() {

        if (topo == -1) {
            throw new RuntimeException("Pilha vazia!");
        }

        String ataque = ataques[topo];

        topo--;

        return ataque;
    }

    public void mostrarPilha() {

        System.out.println("Ataques na pilha:");

        for (int i = topo; i >= 0; i--) {
            System.out.println(ataques[i]);
        }
    }
}
