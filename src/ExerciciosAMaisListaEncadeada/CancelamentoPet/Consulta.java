package ExerciciosAMaisListaEncadeada.CancelamentoPet;

public class Consulta {
    private String nomePet;

    public Consulta(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    @Override
    public String toString() {
        return nomePet;
    }
}
