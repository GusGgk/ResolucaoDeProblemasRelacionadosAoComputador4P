package ExerciciosFilasEPilhas;

public class FilaResgate {

    private int[] pedidos;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaResgate(int capacidade) {
        pedidos = new int[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enqueue(int pedido) {
        if (fim == pedidos.length) {
            throw new RuntimeException("Fila cheia!");
        }

        pedidos[fim] = pedido;
        fim++;
        tamanho++;
    }

    public int dequeue() {
        if (tamanho == 0) {
            throw new RuntimeException("Fila vazia!");
        }

        int pedido = pedidos[inicio];

        inicio++;
        tamanho--;

        return pedido;
    }

    public void mostrarFila() {
        System.out.println("Pedidos na fila:");

        for (int i = inicio; i < fim; i++) {
            System.out.println(pedidos[i]);
        }
    }
}