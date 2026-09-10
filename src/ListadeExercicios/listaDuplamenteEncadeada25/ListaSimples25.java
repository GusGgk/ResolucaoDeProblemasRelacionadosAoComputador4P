package ListadeExercicios.listaDuplamenteEncadeada25;

public class ListaSimples25 {
    NoSimples25 inicio;

    public ListaSimples25() {
        this.inicio = null;
    }

    public void imprimir(){
        if(inicio == null){
            System.out.println("vazia");
            return;
        }
        NoSimples25 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public void adicionar(Animal animal){
        NoSimples25 novoNo = new NoSimples25(animal);
        if(inicio == null){
            inicio = novoNo;
            return;
        }
        NoSimples25 atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public NoSimples25 buscarPorNome(String nome){
        if(inicio == null){
            return null;
        }

        NoSimples25 atual = inicio;

        while(atual != null){
            if(atual.animal.getNome().equalsIgnoreCase(nome)){
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }
}
