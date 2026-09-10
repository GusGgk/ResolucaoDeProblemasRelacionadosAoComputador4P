package ExerciciosAMaisListaEncadeada.Passarinhos;

public class ListaViveiro {
    No inicio;

    public ListaViveiro(){
        this.inicio = null;
    }

    public void inserirNoInicio(Passarinho p){
        No novoNo = new No(p);
        novoNo.proximo = inicio;

        inicio = novoNo;
    }

    public void inserirNoFim(Passarinho p){
        No novoNo = new No(p);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        No atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void listarPassaros(){
        if(inicio == null){
            System.out.println("Vazio");
        }
        No atual = inicio;
        while( atual != null){
            System.out.println(atual.passarinho);
            atual = atual.proximo;
        }
    }
}
