package ar.scrabble.unlu;

public class Ficha {
    private Letra letra;
    private Integer valor;

    public Ficha(char c) {
        this.letra = new Letra(c);
        this.valor = this.letra.getValor();
    }

    public Letra getLetra() {
        return letra;
    }

    public char getLetraSimbolo() {
        return letra.getLetra();
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer generarValorAleatorio() {
        int valor = (int) (Math.random() * 27);
        return valor;
    }
}
