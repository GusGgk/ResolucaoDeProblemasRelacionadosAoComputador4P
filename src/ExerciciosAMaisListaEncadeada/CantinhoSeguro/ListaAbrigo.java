package ExerciciosAMaisListaEncadeada.CantinhoSeguro;

public class ListaAbrigo {
    NoAnimal inicio;

    public ListaAbrigo() {
        this.inicio = null;
    }

    public void cadastrar(Animal a){
        NoAnimal novoNo = new NoAnimal(a);
        if (inicio == null){
            inicio = novoNo;
            return;
        }
        NoAnimal atual = inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public boolean existeAnimal(String nomeBuscado){
        NoAnimal atual = this.inicio;
        while(atual != null){
            if(atual.animal.getNome().equalsIgnoreCase(nomeBuscado)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }


}
