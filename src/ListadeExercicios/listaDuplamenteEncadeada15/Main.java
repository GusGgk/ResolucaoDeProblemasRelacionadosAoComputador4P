package ListadeExercicios.listaDuplamenteEncadeada15;

public class Main {
    static void main(String[] args) {
        ListaDupla15 lista = new ListaDupla15();

        lista.adicionarNoFim(new Consulta("1- Exame de sangue - Mel"));
        lista.adicionarNoFim(new Consulta("2- Exame de Ultrassom - Keka"));
        lista.adicionarNoFim(new Consulta("3- Exame de tomografia - Fred"));

        System.out.println("Do fim para o inicio:");
        lista.imprimirDoFimParaInicio();

        System.out.println("Do inicio para o fim:");
        lista.imprimirDoInicioParaFim();
    }
}
