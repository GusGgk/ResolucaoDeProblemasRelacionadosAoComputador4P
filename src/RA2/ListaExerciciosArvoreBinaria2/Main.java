package RA2.ListaExerciciosArvoreBinaria2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArvoreBinariaBusca a = new ArvoreBinariaBusca();
        Scanner sc = new Scanner(System.in);

        System.out.println("BEM VINDO A ACADEMIA CIBERNÉTICA");
        System.out.println("Selecione uma das opções do menu:");
        int resposta = 0;
        while(resposta != 5){
            System.out.println("1. Cadastrar lutador (insirir seu poder de luta);");
            System.out.println("1. Expulsar lutador (remover seu poder de luta);");
            System.out.println("3. Investigar lutador ( buscar seu poder de luta);");
            System.out.println("4. Exibir ranking (ordem crescente de força);");
            System.out.println("5. Desligar Academia);");
            resposta = sc.nextInt();
            System.out.println();

            if (resposta == 1){
                System.out.println("Qual o poder de luta desse lutador?");
                int aux = sc.nextInt();
                a.inserir(aux);
                System.out.println("[+] Lutador de nível " + aux + " cadastrado");
                a.exibirEmOrdem();
            }
            if (resposta == 2){
                System.out.println("Qual o poder de luta  que você deseja remover?");
                int aux = sc.nextInt();
                a.remover(aux);
                System.out.println("[-] Lutador de nível " + aux + " expulso");
                a.exibirEmOrdem();
            }
            if(resposta == 3){
                System.out.println("Qual poder de luta você deseja investigar?");
                int aux = sc.nextInt();
                System.out.println("O lutador " +aux + " na nossa base de busca foi:");
                a.buscar(aux);
            }
            if(resposta == 4){
                System.out.println("NOSSO RANKING (ordem crescente)");
                a.exibirEmOrdem();
            }
            if(resposta == 5){
                System.out.println("Desligando...");
            }
        }

    }
}
