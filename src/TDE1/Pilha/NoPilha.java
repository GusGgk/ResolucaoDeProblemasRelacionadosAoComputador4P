package TDE1.Pilha;

import TDE1.Pixel;

public class NoPilha {
    public Pixel pixel;
    public NoPilha proximo;

    public NoPilha(Pixel pixel) {
        this.pixel = pixel;
        this.proximo = null;
    }
}
