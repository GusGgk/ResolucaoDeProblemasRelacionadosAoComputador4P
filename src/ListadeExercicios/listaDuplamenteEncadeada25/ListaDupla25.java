package ListadeExercicios.listaDuplamenteEncadeada25;

public class ListaDupla25 {
    NoDuplo25 inicio;
    NoDuplo25 fim;

    public ListaDupla25() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarFim(Animal a){
        NoDuplo25 novoNo = new NoDuplo25(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public void imprimir(){
        if(inicio == null){
            System.out.println("Vazio");
            return;
        }
        NoDuplo25 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

    public NoDuplo25 buscarPorNome(String nome){
        if(inicio == null){
            return null;
        }
        NoDuplo25 atual = inicio;

        while(atual != null){
            if (atual.animal.getNome().equalsIgnoreCase(nome)) {
                return atual;
            }

            atual = atual.proximo;
        }
        return null;
    }
}
