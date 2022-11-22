package ar.edu.unlu.poo.scrabble.model;

public class CasillaLetraTriple extends Casilla {
    private Color color;    

    public CasillaLetraTriple(Integer coordenadaX, Integer coordenadaY) {
        super(coordenadaY, coordenadaY);
        this.color = Color.AZUL;
    }

    public Color getColor() {
        return color;
    }

    public String colorConsola() {
        return "\u001B[34m";
    }
}
