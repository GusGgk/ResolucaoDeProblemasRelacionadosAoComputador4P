package ListadeExercicios.listaDuplamenteEncadeada14;

public class ListaDuplaEncadeada {
    No14 inicio;
    No14 fim;

    public ListaDuplaEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    public void inserirNoFim(Passarinho p){
        No14 novoNo = new No14(p);

        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim; // costas do novoNo apontam para o antigo fim
        fim.proximo = novoNo; // frente do antigo fim aponta para o novoNo
        fim = novoNo; // atualiza referência do fim
    }

    public void inserirNoInicio(Passarinho p){
        No14 novoNo = new No14(p);
        if (inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }

        //conecta a frente do novoNo ao antigo Inicio
        novoNo.proximo = inicio;
        // conecta as costas do antigo inicio ao novoNo
        inicio.anterior = novoNo;
        inicio = novoNo;
    }

    public void imprimir(){
        No14 atual = inicio;

        while(atual != null){
            System.out.println(atual.passarinho.getNome());
            atual = atual.proximo;
        }
    }
}
