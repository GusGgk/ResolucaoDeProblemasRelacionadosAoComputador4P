package ExerciciosFilasEPilhas;

public class FilaEncadeada {

    private No inicio;
    private No fim;

    public void enqueue(String heroi) {

        No novo = new No(heroi);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public String dequeue() {

        if (inicio == null) {
            throw new RuntimeException("Fila vazia!");
        }

        String heroi = inicio.heroi;

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return heroi;
    }

    public void mostrarFila() {

        No atual = inicio;

        while (atual != null) {

            System.out.println(atual.heroi);

            atual = atual.proximo;
        }
    }
}
