package ListadeExercicios.listaDuplamenteEncadeada21;

public class ListaDuplamente21 {
    NoDuplo21 inicio;
    NoDuplo21 fim;

    public ListaDuplamente21() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(Animal a){
        NoDuplo21 novoNo = new NoDuplo21(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;
    }

    public void imprimir(){
        if(inicio == null){
            System.out.println("vazio");
            return;
        }
        NoDuplo21 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getNome() + " e caracteristicas: " + atual.animal.getCaracteristicas());
            atual = atual.proximo;
        }
    }

    public NoDuplo21 buscarUltimoComCaracteristica(String caracteristica){
       // lista vazia de trás para frente
        if(fim == null){
            return null;
        }
        // começa teste cauda
        NoDuplo21 atual = this.fim;

        //caminha para tras
        while(atual != null){
            if(atual.animal.getCaracteristicas().equalsIgnoreCase(caracteristica)){
                return atual; // encotnrou o mais recente
            }
            atual = atual.anterior;
        }
        return null;
    }

}
