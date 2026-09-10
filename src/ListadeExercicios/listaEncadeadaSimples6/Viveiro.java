package ListadeExercicios.listaEncadeadaSimples6;

public class Viveiro {
    No inicio;

    public Viveiro() {
        this.inicio = null;
    }

    public void inserirOrdenado(Passarinho p){
        No novoNo = new No(p);
        if(inicio == null || novoNo.passarinho.getNome().compareToIgnoreCase(inicio.passarinho.getNome()) < 0){
            novoNo.proximo = inicio;
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while(atual.proximo != null && atual.proximo.passarinho.getNome().compareToIgnoreCase(novoNo.passarinho.getNome()) < 0){
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if (inicio == null){
            System.out.println("Viveiro vazio");
            return;
        }
        No atual = this.inicio;
        while(atual != null){
            System.out.println(atual.passarinho.getNome());
            atual = atual.proximo;
        }

    }
}
