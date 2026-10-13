package RA1.TDE1.Pilha;

import RA1.TDE1.Pixel;

public class NoPilha {
    public Pixel pixel;
    public NoPilha proximo;

    public NoPilha(Pixel pixel) {
        this.pixel = pixel;
        this.proximo = null;
    }
}
