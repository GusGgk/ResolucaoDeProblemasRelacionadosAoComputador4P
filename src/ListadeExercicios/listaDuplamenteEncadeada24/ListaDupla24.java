package ListadeExercicios.listaDuplamenteEncadeada24;

public class ListaDupla24 {
    NoDuplo24 inicio;
    NoDuplo24 fim;

    public ListaDupla24() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(Animal a){
        NoDuplo24 novoNo = new NoDuplo24(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public void imprimirFim(){
        if(inicio==null){
            System.out.println("Vazio");
            return;
        }
        NoDuplo24 atual = inicio;
        while(atual!=null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public ListaDupla24 clonarLista(){
        ListaDupla24 clone = new ListaDupla24();
        if(inicio == null){
            return clone;
        }
        NoDuplo24 atual = inicio;
        while(atual != null){
            //copia todos os animais
            Animal animalCopia = new Animal(atual.animal.getNome());
            clone.adicionarNoFim(animalCopia);
            atual = atual.proximo;
        }
        return clone;
    }
}
