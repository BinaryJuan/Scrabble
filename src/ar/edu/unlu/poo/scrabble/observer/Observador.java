package ar.edu.unlu.poo.scrabble.observer;

import ar.edu.unlu.poo.scrabble.model.Atril;
import ar.edu.unlu.poo.scrabble.model.Casilla;

public interface Observador {
    public void actualizarTablero(Casilla[][] casillas);
    public void actualizarPuntajeJugador(String jugador, Integer puntaje);
    public void actualizarMonton(Integer cantidad);
    public void actualizarAtril(Atril atril);
}
