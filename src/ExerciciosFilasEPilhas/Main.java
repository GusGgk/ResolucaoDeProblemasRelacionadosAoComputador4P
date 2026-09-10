package ExerciciosFilasEPilhas;

public class Main1 {
    static void main(String[] args) {
        Exercicio1FilaResgate filaResgate = new Exercicio1FilaResgate(5);

        filaResgate.inserirPedido(101);
        filaResgate.inserirPedido(102);
        filaResgate.inserirPedido(103);

        filaResgate.mostrarPedidos();

        System.out.println("Atendendo: " + filaResgate.atenderPedido());

        filaResgate.mostrarPedidos();
    }
}
