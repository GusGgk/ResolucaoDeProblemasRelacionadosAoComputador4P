package ListadeExercicios.listaDuplamenteEncadeada16;

public class NoDuplo16 {
    Animal animal;
    NoDuplo16 proximo;
    NoDuplo16 anterior;

    public NoDuplo16(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
