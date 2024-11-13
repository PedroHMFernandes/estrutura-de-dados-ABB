package entities;

import java.util.Objects;

public class Letra {
    private Character letra;
    private int ocorrencias;

    public Letra(char letra) {
        this.letra = letra;
        this.ocorrencias = 1;
    }

    public char getLetra() {
        return letra;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void increaseOcorrencias() {
        this.ocorrencias += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letra letra1 = (Letra) o;
        return Objects.equals(letra, letra1.letra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(letra);
    }

    @Override
    public String toString() {
        return "Letra: " + letra;
    }
}
