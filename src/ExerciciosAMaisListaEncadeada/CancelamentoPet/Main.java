package ExerciciosAMaisListaEncadeada.CancelamentoPet;

public class Main {
    static void main(String[] args) {
        FilaConsultas listas = new FilaConsultas();

        listas.adicionar(new Consulta("Rex"));
        listas.adicionar(new Consulta("Thor"));
        listas.adicionar(new Consulta("Ameixa"));

        listas.cancelarConsulta("Thor");
        listas.cancelarConsulta("Rex");

        listas.imprimirLista();
    }
}
