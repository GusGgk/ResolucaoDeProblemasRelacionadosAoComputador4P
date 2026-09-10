package ListadeExercicios.listaEncadeadaSimples11;

public class ListaEncadeada11 {
    No11 inicio;

    public ListaEncadeada11() {
        this.inicio = null;
    }

    public void adicionarNoFim(Animal a){
        No11 novoNo = new No11(a);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        No11 atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("lista vazia");
            return;
        }
        No11 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public void removerDuplicados(){
        if (inicio == null || inicio.proximo == null){
            return;
        }
        No11 atual = inicio;
        //while (lento) -> escolhe o animal que vai ser comparado
        while(atual != null){
            No11 anterior = atual;
            No11 aux = atual.proximo;

            // While (rapido) -> varre o resto da lista tirando as cópias do atual
            while(aux != null){
                if(aux.animal.getNome().equalsIgnoreCase(atual.animal.getNome())){
                    // remove o nó duplicado (aux)
                    anterior.proximo = aux.proximo;
                    aux = aux.proximo; // pula para o próximo sem mover o anterior
                } else {
                    anterior = aux;
                    aux = aux.proximo;
                }
            }
            // avança para o proximo animal
            atual = atual.proximo;
        }
    }
}
