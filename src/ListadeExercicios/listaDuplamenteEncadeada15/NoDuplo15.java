package ListadeExercicios.listaDuplamenteEncadeada15;

public class NoDuplo15 {
    Consulta consulta;
    NoDuplo15 proximo;
    NoDuplo15 anterior;

    public NoDuplo15(Consulta consulta) {
        this.consulta = consulta;
        this.proximo = null;
        this.anterior = null;
    }
}
