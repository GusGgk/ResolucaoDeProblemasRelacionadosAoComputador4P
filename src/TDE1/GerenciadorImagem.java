package TDE1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GerenciadorImagem {

    // Arquivo usado como referência para descobrir a pasta do projeto
    private static final String ARQUIVO_REFERENCIA = "imagem.png";

    private static File pastaBase;

    /*
     * Descobre a pasta onde estão a imagem e as saídas do programa.
     * Sem isso, os caminhos relativos ("imagem.png", "frames_pilha/...") mudam
     * conforme a pasta em que a IDE executa o programa e os frames acabam
     * espalhados em lugares diferentes.
     */
    public static File getPastaBase() {
        if (pastaBase == null) {
            pastaBase = descobrirPastaBase();
            System.out.println("Pasta de trabalho: " + pastaBase.getAbsolutePath());
        }
        return pastaBase;
    }

    private static File descobrirPastaBase() {
        File atual = new File(System.getProperty("user.dir")).getAbsoluteFile();
        for (int nivel = 0; atual != null && nivel < 5; nivel++) {
            if (new File(atual, ARQUIVO_REFERENCIA).isFile()) {
                return atual;
            }
            File pastaFonte = new File(atual, "src" + File.separator + "TDE1");
            if (new File(pastaFonte, ARQUIVO_REFERENCIA).isFile()) {
                return pastaFonte;
            }
            atual = atual.getParentFile();
        }
        return new File(System.getProperty("user.dir")).getAbsoluteFile();
    }

    // Transforma um caminho relativo em um arquivo dentro da pasta base
    public static File resolver(String caminho) {
        File arquivo = new File(caminho);
        return arquivo.isAbsolute() ? arquivo : new File(getPastaBase(), caminho);
    }

    /*
     * Apaga os PNGs de uma pasta de frames antes de uma nova execução.
     * Sem essa limpeza, os frames da execução anterior continuam no disco e
     * se misturam com os novos, quebrando a ordem da animação.
     */
    public static void limparPasta(String caminhoPasta) {
        File pasta = resolver(caminhoPasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
            return;
        }
        File[] arquivos = pasta.listFiles((dir, nome) -> nome.toLowerCase().endsWith(".png"));
        if (arquivos == null) {
            return;
        }
        int apagados = 0;
        for (File arquivo : arquivos) {
            if (arquivo.delete()) {
                apagados++;
            }
        }
        System.out.println("Frames antigos removidos de " + caminhoPasta + ": " + apagados);
    }

    //imagem carregada
    public static BufferedImage carregarImagem(String caminho) {
        File arquivo = resolver(caminho);
        if (!arquivo.isFile()) {
            System.err.println("Imagem não encontrada: " + arquivo.getAbsolutePath());
            return null;
        }
        try {
            BufferedImage original = ImageIO.read(arquivo);
            if (original == null) {
                System.err.println("Formato de imagem não suportado: " + arquivo.getAbsolutePath());
                return null;
            }
            // Converte para TYPE_INT_RGB: garante que setRGB grave exatamente a cor
            // pedida (imagens com paleta indexada alteram a cor e o flood fill nunca terminaria)
            return converterParaRGB(original);
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
            return null;
        }
    }

    public static BufferedImage converterParaRGB(BufferedImage imagem) {
        if (imagem.getType() == BufferedImage.TYPE_INT_RGB) {
            return imagem;
        }
        BufferedImage copia = new BufferedImage(
                imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = copia.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, copia.getWidth(), copia.getHeight());
        graphics.drawImage(imagem, 0, 0, null);
        graphics.dispose();
        return copia;
    }

    //salva o buffered resultado final ou frame
    public static void salvarImagem(BufferedImage imagem, String caminhoSaida) {
        try {
            File arquivoSaida = resolver(caminhoSaida);
            if (arquivoSaida.getParentFile() != null) {
                arquivoSaida.getParentFile().mkdirs();
            }
            ImageIO.write(imagem, "png", arquivoSaida);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    // obter cor de um pixel especifico
    public static int getCorPixel(BufferedImage imagem, int x, int y) {
        return imagem.getRGB(x, y);
    }

    // altera a cor do pixel
    public static void setCorPixel(BufferedImage imagem, int x, int y, int novaCorRGB) {
        imagem.setRGB(x, y, novaCorRGB);
    }

    public static BufferedImage redimensionarImagem(BufferedImage imagem, int maiorDimensao) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        int maiorAtual = Math.max(largura, altura);

        if (maiorAtual <= maiorDimensao) {
            return converterParaRGB(imagem);
        }

        double escala = (double) maiorDimensao / maiorAtual;
        int novaLargura = (int) Math.round(largura * escala);
        int novaAltura = (int) Math.round(altura * escala);

        BufferedImage imagemRedimensionada = new BufferedImage(
                novaLargura, novaAltura, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = imagemRedimensionada.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(imagem, 0, 0, novaLargura, novaAltura, null);
        graphics.dispose();
        return imagemRedimensionada;
    }

    // metodo para converter rgb
    public static int criarCorRGB(int r, int g, int b) {
        Color cor = new Color(r, g, b);
        return cor.getRGB();
    }
}
