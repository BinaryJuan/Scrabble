package ar.edu.unlu.poo.scrabble.model;

public class CasillaNormal extends Casilla {
    private Color color;    

    public CasillaNormal(Integer coordenadaX, Integer coordenadaY) {
        super(coordenadaY, coordenadaY);
        this.color = Color.NORMAL;
    }

    public Color getColor() {
        return color;
    }
}
