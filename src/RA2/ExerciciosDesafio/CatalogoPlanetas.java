package RA2.ExerciciosDesafio;// Missao Orbita: Catalogo de Exoplanetas (BST)
// Nome do aluno(a): Gustavo Giacoia Kumagai
//
// Complete todos os trechos marcados com TODO.
// NAO altere as assinaturas dos metodos publicos nem o main().

public class CatalogoPlanetas {

    // ---------------- Tarefa 1: o no ----------------
    private class No {
        int distancia;        // chave: distancia em anos-luz (unica)
        String nome;
        String tipo;
        boolean habitavel;
        No esquerda;
        No direita;

        No(int distancia, String nome, String tipo, boolean habitavel) {
            this.distancia = distancia;
            this.nome = nome;
            this.tipo = tipo;
            this.habitavel = habitavel;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;
    private int quantidade;

    // ---------------- Tarefa 2: catalogar (inserir) ----------------
    // Insere o planeta respeitando a regra da BST.
    // Se ja existir planeta com a mesma distancia, imprime
    // "Recusado: ja existe planeta a X anos-luz." e devolve false.
    public boolean catalogar(int distancia, String nome, String tipo, boolean habitavel) {
        No novoNo = new No(distancia,nome,tipo,habitavel);
        if (raiz == null){
            raiz = novoNo;
            quantidade++;
            return true;
        }
        No atual = raiz;
        while(true){
            if(distancia == atual.distancia){
                System.out.println("Recusado: já existe planeta a " + distancia + " anos-luz");
                return false;
            }
            else if (distancia < atual.distancia){
                if(atual.esquerda == null){
                    atual.esquerda = novoNo;
                    quantidade++;
                    return true;
                }
                atual = atual.esquerda;
            }
            else{
                if(atual.direita == null){
                    atual.direita = novoNo;
                    quantidade++;
                    return true;
                }
                atual = atual.direita;
            }
        }
    }

    // ---------------- Tarefa 3: localizar (buscar) ----------------
    // Imprime a rota percorrida e devolve o nome do planeta (ou null).
    // Formato:  Rota ate 45: 50 30 40 45 -> Bolha (4 saltos)
    //           Rota ate 55: 50 75 60 -> sinal perdido (3 saltos)
    public String localizar(int distancia) {
        String rota = "";
        int saltos = 0;

        No atual = raiz;
        while(atual!=null){
            saltos++;
            rota += atual.distancia + " ";
            if(distancia == atual.distancia){
                System.out.println("Rota ate " + distancia + ": " + rota + "-> " + atual.nome + " (" + saltos + " saltos)");
                return atual.nome;
            }
            else if(distancia < atual.distancia){
                atual = atual.esquerda;
            } else{
                atual = atual.direita;
            }
        }
            System.out.println("Rota até " + distancia + ": " + rota + "-> sinal perdido (" + saltos + " saltos)");
            return null;
    }

    // ---------------- Tarefa 4: extremos ----------------
    // Devolvem o nome do planeta mais proximo / mais distante (null se vazio).
    private No menorNo (No atual){
        while(atual.esquerda != null){
            atual = atual.esquerda;
        }
        return atual;
    }
    private No maiorNo(No atual){
        while(atual.direita!=null){
            atual = atual.direita;
        }
        return atual;
    }
    public String maisProximo() {
        if(raiz == null){
            return null;
        } else{
            return menorNo(raiz).nome;
        }
    }

    public String maisDistante() {
        if(raiz == null){
            return null;
        } else{
            return maiorNo(raiz).nome;
        }
    }

    // ---------------- Tarefa 5: descatalogar (remover) ----------------
    // Os dois metodos removem o planeta e devolvem true (false se nao existir).
    // No caso de dois filhos:
    //   - PelosMenores: o substituto e o Maior da subarvore esquerda
    //   - PelosMaiores: o substituto e o Menor da subarvore direita
    // Atencao: copie TODOS os dados do substituto (nao so a distancia)!
    private No removerPelosMenores(No atual, int distancia){
        if(atual == null) return null;

        if(distancia < atual.distancia){
            atual.esquerda = removerPelosMenores(atual.esquerda, distancia);
        } else if(distancia > atual.distancia){
            atual.direita = removerPelosMenores(atual.direita, distancia);
        } else{
            // encontrou o no
            //caso 1 e 2, sem filho a esquerda ou sem filho a direita
            if(atual.esquerda == null) return atual.direita;
            if(atual.direita == null) return atual.esquerda;

            //caso 3 dois filhos (maior da esquerda)
            No substituto = maiorNo(atual.esquerda);

            atual.distancia = substituto.distancia;
            atual.nome = substituto.nome;
            atual.tipo = substituto.tipo;
            atual.habitavel = substituto.habitavel;

            //remove o no subs
            atual.esquerda = removerPelosMenores(atual.esquerda, substituto.distancia);
        }
        return atual;
    }

    private No removerPelosMaiores(No atual, int distancia) {
        if (atual == null) return null;

        if (distancia < atual.distancia) {
            atual.esquerda = removerPelosMaiores(atual.esquerda, distancia);
        } else if (distancia > atual.distancia) {
            atual.direita = removerPelosMaiores(atual.direita, distancia);
        } else {
            // Encontrou o nó a remover!

            // Caso 1 e 2: Sem filho à esquerda ou sem filho à direita
            if (atual.esquerda == null) return atual.direita;
            if (atual.direita == null) return atual.esquerda;

            // Caso 3: Dois filhos -> Menor da subárvore direita (usando o menorNo da Tarefa 4)
            No substituto = menorNo(atual.direita);

            // Copia TODOS os dados do substituto
            atual.distancia = substituto.distancia;
            atual.nome = substituto.nome;
            atual.tipo = substituto.tipo;
            atual.habitavel = substituto.habitavel;

            // Remove o nó substituto da subárvore direita
            atual.direita = removerPelosMaiores(atual.direita, substituto.distancia);
        }
        return atual;
    }

    private boolean contem(int distancia) {
        No atual = raiz;
        while (atual != null) {
            if (distancia == atual.distancia) return true;
            else if (distancia < atual.distancia) atual = atual.esquerda;
            else atual = atual.direita;
        }
        return false;
    }

    public boolean descatalogarPelosMenores(int distancia) {
        if (contem(distancia)) {
            raiz = removerPelosMenores(raiz, distancia);
            quantidade--;
            return true;
        }
        return false;
    }

    public boolean descatalogarPelosMaiores(int distancia) {
        if (contem(distancia)) {
            raiz = removerPelosMaiores(raiz, distancia);
            quantidade--;
            return true;
        }
        return false;
    }

    // ---------------- Tarefa 6: relatorios ----------------
    // Formato: Catalogo: 10(Pipoca) 15(Rubi-9) ... 95(Tita)
    public void listarEmOrdem() {
        System.out.print("Catálogo: ");
        emOrdemRec(raiz);
        System.out.println();
    }
    private void emOrdemRec(No no){
        if(no != null){
            emOrdemRec(no.esquerda);
            System.out.print(no.distancia + "(" + no.nome + ") ");
            emOrdemRec(no.direita);
        }
    }

    // Altura: arvore vazia = -1, so a raiz = 0
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(No no){
        if(no == null){
            return -1;
        }
        return 1 + Math.max(alturaRec(no.esquerda), alturaRec(no.direita));
    }

    public int contarHabitaveis() {
        return contarHabitaveisRec(raiz);
    }
    private int contarHabitaveisRec(No no) {
        if(no == null){
            return 0;
        }
        int soma = no.habitavel ? 1 : 0;
        return soma + contarHabitaveisRec(no.esquerda) + contarHabitaveisRec(no.direita);
    }

    public int getQuantidade() {
        return quantidade;
    }

    // ---------------- Desafio (bônus) ----------------
    // Lista, em ordem, os nomes dos planetas com distancia entre min e max.
    // So vale o bonus se NAO visitar subarvores que nao podem ter resposta.
    // Formato: Alcance [33, 66]: Lumi Nimbus Bolha Kepleria Verdana
    public void listarIntervalo(int min, int max) {
        System.out.print("Alcance [" + min + ", " + max + "]: ");
        listarIntervaloRec(raiz,min,max);
        System.out.println();
    }
    private void listarIntervaloRec(No no, int min, int max){
        if (no == null){
            return;
        }

        //1.Pode da esquerda
        if(no.distancia > min){
            listarIntervaloRec(no.esquerda, min, max);
        }
        //2.processa no atual se estiver no intervalo de min max
        if(no.distancia >= min && no.distancia <= max){
            System.out.print(no.nome + " ");
        }
        //3.poda da direita
        if(no.distancia < max){
            listarIntervaloRec(no.direita,min,max);
        }
    }

    // ================= Não altere daqui para baixo =================
    public static CatalogoPlanetas montarCatalogo() {
        CatalogoPlanetas c = new CatalogoPlanetas();
        c.catalogar(50, "Kepleria", "rochoso", true);
        c.catalogar(30, "Zuno", "gasoso", false);
        c.catalogar(75, "Glacius", "gelado", false);
        c.catalogar(15, "Rubi-9", "rochoso", false);
        c.catalogar(40, "Nimbus", "gasoso", false);
        c.catalogar(60, "Oasis", "rochoso", true);
        c.catalogar(90, "Vortex", "gasoso", false);
        c.catalogar(10, "Pipoca", "rochoso", false);
        c.catalogar(20, "Cristalina", "gelado", false);
        c.catalogar(35, "Lumi", "rochoso", true);
        c.catalogar(45, "Bolha", "gasoso", false);
        c.catalogar(65, "Verdana", "rochoso", true);
        c.catalogar(85, "Neve-7", "gelado", false);
        c.catalogar(95, "Tita", "gasoso", false);
        return c;
    }

    public static void main(String[] args) {
        CatalogoPlanetas c = montarCatalogo();
        c.catalogar(40, "Impostor", "gasoso", false);   // duplicado
        c.listarEmOrdem();
        System.out.println("Planetas: " + c.getQuantidade() + " | Altura: " + c.altura()
                + " | Habitaveis: " + c.contarHabitaveis());
        System.out.println("Mais proximo: " + c.maisProximo() + " | Mais distante: " + c.maisDistante());

        c.localizar(45);
        c.localizar(55);

        c.descatalogarPelosMenores(10);   // folha
        c.descatalogarPelosMenores(60);   // um filho
        c.descatalogarPelosMenores(30);   // dois filhos
        c.descatalogarPelosMaiores(75);   // dois filhos
        c.listarEmOrdem();
        System.out.println("Planetas: " + c.getQuantidade() + " | Altura: " + c.altura()
                + " | Habitaveis: " + c.contarHabitaveis());

        c.listarIntervalo(33, 66);
    }
}
