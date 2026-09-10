package ListadeExercicios.listaEncadeadaSimples13;

public class ListaCircular {
    No13 inicio;

    public ListaCircular() {
        this.inicio = null;
    }

    public void adicionarNoFim(Animal a){
        No13 novoNo = new No13(a);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        No13 atual = inicio;
        while (atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void tornarCircular(){
        if (inicio == null){
            System.out.println("vazio");
            return;
        }
        No13 atual = inicio;
        while(atual.proximo != null && atual.proximo != inicio){
            atual = atual.proximo;
        }
        atual.proximo = this.inicio;
    }
    public void simularRodizio(int voltas){
        if(inicio == null){
            System.out.println("Não existem animais na lista");
            return;
        }
        int totalAnimais = 0;
        No13 atual = inicio;

        do{
            totalAnimais++;
            atual = atual.proximo;
        } while (atual != this.inicio);

        int totalPassos = totalAnimais * voltas;

        atual = inicio;
        for (int i = 0; i < totalPassos; i++) {
            System.out.println("Volta " + ((i / totalAnimais) + 1 ) + " - Animal " + atual.animal.getNome() + " está brincando!");
            atual = atual.proximo;
        }
    }

}
