package ar.edu.unlu.poo.scrabble.model;
enum Color {
    NORMAL,
    AZULC,
    AZUL,
    ROSA,
    ROJO
}

public class Casilla {
    protected Ficha ficha;
    protected Color color;
    protected Integer coordenadaX;
    protected Integer coordenadaY;
    public Casilla(Integer coordenadaX, Integer coordenadaY) {
        this.ficha = null;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.color = Color.NORMAL;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public Color getColor() {
        return color;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Boolean estaVacia() {
        return this.ficha == null;
    }

    public String colorConsola() {
        return "\u001B[0m";
    }

    public String devolverCasillaConValorYLetra() {
        if (this.estaVacia()) {
            return this.colorConsola() + " [ ] ";
        } else {
            return this.colorConsola() + " [" + this.ficha.getLetraSimbolo() + this.ficha.getValor() + "]";
        }
    }
}
