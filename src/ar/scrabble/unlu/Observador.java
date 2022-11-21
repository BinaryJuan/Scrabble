package ar.scrabble.unlu;

public interface Observador {
    public void actualizarTablero(Casilla[][] casillas);
    public void actualizarPuntajeJugador(String jugador, Integer puntaje);
    public void actualizarMonton(Integer cantidad);
    public void actualizarAtril(Atril atril);
}
