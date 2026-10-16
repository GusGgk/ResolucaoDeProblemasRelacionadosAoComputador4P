package RA2.SimuladoProva;

public class No {
    int valor;
    No esquerda, direita;
    No (int v){
        valor = v;
    }

    No raiz;
    int quantidade;


    //A - com laço, olhando o proximo no antes de descer
    public boolean inserir(int valor){
        if(raiz == null){
            raiz = new No(valor);
            quantidade++;
        }
        No atual = raiz;
        while(true){
            if(valor == atual.valor){
                return false;
            }
            No proximo = (valor < atual.valor) ? atual.esquerda : atual.direita;
            if(proximo == null){
                if(valor < atual.valor){
                    atual.esquerda = new No(valor);
                }
                else{
                    atual.direita = new No(valor);
                }
                quantidade++;
                return true;
            }
            atual = proximo;
        }
    }

    // B = Recursiva, com um método auxiliar
    public boolean inserir2(int valor){
        if (raiz == null){
            raiz = new No(valor);
            quantidade++;
            return true;
        }
        return inserirAbaixo(raiz,valor);
    }
    private boolean inserirAbaixo(No no, int valor){
        if(valor == no.valor){
            return false;
        }
        if(valor < no.valor){
            if(no.esquerda == null){
                no.esquerda = new No(valor);
                quantidade++;
                return true;
            }
            return inserirAbaixo(no.esquerda,valor);
        } else{
            if(no.direita == null){
                no.direita = new No(valor);
                quantidade++;
                return true;
            } return inserirAbaixo(no.direita, valor);
        }
    }

    //C - Com laço, lembrando o pai e o lado por onde desceu
    public boolean inserir3(int valor){
        No pai = null, atual = raiz;
        boolean foiParaEsquerda = false;
        while(atual != null){
            if(valor == atual.valor){
                return false;
            }
            pai = atual;
            foiParaEsquerda = valor < atual.valor;
            atual = foiParaEsquerda ? atual.esquerda : atual.direita;
        }
        No novo = new No(valor);
        if(pai == null){
            raiz = novo;
        } else if (foiParaEsquerda) {
            pai.esquerda = novo;
        } else{
            pai.direita = novo;
        }
        quantidade ++;
        return true;
    }
}
