package ListadeExercicios.listaEncadeadaSimples5;

public class ListaEncadeada {
    NoAnimal inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void inserirNoFim(Animal a){
        NoAnimal novoNo = new NoAnimal(a);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        NoAnimal atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public int contarAnimais(){
        int contador = 0;
        NoAnimal atual = inicio;
        while(atual != null){
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }
}
