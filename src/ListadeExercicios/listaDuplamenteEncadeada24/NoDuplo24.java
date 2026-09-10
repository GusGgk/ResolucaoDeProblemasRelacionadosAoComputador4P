package ListadeExercicios.listaDuplamenteEncadeada24;

public class NoDuplo24 {
    Animal animal;
    NoDuplo24 proximo;
    NoDuplo24 anterior;

    public NoDuplo24(Animal animal) {
        this.animal = animal;
        this.anterior = null;
        this.proximo = null;
    }
}
