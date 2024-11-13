package entities;

import java.util.Objects;

public class Node {

    Letra elemento;  // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó

    public Node(Letra elemento) {
        this.elemento = elemento;
        left = right = parent = null;
    }

    public Letra getElemento() {
        return elemento;
    }

    public void setElemento(Letra elemento) {
        this.elemento = elemento;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(elemento, node.elemento);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(elemento);
    }

    public void mostraNo() {
        System.out.print(elemento + " ");
    }
}
