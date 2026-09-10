package ExerciciosAMaisListaEncadeada.PatinhasLimpas;

public class FilaTosa {
    NoGato inicio;

    public FilaTosa() {
        this.inicio = null;
    }

    public void adicionarGato(Gato g){
        NoGato novoNo = new NoGato(g);
        if(inicio == null){
            inicio = novoNo;
            return;
        }
        NoGato atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }
    public void mostrarFila(){
        if (inicio == null){
            System.out.println("sem gatos");
        }
        NoGato atual = inicio;
        while(atual != null){
            System.out.println(atual.gato);
            atual = atual.proximo;
        }
    }

    public int contarGatos(){
        int total = 0;
        NoGato atual = inicio;
        while(atual != null){
            atual = atual.proximo;
            total++;
        }
        return total;
    }
}
