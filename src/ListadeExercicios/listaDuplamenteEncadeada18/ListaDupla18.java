package ListadeExercicios.listaDuplamenteEncadeada18;


public class ListaDupla18 {
    private NoDuplo18 inicio;
    private NoDuplo18 fim;
    private NoDuplo18 atendimentoAtual;

    public ListaDupla18() {
        this.inicio = null;
        this.fim = null;
        this.atendimentoAtual = null;
    }

    public void adicionarNoFim(Atendimento a){
        NoDuplo18 novoNo = new NoDuplo18(a);
        if(inicio == null){
            inicio = novoNo;
            fim = novoNo;
            return;
        }
        novoNo.anterior = fim;
        fim.proximo = novoNo;
        fim = novoNo;

    }

    public void iniciarAtendimento(){
        if(inicio == null){
            System.out.println("Fila de atendimento vazia!");
            return;
        }
        atendimentoAtual = inicio;
        System.out.println("Atendimento iniciado: " + atendimentoAtual.atendimento.getDescricao());
    }

    public void proximoAtendimento(){
        if(this.atendimentoAtual == null){
            if(inicio == null){
                this.atendimentoAtual = this.inicio;
                System.out.println("Atendendo agora: "  + atendimentoAtual.atendimento.getDescricao());
            }else{
                System.out.println("FIla vazia");
            }
            return;
        }
        if(this.atendimentoAtual.proximo != null){
            atendimentoAtual = atendimentoAtual.proximo; // avança para o proximo atendimento
            System.out.println("Avançou atendimento para: " + atendimentoAtual.atendimento.getDescricao());
        } else {
            System.out.println("Você já está no ÚLTIMO animal da fila (" + atendimentoAtual.atendimento.getDescricao());
        }
    }
    public void atendimentoAnterior(){
        if(atendimentoAtual == null){
            System.out.println("nenhum atendimento em andamento");
            return;
        }
        //se tinha animal antes
        if(atendimentoAtual.anterior != null){
            this.atendimentoAtual = atendimentoAtual.anterior; // volta para um nó anterior
            System.out.println("Voltou atendimento para: " + atendimentoAtual.atendimento.getDescricao());
        } else{
            System.out.println("Você já está no PRIMEIRO animal da fila (" + atendimentoAtual.atendimento.getDescricao());
        }
    }
}
