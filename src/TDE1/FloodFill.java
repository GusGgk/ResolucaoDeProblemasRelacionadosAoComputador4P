package TDE1;

import TDE1.Fila.Fila;
import TDE1.Fila.NoFila;
import TDE1.Pilha.NoPilha;
import TDE1.Pilha.Pilha;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloodFill {

    /*
     * A cada quantos pixels pintados um frame da animação é gravado.
     * Ajuste conforme o tamanho da região, para a animação ter ~35 frames:
     *   metade da estrela (~24.750 px) -> 700
     *   estrela inteira   (~53.550 px) -> 1.500
     *   área de fora      (~170.550 px) -> 5.000
     */
    private static final int INTERVALO_FRAME = 700;

    public static final String PASTA_FRAMES_PILHA = "frames_pilha";
    public static final String PASTA_FRAMES_FILA = "frames_fila";

    // Método auxiliar para detectar se o pixel pertence à linha escura (borda)
    public static boolean isPixelEscuro(int rgb) {
        Color c = new Color(rgb);
        int media = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
        return media < 120; // Pixels escuros são considerados bordas
    }

    /*
     * Diz se o pixel (x, y) ainda pode entrar na pilha/fila: precisa estar dentro
     * da imagem, não ter sido marcado antes, não ser borda e não estar pintado.
     * A marcação é feita na inserção, então cada pixel entra na estrutura uma
     * única vez (sem isso a pilha chegava a milhões de nós repetidos).
     */
    private static boolean podeVisitar(BufferedImage imagem, boolean[][] visitado, int novaCor, int x, int y) {
        if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
            return false;
        }
        if (visitado[x][y]) {
            return false;
        }
        int cor = GerenciadorImagem.getCorPixel(imagem, x, y);
        return cor != novaCor && !isPixelEscuro(cor);
    }

    private static void salvarFrame(BufferedImage imagem, String pasta, int numero) {
        // Numeração com zeros à esquerda (frame_007) para os arquivos ficarem
        // em ordem correta ao montar o GIF; "frame_10" vinha antes de "frame_2"
        GerenciadorImagem.salvarImagem(imagem, pasta + "/" + String.format("frame_%03d.png", numero));
    }

    // =========================================================================
    // 1. IMPLEMENTAÇÃO COM PILHA
    // =========================================================================
    public static void preencherComPilha(BufferedImage imagem, int xInicial, int yInicial, int novaCor) {
        // Apaga os frames da execução anterior antes de gerar os novos
        GerenciadorImagem.limparPasta(PASTA_FRAMES_PILHA);

        boolean[][] visitado = new boolean[imagem.getWidth()][imagem.getHeight()];

        if (!podeVisitar(imagem, visitado, novaCor, xInicial, yInicial)) {
            System.out.println("Pilha: ponto inicial inválido (borda, fora da imagem ou já pintado).");
            return;
        }

        Pilha pilha = new Pilha();
        pilha.push(new Pixel(xInicial, yInicial));
        visitado[xInicial][yInicial] = true;

        int contadorPixels = 0;
        int frame = 0;

        while (!pilha.isEmpty()) {
            NoPilha noAtual = pilha.pop();
            Pixel p = noAtual.pixel;

            // Pinta o pixel
            GerenciadorImagem.setCorPixel(imagem, p.x, p.y, novaCor);
            contadorPixels++;

            // Salva o frame da animação a cada INTERVALO_FRAME pixels
            if (contadorPixels % INTERVALO_FRAME == 0) {
                salvarFrame(imagem, PASTA_FRAMES_PILHA, frame);
                frame++;
            }

            // Empilha os 4 vizinhos que ainda podem ser pintados
            empilharVizinho(pilha, visitado, imagem, novaCor, p.x + 1, p.y);
            empilharVizinho(pilha, visitado, imagem, novaCor, p.x - 1, p.y);
            empilharVizinho(pilha, visitado, imagem, novaCor, p.x, p.y + 1);
            empilharVizinho(pilha, visitado, imagem, novaCor, p.x, p.y - 1);
        }

        // Último frame com a imagem já completa, para o GIF terminar no resultado
        salvarFrame(imagem, PASTA_FRAMES_PILHA, frame);

        // Salva a imagem final fora do loop
        GerenciadorImagem.salvarImagem(imagem, "resultado_pilha.png");
        System.out.println("Concluído com Pilha! Pixels pintados: " + contadorPixels
                + " | Frames gerados: " + (frame + 1));
    }

    private static void empilharVizinho(Pilha pilha, boolean[][] visitado, BufferedImage imagem,
                                        int novaCor, int x, int y) {
        if (podeVisitar(imagem, visitado, novaCor, x, y)) {
            visitado[x][y] = true;
            pilha.push(new Pixel(x, y));
        }
    }

    // =========================================================================
    // 2. IMPLEMENTAÇÃO COM FILA
    // =========================================================================
    public static void preencherComFila(BufferedImage imagem, int xInicial, int yInicial, int novaCor) {
        // Apaga os frames da execução anterior antes de gerar os novos
        GerenciadorImagem.limparPasta(PASTA_FRAMES_FILA);

        boolean[][] visitado = new boolean[imagem.getWidth()][imagem.getHeight()];

        if (!podeVisitar(imagem, visitado, novaCor, xInicial, yInicial)) {
            System.out.println("Fila: ponto inicial inválido (borda, fora da imagem ou já pintado).");
            return;
        }

        Fila fila = new Fila();
        fila.enqueue(new Pixel(xInicial, yInicial));
        visitado[xInicial][yInicial] = true;

        int contadorPixels = 0;
        int frame = 0;

        while (!fila.isEmpty()) {
            NoFila noAtual = fila.dequeue();
            Pixel p = noAtual.pixel;

            // Pinta o pixel
            GerenciadorImagem.setCorPixel(imagem, p.x, p.y, novaCor);
            contadorPixels++;

            // Salva o frame da animação a cada INTERVALO_FRAME pixels
            if (contadorPixels % INTERVALO_FRAME == 0) {
                salvarFrame(imagem, PASTA_FRAMES_FILA, frame);
                frame++;
            }

            // Enfileira os 4 vizinhos que ainda podem ser pintados
            enfileirarVizinho(fila, visitado, imagem, novaCor, p.x + 1, p.y);
            enfileirarVizinho(fila, visitado, imagem, novaCor, p.x - 1, p.y);
            enfileirarVizinho(fila, visitado, imagem, novaCor, p.x, p.y + 1);
            enfileirarVizinho(fila, visitado, imagem, novaCor, p.x, p.y - 1);
        }

        // Último frame com a imagem já completa, para o GIF terminar no resultado
        salvarFrame(imagem, PASTA_FRAMES_FILA, frame);

        // Salva a imagem final fora do loop
        GerenciadorImagem.salvarImagem(imagem, "resultado_fila.png");
        System.out.println("Concluído com Fila! Pixels pintados: " + contadorPixels
                + " | Frames gerados: " + (frame + 1));
    }

    private static void enfileirarVizinho(Fila fila, boolean[][] visitado, BufferedImage imagem,
                                          int novaCor, int x, int y) {
        if (podeVisitar(imagem, visitado, novaCor, x, y)) {
            visitado[x][y] = true;
            fila.enqueue(new Pixel(x, y));
        }
    }
}
