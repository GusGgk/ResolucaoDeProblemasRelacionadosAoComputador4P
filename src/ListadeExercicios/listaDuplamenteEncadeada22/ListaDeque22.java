package ListadeExercicios.listaDuplamenteEncadeada22;

public class ListaDeque22 {
    NoDuplo22 inicio;
    NoDuplo22 fim;

    public ListaDeque22() {
        this.inicio = null;
        this.fim = null;
    }
    public void inserirInicio(Animal animal){
        NoDuplo22 novoNo = new NoDuplo22(animal);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.proximo = inicio;
        inicio.anterior = novoNo;
        inicio = novoNo;
    }

    public void inserirFim(Animal animal){
        NoDuplo22 novoNo = new NoDuplo22(animal);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public Animal removerInicio(){
        if(inicio == null){
            System.out.println("fila vazia");
            return null;
        }
        Animal atendido = inicio.animal;
        //unico elemento
        if(inicio == fim){
            inicio = null;
            fim = null;
            return atendido;
        }

        inicio = inicio.proximo;
        inicio.anterior = null;

        return atendido;
    }

    public Animal removerFim() {
        if (inicio == null){
            System.out.println("fila vazia");
            return null;
        }
        Animal atendido = fim.animal;

        if(inicio == fim){
            inicio = null;
            fim = null;
            return atendido;
        }
        fim = fim.anterior;
        fim.proximo = null;

        return atendido;
    }
    public void exibirFila(){
        if(inicio == null){
            System.out.println("fila vazia");
            return;
        }
        NoDuplo22 atual = inicio;
        System.out.println("FILA DE ESCOVAÇÃO:");
        while(atual!=null){
            System.out.println("[" + atual.animal.getNome() + "]");
            atual = atual.proximo;
        }
        System.out.println();
    }


}
