package ListadeExercicios.listaDuplamenteEncadeada17;

public class ListaDupla17 {
    NoDuplo17 inicio;
    NoDuplo17 fim;

    public ListaDupla17() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(Animal a){
        NoDuplo17 novoNo = new NoDuplo17(a);
        if ( inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }
    public void adicionarNoInicio(Animal a){
        NoDuplo17 novoNo = new NoDuplo17(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }
        novoNo.proximo = inicio;
        inicio.anterior = novoNo;
        inicio = novoNo;
    }

    public boolean inserirDepoisDe(String nomeReferencia, Animal novoAnimal){
        if (inicio == null){
            return false;
        }
        NoDuplo17 ref = inicio;
        while(ref != null && !ref.animal.getNome().equalsIgnoreCase(nomeReferencia)){
            ref = ref.proximo;
        }
        if(ref == null){
            return false;
        }
        if (ref == fim){
            adicionarNoFim(novoAnimal);
            return true;
        }
        NoDuplo17 novoNo = new NoDuplo17(novoAnimal);
        novoNo.proximo = ref.proximo; // D aponta para C(ultimo)
        novoNo.anterior = ref; // D aponta de volta para B (penultimo)
        ref.proximo.anterior = novoNo; // C aponte de volta para D
        ref.proximo = novoNo; // B aponta para C

        return true;
    }
    public boolean inserirAntesDe(String nomeReferencia, Animal novoAnimal){
        if(inicio == null){
            return false;
        }
        NoDuplo17 ref = inicio;
        while(ref != null && !ref.animal.getNome().equalsIgnoreCase(nomeReferencia)){
            ref = ref.proximo;
        }
        if (ref == null){
            return false;
        }
        if(ref == inicio){
            adicionarNoInicio(novoAnimal);
            return true;
        }
        NoDuplo17 novoNo = new NoDuplo17(novoAnimal);
        novoNo.anterior = ref.anterior;
        novoNo.proximo = ref;
        ref.anterior.proximo = novoNo;
        ref.anterior = novoNo;
        return true;
    }

    public void imprimir(){
        if(inicio == null){
            System.out.println("lista vazia");
            return;
        }
        NoDuplo17 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome());
            atual = atual.proximo;
        }
    }

}
