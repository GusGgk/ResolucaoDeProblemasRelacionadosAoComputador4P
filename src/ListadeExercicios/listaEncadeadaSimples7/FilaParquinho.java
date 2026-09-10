package ListadeExercicios.listaEncadeadaSimples7;

public class FilaParquinho {
    NoGato inicio;

    public FilaParquinho() {
        this.inicio = null;
    }

    public void adicionarNoFim(Gato g){
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

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("Lista vazia");
            return;
        }
        NoGato atual = inicio;
        while(atual != null){
            System.out.println(atual.gato);
            atual = atual.proximo;
        }
    }

    public void inverterLista(){
        NoGato anterior = null;
        NoGato atual = this.inicio;
        NoGato proximo = null;

        while(atual != null){
            proximo = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = proximo;
        }
        this.inicio = anterior;
    }
}
