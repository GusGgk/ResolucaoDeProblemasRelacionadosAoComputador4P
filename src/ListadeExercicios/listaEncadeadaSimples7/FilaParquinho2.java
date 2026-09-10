package ListadeExercicios.listaEncadeadaSimples7;

public class FilaParquinho2 {
    NoGato inicio;

    public FilaParquinho2() {
        this.inicio = null;
    }

    public void adicionarNoFim(Gato g){
        NoGato novoNo = new NoGato(g);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        NoGato atual = inicio;
        while (atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista(){
        if (inicio == null){
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
        //1 Antes de quebrar a seta do atual, salve quem está na frente dele:
        while (atual != null){
            proximo = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = proximo;
        }
        inicio = anterior;

    }
}
