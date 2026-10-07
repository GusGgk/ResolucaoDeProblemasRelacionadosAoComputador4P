package TDE1.Fila;

import TDE1.Pixel;

public class NoFila {
   public Pixel pixel;
   public NoFila proximo;

    public NoFila(Pixel pixel) {
        this.pixel = pixel;
        this.proximo = null;
    }
}
