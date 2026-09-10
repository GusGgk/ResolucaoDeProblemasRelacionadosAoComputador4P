package ListadeExercicios.listaDuplamenteEncadeada23;

public class ListaDupla23 {
    No23 inicio;
    No23 fim;

    public ListaDupla23() {
        this.fim = null;
        this.inicio = null;
    }

    public void imprimirLista(){
        if(inicio==null){
            System.out.println("Lista vazia");
            return;
        }
        No23 atual = inicio;
        while(atual!=null){
            System.out.println(atual.animal.getNome() + " e sua idade: " + atual.animal.getIdade());
            atual = atual.proximo;
        }
    }

    public void inserirOrdenadoPorIdade(Animal a){
        No23 novoNo = new No23(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        //mais novo
        if(a.getIdade() <= inicio.animal.getIdade()){
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
            return;
        }
        //mais velho
        if(a.getIdade() >= fim.animal.getIdade()){
            novoNo.anterior = fim;
            fim.proximo = novoNo;
            fim = novoNo;
            return;
        }

        // ta no meio?
        No23 atual = inicio;
        while (atual != null && atual.animal.getIdade() < a.getIdade()){
            atual = atual.proximo;
        }
        novoNo.proximo = atual;
        novoNo.anterior = atual.anterior;
        atual.anterior.proximo = novoNo;
        atual.anterior = novoNo;
    }
}
