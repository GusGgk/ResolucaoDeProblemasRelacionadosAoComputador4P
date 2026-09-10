package ListadeExercicios.listaEncadeadaSimples9;

public class ListaEncadeada9 {
    No9 inicio;

    public ListaEncadeada9() {
        this.inicio = null;
    }

    public void adicionarAnimalFim(Animal a){
        No9 novoNo = new No9(a);

        if (inicio == null){
            inicio = novoNo;
            return;
        }
        No9 atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if (inicio == null){
            System.out.println("Nenhum animal na lista");
        }
        No9 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public No9 buscarMaisVelho (){
        if(inicio == null){
            return null;
        }
        No9 maisVelho = inicio;
        No9 atual = inicio;

        while(atual != null){
            if(atual.animal.getIdade() > maisVelho.animal.getIdade()){
                maisVelho = atual;
            }
            atual = atual.proximo;
        }
        return maisVelho;
    }
}
