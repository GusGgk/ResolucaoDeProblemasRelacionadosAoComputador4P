package ExerciciosAMaisListaEncadeada.CantinhoSeguro;

import java.sql.SQLOutput;

public class Main {
    static void main(String[] args) {
        ListaAbrigo lista = new ListaAbrigo();

        lista.cadastrar(new Animal("Thor","Cachorro"));
        lista.cadastrar(new Animal("Mia","Gato"));
        lista.cadastrar(new Animal("Piu-Piu","Passarinho"));

        System.out.println("Existe Thor? " + lista.existeAnimal("Thor"));

        System.out.println("Existe Rex? " + lista.existeAnimal("Rex"));


    }
}
