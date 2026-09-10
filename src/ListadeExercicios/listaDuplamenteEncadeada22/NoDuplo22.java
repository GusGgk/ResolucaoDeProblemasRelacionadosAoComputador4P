package ListadeExercicios.listaDuplamenteEncadeada22;

public class NoDuplo22 {
    Animal animal;
    NoDuplo22 proximo;
    NoDuplo22 anterior;

    public NoDuplo22(Animal animal) {
        this.animal = animal;
        this.proximo = null;
        this.anterior = null;
    }
}
