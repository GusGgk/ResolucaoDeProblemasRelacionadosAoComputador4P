package ListadeExercicios.listaDuplamenteEncadeada17;

public class NoDuplo17 {
    Animal animal;
    NoDuplo17 proximo;
    NoDuplo17 anterior;

    public NoDuplo17(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
