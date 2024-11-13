package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static int readOption(Scanner sc) {
        int op = -1;
        while (true) {
            try {
                op = sc.nextInt();
                if (op >= 1 && op <= 6) {
                    return op;
                }
                System.out.println("Opção inválida. Selecione um número entre 1 e 6.");
                printMenu();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.next(); // Limpa a entrada inválida
                printMenu();
            }
        }
    }

    public static void printMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1- Carregar o Texto");
        System.out.println("2- Contador de letras e palavras");
        System.out.println("3- Busca por letra");
        System.out.println("4- Frequência por letra");
        System.out.println("5- Identificar idioma");
        System.out.println("6- Encerrar");
        System.out.print("Entre com o número da opção: ");
    }
}
