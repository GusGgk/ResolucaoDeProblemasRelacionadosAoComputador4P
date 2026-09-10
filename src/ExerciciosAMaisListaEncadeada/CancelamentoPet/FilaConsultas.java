package ExerciciosAMaisListaEncadeada.CancelamentoPet;

public class FilaConsultas {
    NoConsulta inicio;

    public FilaConsultas() {
        this.inicio = null;
    }

    public void adicionar(Consulta c){
        NoConsulta novoNo = new NoConsulta(c);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        NoConsulta atual = inicio;
        while(atual.proximo != null){
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public boolean cancelarConsulta(String nomePet){
        if (inicio == null){
            return false;
        }
        if (inicio.consulta.getNomePet().equalsIgnoreCase(nomePet)){
            inicio = inicio.proximo;
            return true;
        }
        NoConsulta anterior = inicio;
        NoConsulta atual = inicio.proximo;
        while(atual != null){
            if (atual.consulta.getNomePet().equalsIgnoreCase(nomePet)){
                anterior.proximo = atual.proximo;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    public void imprimirLista(){
        if(inicio == null){
            System.out.println("Vazio");
        }
        NoConsulta atual = inicio;
        while(atual != null){
            System.out.println(atual.consulta);
            atual = atual.proximo;
        }

    }
}
