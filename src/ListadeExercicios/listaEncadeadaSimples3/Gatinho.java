package ListadeExercicios.listaEncadeadaSimples3;

public class Gatinho {
    String nome;
    String corPelo;

    public Gatinho(String nome, String corPelo) {
        this.nome = nome;
        this.corPelo = corPelo;
    }

    @Override
    public String toString() {
        return nome + " (Pelo: " + corPelo +" )";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
}
