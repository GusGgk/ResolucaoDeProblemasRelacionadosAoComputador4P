package ListadeExercicios.listaDuplamenteEncadeada21;

public class Main {
    static void main(String[] args) {
        ListaDuplamente21 lista = new ListaDuplamente21();

        lista.adicionarNoFim(new Animal("Thor", "Vacinado"));   // Mais antigo
        lista.adicionarNoFim(new Animal("Mel", "Não Vacinado"));
        lista.adicionarNoFim(new Animal("Bidu", "Vacinado"));   // Mais recente com "Vacinado"
        lista.adicionarNoFim(new Animal("Pipoca", "Não Vacinado")); // Último da lista


        lista.imprimir();

        NoDuplo21 resultado = lista.buscarUltimoComCaracteristica("Vacinado");

        if(resultado != null){
            System.out.println("Último animal vacinado cadastrado: " + resultado.animal.getNome());
        } else{
            System.out.println("Nenhum animal encontrado com essa caracteristica");
        }
    }
}
