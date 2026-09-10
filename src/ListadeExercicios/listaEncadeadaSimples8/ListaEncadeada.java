package ListadeExercicios.listaEncadeadaSimples8;

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

    public boolean buscarNome(String nome){
        NoAnimal atual = this.inicio;
        while(atual != null){
            if(atual.animal.getNome().equalsIgnoreCase(nome)){
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
}
