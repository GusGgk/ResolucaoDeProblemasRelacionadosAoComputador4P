package TDE1;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Monta um GIF animado a partir dos frames gravados pelo flood fill,
 * indo do primeiro frame até a imagem completamente preenchida.
 * Usa apenas a API padrão do Java (ImageIO), sem bibliotecas externas.
 */
public class GifAnimacao {

    // Tempos em centésimos de segundo (unidade usada pelo formato GIF)
    private static final int ATRASO_PADRAO = 12;   // ~0,12s por frame
    private static final int ATRASO_ULTIMO = 250;  // 2,5s parado no resultado final

    public static void criarGif(String pastaFrames, String nomeGif) {
        File pasta = GerenciadorImagem.resolver(pastaFrames);
        File[] frames = pasta.listFiles((dir, nome) ->
                nome.startsWith("frame_") && nome.toLowerCase().endsWith(".png"));

        if (frames == null || frames.length == 0) {
            System.err.println("Nenhum frame encontrado em " + pasta.getAbsolutePath());
            return;
        }
        // Os nomes têm zeros à esquerda, então a ordem alfabética é a ordem da animação
        Arrays.sort(frames);

        File arquivoGif = GerenciadorImagem.resolver(nomeGif);
        // Apaga o GIF anterior: createImageOutputStream abre o arquivo sem truncar,
        // então uma animação mais curta deixaria o final do arquivo antigo grudado no novo
        if (arquivoGif.exists() && !arquivoGif.delete()) {
            System.err.println("Não foi possível apagar o GIF anterior: " + arquivoGif.getAbsolutePath());
            return;
        }

        Iterator<ImageWriter> escritores = ImageIO.getImageWritersByFormatName("gif");
        if (!escritores.hasNext()) {
            System.err.println("Nenhum gravador de GIF disponível nesta JVM.");
            return;
        }
        ImageWriter escritor = escritores.next();

        try (ImageOutputStream saida = ImageIO.createImageOutputStream(arquivoGif)) {
            escritor.setOutput(saida);
            ImageWriteParam parametros = escritor.getDefaultWriteParam();
            escritor.prepareWriteSequence(null);

            for (int i = 0; i < frames.length; i++) {
                BufferedImage imagem = ImageIO.read(frames[i]);
                if (imagem == null) {
                    System.err.println("Frame ignorado (não foi possível ler): " + frames[i].getName());
                    continue;
                }
                imagem = GerenciadorImagem.converterParaRGB(imagem);

                boolean ultimo = (i == frames.length - 1);
                IIOMetadata metadados = criarMetadados(escritor, parametros, imagem,
                        ultimo ? ATRASO_ULTIMO : ATRASO_PADRAO, i == 0);

                escritor.writeToSequence(new IIOImage(imagem, null, metadados), parametros);
            }

            escritor.endWriteSequence();
            System.out.println("GIF gerado: " + arquivoGif.getAbsolutePath()
                    + " (" + frames.length + " frames)");
        } catch (IOException e) {
            System.err.println("Erro ao gerar o GIF: " + e.getMessage());
        } finally {
            escritor.dispose();
        }
    }

    private static IIOMetadata criarMetadados(ImageWriter escritor, ImageWriteParam parametros,
                                              BufferedImage imagem, int atraso, boolean primeiroFrame)
            throws IOException {
        ImageTypeSpecifier tipo = ImageTypeSpecifier.createFromRenderedImage(imagem);
        IIOMetadata metadados = escritor.getDefaultImageMetadata(tipo, parametros);
        String formato = metadados.getNativeMetadataFormatName();
        IIOMetadataNode raiz = (IIOMetadataNode) metadados.getAsTree(formato);

        IIOMetadataNode controle = obterNo(raiz, "GraphicControlExtension");
        controle.setAttribute("disposalMethod", "none");
        controle.setAttribute("userInputFlag", "FALSE");
        controle.setAttribute("transparentColorFlag", "FALSE");
        controle.setAttribute("transparentColorIndex", "0");
        controle.setAttribute("delayTime", String.valueOf(atraso));

        if (primeiroFrame) {
            // Bloco NETSCAPE: faz a animação repetir para sempre
            IIOMetadataNode extensoes = obterNo(raiz, "ApplicationExtensions");
            IIOMetadataNode netscape = new IIOMetadataNode("ApplicationExtension");
            netscape.setAttribute("applicationID", "NETSCAPE");
            netscape.setAttribute("authenticationCode", "2.0");
            netscape.setUserObject(new byte[]{0x1, 0x0, 0x0}); // 0 repetições = infinito
            extensoes.appendChild(netscape);
        }

        metadados.setFromTree(formato, raiz);
        return metadados;
    }

    // Procura um nó de metadados pelo nome; se não existir, cria e anexa
    private static IIOMetadataNode obterNo(IIOMetadataNode raiz, String nome) {
        for (int i = 0; i < raiz.getLength(); i++) {
            if (raiz.item(i).getNodeName().equalsIgnoreCase(nome)) {
                return (IIOMetadataNode) raiz.item(i);
            }
        }
        IIOMetadataNode novo = new IIOMetadataNode(nome);
        raiz.appendChild(novo);
        return novo;
    }
}
