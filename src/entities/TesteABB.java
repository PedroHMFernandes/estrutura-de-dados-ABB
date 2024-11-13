package entities;

public class TesteABB {
    public static void main(String[] args) {
        // Cria uma nova árvore binária
        ABB arvore = new ABB();

        // Insere nós na árvore
        System.out.println("Inserindo elementos...");
        arvore.insere(new Node(new Letra('F')));
        arvore.insere(new Node(new Letra('B')));
        arvore.insere(new Node(new Letra('G')));
        arvore.insere(new Node(new Letra('A')));
        arvore.insere(new Node(new Letra('D')));
        arvore.insere(new Node(new Letra('I')));
        arvore.insere(new Node(new Letra('C')));
        arvore.insere(new Node(new Letra('E')));
        arvore.insere(new Node(new Letra('H')));

        // Mostra a árvore em diferentes ordens
        System.out.print("Pré-Ordem: ");
        arvore.executaPreOrdem(arvore.root());
        System.out.println();

        System.out.print("Em Ordem: ");
        arvore.executaInOrdem(arvore.root());
        System.out.println();

        System.out.print("Pós-Ordem: ");
        arvore.executaPosOrdem(arvore.root());
        System.out.println();

        // Teste de busca
        System.out.println("\nBuscando nó com valor 'D':");
        Node encontrado = arvore.busca(new Node(new Letra('D')));
        if (encontrado != null) {
            System.out.println("Nó encontrado: " + encontrado.elemento);
        } else {
            System.out.println("Nó não encontrado.");
        }

        // Teste de exclusão de nós
        System.out.println("\nDeletando nó com valor 'B' (com dois filhos)...");
        arvore.delete(arvore.root(), new Letra('B'));
        System.out.print("Em Ordem após deletar 'B': ");
        arvore.executaInOrdem(arvore.root());
        System.out.println();

        System.out.println("Deletando nó com valor 'G' (com um filho)...");
        arvore.delete(arvore.root(), new Letra('G'));
        System.out.print("Em Ordem após deletar 'G': ");
        arvore.executaInOrdem(arvore.root());
        System.out.println();

        System.out.println("Deletando nó com valor 'A' (folha)...");
        arvore.delete(arvore.root(), new Letra('A'));
        System.out.print("Em Ordem após deletar 'A': ");
        arvore.executaInOrdem(arvore.root());
        System.out.println();
    }
}
