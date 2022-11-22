import ar.edu.unlu.poo.scrabble.controller.Controlador;
import ar.edu.unlu.poo.scrabble.model.Juego;
import ar.edu.unlu.poo.scrabble.views.Vista;

public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(juego, vista);
        controlador.jugar();
    }
}