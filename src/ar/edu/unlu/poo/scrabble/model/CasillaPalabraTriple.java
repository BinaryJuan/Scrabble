package ar.edu.unlu.poo.scrabble.model;

public class CasillaPalabraTriple extends Casilla {
    private Color color;    

    public CasillaPalabraTriple(Integer coordenadaX, Integer coordenadaY) {
        super(coordenadaY, coordenadaY);
        this.color = Color.ROJO;
    }

    public Color getColor() {
        return color;
    }

    public String colorConsola() {
        return "\u001B[31m";
    }
}
