package ExerciciosFilasEPilhas;

public class Main5 {
    public static void main(String[] args) {

        PilhaAtaques pilha = new PilhaAtaques(5);

        pilha.push("Soco");
        pilha.push("Chute");
        pilha.push("Raio");

        pilha.mostrarPilha();

        System.out.println(
                "Ataque removido: " + pilha.pop()
        );

        pilha.mostrarPilha();
    }
}
