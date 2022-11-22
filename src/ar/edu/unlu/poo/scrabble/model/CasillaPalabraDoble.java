package ar.edu.unlu.poo.scrabble.model;

public class CasillaPalabraDoble extends Casilla {
    private Color color;    

    public CasillaPalabraDoble(Integer coordenadaX, Integer coordenadaY) {
        super(coordenadaY, coordenadaY);
        this.color = Color.ROSA;
    }

    public Color getColor() {
        return color;
    }

    public String colorConsola() {
        return "\u001B[35m";
    }
}
