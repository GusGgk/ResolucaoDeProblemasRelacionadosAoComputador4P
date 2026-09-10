package ExerciciosFilasEPilhas;

public class Exercicio1FilaResgate {
    private int[] pedidos;
    private int inicio;
    private int fim;
    private int tamanho;

    public Exercicio1FilaResgate(int capacidade) {
        pedidos = new int[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void inserirPedido(int pedido){
        if(fim == pedidos.length){
            throw new RuntimeException("Fila cheia!");
        }

        pedidos[fim] = pedido;
        fim++;
        tamanho++;
    }

    public int atenderPedido() {
        if (tamanho == 0) {
            throw new RuntimeException("Fila vazia!");
        }

        int pedido = pedidos[inicio];
        inicio++;
        tamanho--;

        return pedido;
    }

    public void mostrarPedidos(){
        System.out.println("Pedidos aguardando");
        for (int i = inicio; i < fim; i++){
            System.out.println(pedidos[i]);
        }
    }
}
