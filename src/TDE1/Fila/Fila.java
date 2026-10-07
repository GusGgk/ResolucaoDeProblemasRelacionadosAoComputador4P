package TDE1.Fila;

import TDE1.Pixel;

public class Fila {
    public NoFila inicio;
    public NoFila fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty(){
        return inicio ==  null;
    }

    public void enqueue(Pixel p){
        NoFila novoNo = new NoFila(p);
        if (isEmpty()){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public NoFila dequeue(){
        if(isEmpty()){
            return null;
        }
        NoFila atual = inicio;
        inicio = inicio.proximo;
        if (inicio == null){
            fim = null;
        }
        atual.proximo = null;
        return atual;
    }
}
