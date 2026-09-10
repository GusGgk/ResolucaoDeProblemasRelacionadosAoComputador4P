package ListadeExercicios.listaDuplamenteEncadeada25;

public class NoDuplo25 {
    Animal animal;
    NoDuplo25 proximo;
    NoDuplo25 anterior;

    public NoDuplo25(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
