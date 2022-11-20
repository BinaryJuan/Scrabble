package ar.scrabble.unlu;

public class Letra {
    private char letra;
    private Integer valor;

    public Letra(char c) {
        this.letra = c;
        this.valor = calcularValorLetra(c);
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer calcularValorLetra(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'B':
                return 3;
            case 'C':
                return 3;
            case 'D':
                return 2;
            case 'E':
                return 1;
            case 'F':
                return 4;
            case 'G':
                return 2;
            case 'H':
                return 4;
            case 'I':
                return 1;
            case 'J':
                return 8;
            case 'K':
                return 5;
            case 'L':
                return 1;
            case 'M':
                return 3;
            case 'N':
                return 1;
            case 'Ñ':
                return 8;
            case 'O':
                return 1;
            case 'P':
                return 3;
            case 'Q':
                return 5;
            case 'R':
                return 1;
            case 'S':
                return 1;
            case 'T':
                return 1;
            case 'U':
                return 1;
            case 'V':
                return 4;
            case 'W':
                return 10;
            case 'X':
                return 8;
            case 'Y':
                return 4;
            case 'Z':
                return 10;
            default:
                return 0;
        }
    }
}
