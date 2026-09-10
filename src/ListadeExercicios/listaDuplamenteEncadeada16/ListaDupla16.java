package ListadeExercicios.listaDuplamenteEncadeada16;

public class ListaDupla16 {
    NoDuplo16 inicio;
    NoDuplo16 fim;

    public ListaDupla16() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarPorFim(Animal a){
        NoDuplo16 novoNo = new NoDuplo16(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public boolean removerPorNome (String nome){
        if(inicio == null){
            return false;
        }
        NoDuplo16 atual = inicio;

        while(atual != null && !atual.animal.getNome().equalsIgnoreCase(nome)){
            atual = atual.proximo;
        }
        if (atual == null){
            return false;
        }

        if(atual == inicio && atual == fim){
            inicio = null;
            fim = null;
            return true;
        }

        if (atual == inicio){
            inicio = inicio.proximo; // segundo vira primeiro
            inicio.anterior = null; // desconecta a ref para o nó removido
            return true;
        }
        if(atual == fim){
            fim = fim.anterior; // o penultimo vira o ultimo
            fim.proximo = null; //desconecta a ref do nó removido
            return true;
        }

        atual.anterior.proximo = atual.proximo; // a frente do A pula o B e vai direto para C
        atual.proximo.anterior = atual.anterior; // as costas do C pula B e vai direto ao A
        return true;
    }

    public void imprimir(){
        if (inicio == null){
            System.out.println("lista vazia");
        }
        NoDuplo16 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }
}
