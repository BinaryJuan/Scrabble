package ar.scrabble.unlu;
enum Color {
    NORMAL,
    AZULC,
    AZUL,
    ROSA,
    ROJO
}

public class Casilla {
    private Ficha ficha;
    private Color color;
    private Integer coordenadaX;
    private Integer coordenadaY;
    public Casilla(Integer coordenadaX, Integer coordenadaY, Color color) {
        this.ficha = null;
        this.color = color;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
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
        switch (this.color) {
            case NORMAL:
                return "\u001B[0m";
            case AZULC:
                return "\u001B[36m";
            case AZUL:
                return "\u001B[34m";
            case ROSA:
                return "\u001B[35m";
            case ROJO:
                return "\u001B[31m";
            default:
                return "\u001B[0m";
        }
    }

    public String devolverCasillaConValorYLetra() {
        if (this.estaVacia()) {
            return this.colorConsola() + " [ ] ";
        } else {
            return this.colorConsola() + " [" + this.ficha.getLetraSimbolo() + this.ficha.getValor() + "]";
        }
    }
}
