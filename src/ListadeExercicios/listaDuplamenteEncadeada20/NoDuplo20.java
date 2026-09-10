package ListadeExercicios.listaDuplamenteEncadeada20;

public class NoDuplo20 {
    Animal animal;
    NoDuplo20 proximo;
    NoDuplo20 anterior;

    public NoDuplo20(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
