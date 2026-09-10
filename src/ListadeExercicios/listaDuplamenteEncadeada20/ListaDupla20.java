package ListadeExercicios.listaDuplamenteEncadeada20;

public class ListaDupla20 {
    NoDuplo20 inicio;
    NoDuplo20 fim;

    public ListaDupla20() {
        this.inicio = null;
        this.fim = null;
    }

    public void adicionarNoFim(Animal a){
        NoDuplo20 novoNo = new NoDuplo20(a);
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
            System.out.println("Vazio");
            return;
        }
        NoDuplo20 atual = inicio;
        while(atual != null){
            System.out.println(atual.animal.getName());
            atual = atual.proximo;
        }
    }

    public boolean trocarPosicao(String nome1, String nome2){
        if(inicio == null || nome1.equalsIgnoreCase(nome2)){
            return false;
        }
        //localizar os dois nós na lista
        NoDuplo20 n1 = inicio;
        while(n1 != null && !n1.animal.getName().equalsIgnoreCase(nome1)){
            n1 = n1.proximo;
        }
        NoDuplo20 n2 = inicio;
        while(n2 != null && !n2.animal.getName().equalsIgnoreCase(nome2)){
            n2 = n2.proximo;
        }

        // se um não existir
        if (n1 == null || n2 == null){
            return false;
        }
        // garantir n1 antes do n2
        NoDuplo20 temp = n1;
        NoDuplo20 t = inicio;
        while(t != null){
            if(t==n2){
                // n2 veio primeiro, então trocamos n1 e n2
                n1 = n2;
                n2 = temp;
                break;
            }
            if(t == n1) break; // n1 veio primeiro
            t = t.proximo;
        }

        //guardar as vizinhanças externas de n1 e n2
        NoDuplo20 n1Anterior = n1.anterior;
        NoDuplo20 n1Proximo = n1.proximo;
        NoDuplo20 n2Anterior = n2.anterior;
        NoDuplo20 n2Proximo = n2.proximo;

        //N1 n2 são vizinhos e tem troca direto
        if(n1.proximo == n2){
            n1.proximo = n2Proximo;
            n1.anterior = n2;

            n2.proximo = n1;
            n2.anterior = n1Anterior;

            if(n1Anterior != null){
                n1Anterior.proximo = n2;
            }
            if(n2Proximo != null){
                n2Proximo.anterior = n1;
            }
        }
        // n1 e n2 estão distantes
        else {
            n1.proximo = n2Proximo;
            n1.anterior = n2Anterior;

            n2.proximo = n1Proximo;
            n2.anterior = n1Anterior;

            if(n1Anterior != null){
                n1Anterior.proximo = n2;
            }
            if(n1Proximo != null){
                n1Proximo.anterior = n2;
            }
            if (n2Anterior != null){
                n2Anterior.proximo = n1;
            }
            if (n2Proximo != null){
                n2Proximo.anterior = n1;
            }
        }
        // se for inicio e fim
        if(inicio == n1){
            inicio = n2;
        } else if (inicio == n2) {
            inicio = n1;
        }

        if(fim == n1){
            fim = n2;
        } else if (fim == n2) {
            fim = n1;
        }

        return true;
    }
}
