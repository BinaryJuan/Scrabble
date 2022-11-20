package ar.scrabble.unlu;
import java.util.Scanner;
import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private Monton monton;
    private Jugador turnoActual;
    private Diccionario diccionario;
    static Scanner sc;

    public Juego() {
        this.jugadores = new ArrayList<Jugador>();
        this.tablero = new Tablero();
        this.monton = new Monton();
        this.turnoActual = null;
        this.diccionario = new Diccionario();
    }

    public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugador.getAtril().generarAtril(monton);
        jugadores.add(jugador);
    }

    public Jugador siguienteTurno(Jugador jugadorActual) {
        Jugador siguienteTurno = null;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(jugadorActual.getNombre())) {
                if (i == jugadores.size() - 1) {
                    siguienteTurno = jugadores.get(0);
                } else {
                    siguienteTurno = jugadores.get(i + 1);
                }
            }
        }
        return siguienteTurno;
    }

    public void generarTablero() {
        tablero.generarTablero();
    }

    public void generarMonton() {
        monton.generarMonton();
    }

    public void generarPrimerTurno(Monton monton) {
        for (Jugador jugador : jugadores) {
            Ficha ficha = monton.sacarFicha();
            jugador.setPrimerTurno(ficha);
        }
    }

    public Monton getMonton() {
        return monton;
    }

    public Jugador getPrimerTurno() {
        Jugador primerTurno = null;
        for (Jugador jugador : jugadores) {
            if (primerTurno == null) {
                primerTurno = jugador;
            } else {
                if (jugador.getPrimerTurno().getValor() > primerTurno.getPrimerTurno().getValor()) {
                    primerTurno = jugador;
                }
            }
        }
        return primerTurno;
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(Jugador turnoActual) {
        this.turnoActual = turnoActual;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Palabra crearPalabra(Integer posicionXInicial, Integer posicionYInicial, Integer posicionXFinal, Integer posicionYFinal) {
        Palabra palabraFormada = new Palabra(0, posicionXInicial, posicionYInicial, posicionXFinal, posicionYFinal);
        return palabraFormada;
    }

    public void setPuntajePalabra(Palabra palabra, Integer puntaje) {
        palabra.setPuntaje(puntaje);
    }

    public Boolean quedanFichasAtriles() {
        Boolean quedanFichas = true;
        for (Jugador jugador : jugadores) {
            if (jugador.getAtril().getFichas().size() <= 0) {
                quedanFichas = false;
            }
        }
        return quedanFichas;
    }

    public ArrayList<Jugador> calcularGanador() {
        ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
        for (Jugador jugador : jugadores) {
            if (ganadores.size() == 0) {
                ganadores.add(jugador);
            } else {
                if (jugador.getPuntaje() > ganadores.get(0).getPuntaje()) {
                    ganadores.clear();
                    ganadores.add(jugador);
                } else if (jugador.getPuntaje() == ganadores.get(0).getPuntaje()) {
                    ganadores.add(jugador);
                }
            }
        }
        return ganadores;
    }

    public Diccionario getDiccionario() {
        return diccionario;
    }

    public void cargarDiccionario() {
        diccionario.cargarDiccionario();
    }

    public Boolean buscarPalabra(String palabra) {
        return diccionario.buscarPalabra(palabra);
    }
}