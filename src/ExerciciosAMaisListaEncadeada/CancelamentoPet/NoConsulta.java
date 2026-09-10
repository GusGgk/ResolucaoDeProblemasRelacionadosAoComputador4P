package ExerciciosAMaisListaEncadeada.CancelamentoPet;

public class NoConsulta {
    Consulta consulta;
    NoConsulta proximo;

    public NoConsulta(Consulta consulta) {
        this.consulta = consulta;
        this.proximo = null;
    }
}
