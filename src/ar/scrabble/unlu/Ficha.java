package ar.scrabble.unlu;
public class Ficha {
    private char letra;
    private Integer valor;

    public Ficha(char c, Integer valor) {
        this.letra = c;
        this.valor = valor;
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

    public char generarLetraAleatoria() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = alphabet.length();
        int r = (int) (n * Math.random());
        return alphabet.charAt(r);
    }

    public Integer generarValorAleatorio() {
        int valor = (int) (Math.random() * 27);
        return valor;
    }

    public void cargarFicha() {
        this.setLetra(this.generarLetraAleatoria());
        this.setValor(this.generarValorAleatorio());
    }
}
