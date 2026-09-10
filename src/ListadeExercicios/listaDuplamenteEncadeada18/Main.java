package ListadeExercicios.listaDuplamenteEncadeada18;

public class Main {
    static void main(String[] args) {
        ListaDupla18 lista = new ListaDupla18();

        lista.adicionarNoFim(new Atendimento("Atendimento do Fred "));
        lista.adicionarNoFim(new Atendimento("Atendimento da Mel "));
        lista.adicionarNoFim(new Atendimento("Atendimento da Keka "));

        lista.iniciarAtendimento();
        lista.proximoAtendimento();
        lista.proximoAtendimento();
        lista.proximoAtendimento();

        System.out.println();

        lista.atendimentoAnterior();
        lista.atendimentoAnterior();
        lista.atendimentoAnterior();
    }
}
