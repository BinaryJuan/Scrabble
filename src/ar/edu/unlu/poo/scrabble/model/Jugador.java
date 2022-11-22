package ar.edu.unlu.poo.scrabble.model;
import java.util.ArrayList;

import ar.edu.unlu.poo.scrabble.observer.Observable;
import ar.edu.unlu.poo.scrabble.observer.Observador;

public class Jugador implements Observable {
    private String nombre;
    private Integer puntaje;
    private Atril atril;
    private Ficha primerTurno;
    private ArrayList<Observador> observadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.atril = new Atril(7);
        this.primerTurno = null;
        this.observadores = new ArrayList<Observador>();
    }

    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizarPuntajeJugador(this.nombre, this.puntaje);
        }
    }

    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha getPrimerTurno() {
        return primerTurno;
    }

    public void setPrimerTurno(Ficha primerTurno) {
        this.primerTurno = primerTurno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public Atril getAtril() {
        return atril;
    }

    public void setAtril(Atril atril) {
        this.atril = atril;
    }

    public void agregarPuntaje(Integer puntaje) {
        this.puntaje += puntaje;
        notificar();
    }

    public void agregarFicha(Ficha ficha) {
        this.atril.agregarFicha(ficha);
    }

    public void eliminarFicha(Ficha ficha) {
        this.atril.eliminarFicha(ficha);
    }

    public char tomarFichaTurno(Monton monton) {
        Ficha ficha = monton.sacarFicha();
        return ficha.getLetraSimbolo();
    }

    public void restarPuntajeFichasAtril() {
        if (this.puntaje > 0 ) {
            Integer puntajeHipotetico = this.puntaje - this.atril.getPuntajeTotal();
            if (puntajeHipotetico >= 0) {
                this.puntaje = puntajeHipotetico;
            } else {
                this.puntaje = 0;
            }
            notificar();
        }
    }
}
