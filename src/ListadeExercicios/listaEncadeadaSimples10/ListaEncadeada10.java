package ListadeExercicios.listaEncadeadaSimples10;

public class ListaEncadeada10{
    No10 inicio;

    public ListaEncadeada10() {
        this.inicio = null;
    }

    public void adicionarNoFim(Animal a){
        No10 novoNo = new No10(a);

        if(inicio == null){
            inicio = novoNo;
            return;
        }
        No10 atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("Lista vazia");
        }
        No10 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public void concatenar(ListaEncadeada10 outraLista){
        if(outraLista == null || outraLista.inicio == null){
            return;
        }
        if(this.inicio == null){
            this.inicio = outraLista.inicio;
            return;
        }

        No10 atual = this.inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = outraLista.inicio;
    }

}
