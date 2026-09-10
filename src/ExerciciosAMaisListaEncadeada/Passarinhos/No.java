package ExerciciosAMaisListaEncadeada.Passarinhos;

public class No {
    Passarinho passarinho;
    No proximo;

    public No(Passarinho passarinho) {
        this.passarinho = passarinho;
        this.proximo = null;
    }
}
