package ListadeExercicios.listaDuplamenteEncadeada15;

public class ListaDupla15 {
    NoDuplo15 inicio;
    NoDuplo15 fim;

    public ListaDupla15() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(Consulta c){
        NoDuplo15 novoNo = new NoDuplo15(c);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public void imprimirDoInicioParaFim(){
        if(inicio == null){
            System.out.println("Vazia");
            return;
        }
        NoDuplo15 atual = inicio;
        System.out.println("Histórico (Do mais antigo para o mais recente)");
        while(atual != null){
            System.out.println(atual.consulta.getDescricao());
            atual = atual.proximo;
        }
    }

    public void imprimirDoFimParaInicio(){
        if(fim == null){
            System.out.println("Vazia");
            return;
        }
        NoDuplo15 atual = fim;
        System.out.println("Histórico (Do mais recente para o mais antigo)");
        while(atual != null){
            System.out.println(atual.consulta.getDescricao());
            atual = atual.anterior;
        }
    }
}
