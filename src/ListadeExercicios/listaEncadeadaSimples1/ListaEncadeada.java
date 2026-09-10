package ListadeExercicios.exercicio1;

public class ListaEncadeada {
    //referência ao primeiro da lista
    private No inicio;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void inserirNoInicio(Cachorrinho c){
        // 0(1) -> Não precisa percorrer a lista,
        // pois só mexemos na referência "inicio"
        No novoNo = new No(c); // aq c é o objeto que veio de fora (no)
        novoNo.proximo = inicio; // o proximo do no aponta para quem é o inicio até agora

        // novo no passa a ser o novo inicio da lista
        inicio = novoNo; // se a lista for vazia, inicio sera null então novoNo.proximo também vira null
    }

    public void inserirNoFim(Cachorrinho c){
        No novoNo = new No(c);
        if (inicio == null) {
            inicio = novoNo;
            return;
        }
        // se a lista não for vazia precisa encaminhar o no a no até o último
        No atual = inicio;
        while (atual.proximo != null){
            atual = atual.proximo; // passa de nó
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista() {
        if(inicio == null){
            System.out.println("A ong ainda não possui cachorrinhos cadastrados");
            return;
        }
        No atual = inicio;
        System.out.println("Cachorrinhos cadastrados na ONG Patinha Feliz:");
        while(atual != null){
            System.out.println("- " + atual.cachorrinho);
            atual = atual.proximo;
        }
    }

}
