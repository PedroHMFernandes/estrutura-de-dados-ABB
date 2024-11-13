package entities;

import java.util.List;

public class ABB {

    private Node root; // raiz da árvore

    public ABB() {
        // Cria uma árvore binária vazia
        root = null;
    }

    public boolean isEmpty() {
        // Verifica se a árvore está vazia
        return root == null;
    }

    public Node root() {
        // Devolve a raiz da árvore.
        return root;
    }

    public boolean isLeaf(Node n) {
        // Verifica se um nó n é uma folha
        return n.left == null && n.right == null;
    }

    public void executaPreOrdem(Node no) {
        if (no == null) {
            return;
        }
        no.mostraNo();
        executaPreOrdem(no.left);
        executaPreOrdem(no.right);
    }

    public void executaInOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaInOrdem(no.left);
        no.mostraNo();
        executaInOrdem(no.right);
    }
    public void executaInOrdem(Node no, int totalLetras) {
        if (no == null) {
            return;
        }
        executaInOrdem(no.left, totalLetras);

        // Exibe a letra, as ocorrências e a porcentagem
        Letra letra = no.elemento;
        double frequencia = (letra.getOcorrencias() * 100.0) / totalLetras;
        System.out.printf("Letra: %c | Ocorrências: %d | Frequência: %.2f%%\n",
                letra.getLetra(), letra.getOcorrencias(), frequencia);
        executaInOrdem(no.right, totalLetras);
    }

    public void coletarOcorrencias(Node no, List<Letra> lista) {
        if (no == null) {
            return;
        }
        coletarOcorrencias(no.left, lista);
        Letra letra = no.elemento;
        lista.add(no.elemento);
        coletarOcorrencias(no.right, lista);
    }

    public void executaPosOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaPosOrdem(no.left);
        executaPosOrdem(no.right);
        no.mostraNo();
    }

    public void insere(Node z) {
        Node y = null;
        Node x = root();
        while (x != null) {
            y = x;
            if (z.elemento.getLetra() < x.elemento.getLetra()) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.elemento.getLetra() < y.elemento.getLetra()) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void delete(Node tree, Letra tar) {
        if (tree == null) {
            return;
        } else if (tar.getLetra() < tree.elemento.getLetra()) {
            delete(tree.left, tar);
        } else if (tar.getLetra() > tree.elemento.getLetra()) {
            delete(tree.right, tar);
        } else {
            // encontrou o nó a ser deletado
            if (tree.left != null && tree.right != null) {
                // nó com dois filhos
                Node min = minimo(tree.right);
                tree.elemento = min.elemento;
                delete(tree.right, min.elemento);
            } else {
                // Nó com um ou nenhum filho

                // Identifica o único filho (ou null se for folha)
                Node child = (tree.left != null) ? tree.left : tree.right;

                if (tree.parent == null) {
                    // Se o nó a ser deletado é a raiz
                    root = child; // Atualiza a raiz da árvore
                } else if (tree == tree.parent.left) {
                    // Se o nó a ser deletado é filho esquerdo de seu pai
                    tree.parent.left = child;
                } else {
                    // Se o nó a ser deletado é filho direito de seu pai
                    tree.parent.right = child;
                }

                if (child != null) {
                    child.parent = tree.parent; // Atualiza o ponteiro de parent do filho
                }
            }
        }
    }

    public Node busca(Node k) {
        Node y = root();
        while (y != null) {
            if (y.elemento.getLetra() == k.elemento.getLetra()) {
                return y;
            } else if (y.elemento.getLetra() < k.elemento.getLetra()) {
                y = y.right;
            } else {
                y = y.left;
            }
        }
        return null;
    }

    public Node maximo(Node x) {
        //Node<E> x = root();
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node minimo(Node n) {
        Node x = n;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

}
