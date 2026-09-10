package ListadeExercicios.listaDuplamenteEncadeada18;


public class NoDuplo18 {
     Atendimento atendimento;
     NoDuplo18 proximo;
     NoDuplo18 anterior;

    public NoDuplo18(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.proximo = null;
        this.anterior = null;
    }
}
