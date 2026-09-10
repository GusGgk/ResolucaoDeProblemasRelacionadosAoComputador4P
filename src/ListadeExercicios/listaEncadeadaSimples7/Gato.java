package ListadeExercicios.listaEncadeadaSimples7;

public class Gato {
    private String nome;

    public Gato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
