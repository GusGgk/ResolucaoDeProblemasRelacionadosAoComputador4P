package ListadeExercicios.listaDuplamenteEncadeada21;


public class NoDuplo21 {
    Animal animal;
    NoDuplo21 proximo;
    NoDuplo21 anterior;

    public NoDuplo21(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
