package ListadeExercicios.listaEncadeadaSimples3;

public class ListaEncadeada {
    private No inicio;

    public ListaEncadeada() {
        this.inicio = inicio;
    }

    public void inserirNoFim(Gatinho g){
        No novoNo = new No(g);
        if(inicio == null){
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public int buscarPorNome(String nome){
        No atual = inicio;
        int indice = 0;

        while(atual != null){
            if(atual.gatinho.nome.equalsIgnoreCase(nome)){
                return indice;
            }
            // não achou, anda um para frente e soma indice
            atual = atual.proximo;
            indice++;
        }
        return -1;
    }
}
