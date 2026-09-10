package ExerciciosFilasEPilhas;

public class Exercicio2FilaCircular {
    private int[] chamados;
    private int inicio;
    private int fim;
    private int tamanho;

    public Exercicio2FilaCircular(){
        chamados = new int[3];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void adicionarChamado(int chamado){
        if(tamanho == chamados.length){
            System.out.println("Fila cheia! Batman precisa atender um chamado");
            return;
        }

        chamados[fim] = chamado;
        fim = (fim + 1) % chamados.length;

        tamanho++;
    }

    public int atenderChamado(){
        if(tamanho==0){
            throw new RuntimeException("Não existem chamados em andamento");
        }
        int chamado = chamados[inicio];

        inicio = (inicio + 1) % chamados.length;

        tamanho--;
        return  chamado;
    }

    public void mostrarChamados(){
        System.out.println("Bat-Sinais aguardando:");

        for(int i = 0; i < tamanho; i++){
            int posicao = (inicio + i) % chamados.length;
            System.out.println(chamados[posicao]);
        }
    }
}
