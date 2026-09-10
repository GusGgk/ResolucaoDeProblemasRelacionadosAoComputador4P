package ListadeExercicios.exercicio1;

public class No {
    Cachorrinho cachorrinho;
    No proximo; // referencia para o próximo nó (null se for o último)

    public No(Cachorrinho cachorrinho) {
        this.cachorrinho = cachorrinho;
        this.proximo = null; // não aponta para outro nó

    }


}
