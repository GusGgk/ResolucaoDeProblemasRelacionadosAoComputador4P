package ListaExerciciosArvoreBinaria;

import java.util.Scanner;

public class Main24 {
    static void main(String[] args) {
        ArvoreBinariaBusca binaria = new ArvoreBinariaBusca();
        Scanner sc = new Scanner(System.in);
        int resposta = 0;

        System.out.println("!!!!SIMULADOR DE RANKING DE JOGADORES!!!!");
        System.out.println("Escolha uma das opções do menu abaixo:");

        while(resposta != 5){
            System.out.println("1 - Inserir Jogador:");
            System.out.println("2 - Remover Jogador:");
            System.out.println("3 - Buscar jogador:");
            System.out.println("4 - Exibir ranking completo");
            System.out.println("5 - Sair");
            resposta = sc.nextInt();
            if (resposta == 1){
                System.out.println("Qual o ranking do seu jogador?");
                int resp1 = sc.nextInt();
                binaria.inserir(resp1);
                System.out.println("Jogador " + resp1 + " inserido com sucesso");
            }
            if (resposta == 2){
                System.out.println("Qual o ranking do seu jogador?");
                int resp1 = sc.nextInt();
                binaria.remover(resp1);
                System.out.println("Jogador " + resp1 + " removido com sucesso");
            }
            if (resposta == 3){
                System.out.println("Qual o ranking do seu jogador?");
                int resp1 = sc.nextInt();
                binaria.buscar(resp1);
                System.out.println("Jogador " + resp1 + " buscado com sucesso");
            }
            if (resposta == 4){
                binaria.exibirEmOrdem();
            }
            if (resposta == 5){
                System.out.println("Encerrando! tchau tchau");
            }
        }
    }
}
