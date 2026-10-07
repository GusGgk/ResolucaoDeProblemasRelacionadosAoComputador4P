package TDE1;

import java.awt.image.BufferedImage;

public class Main {

    private static final String IMAGEM = "imagem.png";
    private static final int MAIOR_DIMENSAO = 500;
    // Ponto inicial dentro da METADE DIREITA da estrela: o corte vertical
    // impede a tinta de passar para a metade esquerda.
    // Outras opções: (187, 247) = metade esquerda | (10, 10) = área de fora
    private static final int X_INICIAL = 292;
    private static final int Y_INICIAL = 247;

    public static void main(String[] args) {
        int corVermelha = GerenciadorImagem.criarCorRGB(255, 0, 0);

        // ----- Preenchimento com PILHA -----
        BufferedImage imgPilha = GerenciadorImagem.carregarImagem(IMAGEM);
        if (imgPilha == null) {
            System.err.println("Execução interrompida: a imagem não pôde ser carregada.");
            return;
        }
        imgPilha = GerenciadorImagem.redimensionarImagem(imgPilha, MAIOR_DIMENSAO);
        FloodFill.preencherComPilha(imgPilha, X_INICIAL, Y_INICIAL, corVermelha);
        GifAnimacao.criarGif(FloodFill.PASTA_FRAMES_PILHA, "animacao_pilha.gif");

        // ----- Preenchimento com FILA -----
        BufferedImage imgFila = GerenciadorImagem.carregarImagem(IMAGEM);
        if (imgFila == null) {
            System.err.println("Execução interrompida: a imagem não pôde ser carregada.");
            return;
        }
        imgFila = GerenciadorImagem.redimensionarImagem(imgFila, MAIOR_DIMENSAO);
        FloodFill.preencherComFila(imgFila, X_INICIAL, Y_INICIAL, corVermelha);
        GifAnimacao.criarGif(FloodFill.PASTA_FRAMES_FILA, "animacao_fila.gif");
    }
}
