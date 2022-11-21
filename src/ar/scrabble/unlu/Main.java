package ar.scrabble.unlu;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(juego, vista);
        controlador.jugar();
    }
}