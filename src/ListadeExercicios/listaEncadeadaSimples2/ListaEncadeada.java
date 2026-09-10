package ListadeExercicios.listaEncadeadaSimples2;

public class ListaEncadeada {
    No inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }
    public void entrarNaFila(Animal nomePet){
        No novoNo = new No(nomePet);
        if (inicio ==null){
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public String atenderProximo(){
        if (inicio == null){
            System.out.println("Não existe pet para atender");
        }
        String petAtendido = inicio.animal.getNome();
        inicio = inicio.proximo;

        return petAtendido;
    }

    public void exibirFila(){
        if (inicio == null){
            System.out.println("Não existem pets na fila...");
        }
        No atual = inicio;
        System.out.println("Pets na fila:");
        while(atual != null){
            System.out.println( "- " + atual.animal);
            atual = atual.proximo;
        }
    }
}
