package ar.edu.unlu.poo.scrabble.model;
import java.util.ArrayList;

import ar.edu.unlu.poo.scrabble.observer.Observable;
import ar.edu.unlu.poo.scrabble.observer.Observador;

public class Atril implements Observable {
    private Integer tamanio;
    private ArrayList<Ficha> fichas;
    private ArrayList<Observador> observadores;

    public Atril(Integer tamanio) {
        this.tamanio = tamanio;
        this.fichas = new ArrayList<Ficha>();
        this.observadores = new ArrayList<Observador>();
    }

    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizarAtril(this);
        }
    }

    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
        notificar();
    }

    public void eliminarFicha(Ficha ficha) {
        if (ficha != null) {
            this.fichas.remove(ficha);
            notificar();
        } else {
            System.out.println("[ERROR MODELO] No se puede eliminar una ficha nula");
        }
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void generarAtril(Monton monton) {
        for (Integer i = 0; i < this.tamanio; i++) {
            Ficha fichaDelMonton = monton.sacarFicha();
            this.agregarFicha(fichaDelMonton);
        }
    }

    public void completarAtril(Monton monton) {
        while (this.fichas.size() < this.tamanio) {
            Ficha fichaDelMonton = monton.sacarFicha();
            this.agregarFicha(fichaDelMonton);
        }
    }

    public Integer getPuntajeTotal() {
        Integer puntajeTotal = 0;
        for (Ficha ficha : this.fichas) {
            puntajeTotal += ficha.getValor();
        }
        return puntajeTotal;
    }

    public void devolverFichasTurnoActual(ArrayList<Ficha> fichas) {
        for (Ficha ficha : fichas) {
            this.agregarFicha(ficha);
        }
    }
}
