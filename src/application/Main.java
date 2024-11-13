package application;

import entities.ABB;
import entities.Letra;
import entities.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ABB arvore = new ABB();
        Scanner sc = new Scanner(System.in);
        String texto = null;
        int op = -1;

        while (op != 6) {
            UI.printMenu();
            op = UI.readOption(sc);
            switch (op) {
                case 1:
                    System.out.print("\nEntre com o path do arquivo: ");
                    sc.nextLine();
                    String path = sc.nextLine();
                    texto = processarTexto(lerArquivo(path));
                    arvore = povoarABB(texto, new ABB());
                    System.out.println("Texto carregado com sucesso.");
                    break;
                case 2:
                    int totalLetras = contarLetras(texto);
                    int totalPalavras = contarPalavras(texto);
                    System.out.println("\nTotal Letras: " + totalLetras);
                    System.out.println("Total Palavras: " + totalPalavras);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\nEntre com a letra: ");
                    sc.nextLine();
                    char letraProcurada = sc.nextLine().toUpperCase().charAt(0);
                    Node letra = arvore.busca(new Node(new Letra(letraProcurada)));
                    int ocorrencias = letra == null ? 0 : letra.getElemento().getOcorrencias();
                    System.out.printf("A letra %c tem %d ocorrências no texto.\n", letraProcurada, ocorrencias);
                    System.out.println();
                    break;
                case 4:
                    arvore.executaInOrdem(arvore.root(), contarLetras(texto));
                    break;
                case 5:
                    List<Letra> letras = new ArrayList<Letra>();
                    arvore.coletarOcorrencias(arvore.root(), letras);
                    letras.sort((l1, l2) -> Integer.compare(l2.getOcorrencias(), l1.getOcorrencias()));
                    System.out.println(retornarIdioma(letras));
            }
        }
        System.out.println("Programa finalizado.");
    }

    private static String lerArquivo(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return sb.toString();
    }

    private static String processarTexto(String texto) {
        return texto.replaceAll("[^\\w\\s]", "").toUpperCase();
    }

    private static ABB povoarABB(String texto, ABB arvore) {
        char letra;
        for (int i = 0; i < texto.length(); i++) {
            letra = texto.charAt(i);
            if (Character.isLetter(letra)) {
                Node atual = arvore.busca(new Node(new Letra(letra)));
                if (atual == null) {
                    arvore.insere(new Node(new Letra(letra)));
                } else {
                    atual.getElemento().increaseOcorrencias();
                }
            }
        }
        return arvore;
    }

    private static int contarLetras(String texto) {
        int count = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    private static int contarPalavras(String texto) {
        String[] palavras = texto.split(" ");
        return palavras.length;
    }

    private static String retornarIdioma(List<Letra> letras) {
        char l1 = letras.get(0).getLetra();
        char l2 = letras.get(1).getLetra();
        char l3 = letras.get(2).getLetra();
        char l4 = letras.get(3).getLetra();

        int ingles = 0;
        int portugues = 0;
        int frances = 0;

        if (l1 == 'A' && l2 == 'E' && l3 == 'O' && l4 == 'S') return "Português";
        if (l1 == 'E' && l2 == 'T' && l3 == 'A' && l4 == 'O') return "Inglês";
        if (l1 == 'E' && l2 == 'A' && l3 == 'S' && l4 == 'N') return "Francês";

        for (int i = 0; i < 10; i++) {
            char l = letras.get(i).getLetra();
            if (l == 'A' || l == 'E' || l == 'O' || l == 'S' || l == 'R' ||
                    l == 'I' || l == 'N' || l == 'D' || l == 'M' || l == 'U') portugues += (10 - i);

            if (l == 'E' || l == 'T' || l == 'A' || l == 'O' || l == 'I' ||
                    l == 'N' || l == 'S' || l == 'H' || l == 'R' || l == 'D') ingles += (10 - i);

            if (l == 'E' || l == 'A' || l == 'S' || l == 'N' || l == 'T' ||
                    l == 'I' || l == 'R' || l == 'U' || l == 'L' || l == 'O') frances += (10 - i);

        }
        if (portugues > ingles && portugues > frances) {
            return "Português";
        } else if (ingles > frances) {
            return "Inglês";
        } else if (frances > 0) {
            return "Francês";
        } else {
            return "Resultado inconclusivo.";
        }
    }
}


