package ListadeExercicios.listaEncadeadaSimples4;

public class ListaEncadeada {
    private No inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void inserirNoFim(Animal a) {
        No novoNo = new No(a);
        if (inicio == null) {
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public boolean removerPorNome(String nome) {
        if (inicio == null) {
            return false;
        }
        if (inicio.animal.getNome().equalsIgnoreCase(nome)) {
            inicio = inicio.proximo;
            return true;
        }

        No anterior = inicio;
        No atual = inicio.proximo;

        while (atual != null) {
            if (atual.animal.getNome().equalsIgnoreCase(nome)) {
                anterior.proximo = atual.proximo;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }
    public void imprimirLista(){
        if(inicio == null){
            System.out.println("Lista vazia");
            return;
        }
        No atual  = inicio;
        while(atual != null){
            System.out.println(atual.animal + " -> ");
            atual = atual.proximo;
        }
        System.out.println("Null");
    }
}
