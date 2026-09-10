package ExerciciosAMaisListaEncadeada;

public class No {
    String nome;
    No proximo;

    public No(String nome) {
        this.nome = nome;
        this.proximo = null;
    }

    @Override
    public String toString() {
        return nome;
    }
}
