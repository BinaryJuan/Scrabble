package ar.edu.unlu.poo.scrabble.model;

public class CasillaLetraDoble extends Casilla {
    private Color color;    

    public CasillaLetraDoble(Integer coordenadaX, Integer coordenadaY) {
        super(coordenadaY, coordenadaY);
        this.color = Color.AZULC;
    }

    public Color getColor() {
        return color;
    }

    public String colorConsola() {
        return "\u001B[36m";
    }
}
