package TDE1.Pilha;

import TDE1.Pixel;

public class Pilha {
    NoPilha topo;
    int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public boolean isEmpty(){
        return topo == null || tamanho == 0;
    }

    public void push(Pixel p){
        NoPilha novoNo = new NoPilha(p);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public NoPilha pop(){
        if(isEmpty() == true){
            System.out.println("Não dá pois a pilha está vazia");
            return null;
        }
        NoPilha removido = topo;
        topo = topo.proximo;
        tamanho--;

        removido.proximo = null;
        return removido;
    }

}
