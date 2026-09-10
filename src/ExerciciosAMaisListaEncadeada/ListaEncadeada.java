package ExerciciosAMaisListaEncadeada;

public class ListaEncadeada {
    No inicio;

    public ListaEncadeada(){
        this.inicio = null;
    }

    public void inserirNoFim(String nome){
        No novoNo = new No(nome);
        if (this.inicio == null){
            inicio = novoNo;
            return;
        }
        No atual = this.inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;

    }

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("vazia");
            return;
        }
        No atual = inicio;
        System.out.println("Animais cadastrados na ONG Patinha Feliz:");
        while(atual != null){
            System.out.println("- " + atual);
            atual = atual.proximo;
        }
    }
}
