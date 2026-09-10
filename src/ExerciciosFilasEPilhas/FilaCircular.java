package ExerciciosFilasEPilhas;

public class FilaCircular {

    private int[] chamados;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCircular() {
        chamados = new int[3];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enqueue(int chamado) {
        if (tamanho == chamados.length) {
            throw new RuntimeException("Fila cheia!");
        }

        chamados[fim] = chamado;

        fim = (fim + 1) % chamados.length;

        tamanho++;
    }

    public int dequeue() {
        if (tamanho == 0) {
            throw new RuntimeException("Fila vazia!");
        }

        int chamado = chamados[inicio];

        inicio = (inicio + 1) % chamados.length;

        tamanho--;

        return chamado;
    }

    public void mostrarFila() {
        System.out.println("Chamados na fila:");

        for (int i = 0; i < tamanho; i++) {

            int posicao = (inicio + i) % chamados.length;

            System.out.println(chamados[posicao]);
        }
    }
}