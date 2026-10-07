package ListaExerciciosArvoreBinaria;

public class ArvoreBinariaBusca {
    No raiz;

    public ArvoreBinariaBusca(){
        this.raiz = null;
    }

    public void inserir (int valor){
        No novoNo = new No(valor);
        if( raiz == null){
            raiz = novoNo;
            return;
        }
        No atual = raiz;
        while (true){
            if (valor < atual.valor){
                if(atual.esquerda == null){
                    atual.esquerda = novoNo;
                    return;
                }
                atual = atual.esquerda;
            } else if (valor > atual.valor){
                if (atual.direita == null) {
                    atual.direita = novoNo;
                    return;
                }
                atual = atual.direita;
            } else{
                return;
            }
        }
    }

    public boolean buscar(int valor){
        No atual = raiz;
        while (raiz != null){
            if (valor == atual.valor){
                return true;
            }
            if (valor < atual.valor){
                atual = atual.esquerda;
            } else{
                atual = atual.direita;
            }
        }
        return false;
    }

    public void exibirEmOrdem(){
        System.out.println("Árvore atual: ");
        if (raiz == null){
            System.out.println("Nenhum elemento na árvore");
        }
        No atual = raiz;
        while(atual.esquerda != null){
            atual = atual.esquerda;
        }
        while(atual != null){
            System.out.println(atual.valor + " ");
            atual = proximo(atual.valor);
        }
        System.out.println();
    }
    private No proximo(int valor){
        No candidato = null;
        No no = raiz;
        while (no != null){
            if(no.valor > valor){
                candidato = no;
                no = no.esquerda;
            } else{
                no = no.direita;
            }
        }
        return candidato;
    }

    public void remover(int valor){
        if(raiz == null){
            System.out.println("Não existem nós para serem removidos");
        }
        if (!buscar(valor)){
            System.out.println("Valor " + valor + " Não encontrado");
        }

        No pai = null;
        No atual = raiz;
        while(atual.valor != valor){ // guarda pai
            pai = atual;
            if(valor < atual.valor){
                atual = atual.esquerda;
            }
            else {
                atual = atual.direita;
            }
        }
        //Caso 3: dois filhos -> usa sucessor
        if(atual.esquerda != null && atual.direita != null){
            No paiSucessor = atual;
            No sucessor = atual.direita; // uma vez à direita
            while (sucessor.esquerda != null){ // e sempre a esquerda
                paiSucessor = sucessor;
                sucessor = sucessor.esquerda;
            }
            atual.valor = sucessor.valor;
            pai = paiSucessor;
            atual = sucessor;
        }
        // caso 1 e 2: folha ou 1 filho
        No filho = (atual.esquerda != null) ? atual.esquerda : atual.direita;

        if(pai == null){
            raiz = filho;
        } else if (pai.esquerda == atual) {
            pai.esquerda = filho;
        } else{
            pai.direita = filho;
        }
        exibirEmOrdem();
    }
}
