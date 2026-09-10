package ListadeExercicios.listaEncadeadaSimples12;

public class ListaEncadeada12 {
    No12 inicio;

    public ListaEncadeada12() {
        this.inicio = null;
    }

    public void adicionarNoFim(Animal a){
        No12 novoNo = new No12(a);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        No12 atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("Lista Vazia");
        }
        No12 atual = inicio;
        while (atual != null) {
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public void inserirNaPosicao(Animal a, int indice){
        if(indice == 0 || this.inicio == null){
            No12 novoNo = new No12(a);
            novoNo.proximo = this.inicio;
            this.inicio = novoNo;
            return;
        }
        No12 atual = inicio;
        int pos = 0;
        while(atual != null && pos < indice - 1){
            atual = atual.proximo;
            pos++;
        }
        if(atual == null){
            System.out.println("Indice passado é maior que o tamanho da lista");
            return;
        }
        No12 novoNo = new No12(a);
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }
}
