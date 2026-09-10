package ListadeExercicios.listaEncadeadaSimples6;

public class Passarinho {
    private String nome;

    public Passarinho(String nome) {
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
