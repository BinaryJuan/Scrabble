package ar.edu.unlu.poo.scrabble.model;
import java.util.ArrayList;

import ar.edu.unlu.poo.scrabble.observer.Observable;
import ar.edu.unlu.poo.scrabble.observer.Observador;

public class Monton implements Observable {
    final Integer CANTIDAD_MONTON = 100;
    private ArrayList<Ficha> fichas;
    private ArrayList<Observador> observadores;

    public Monton() {
        this.fichas = new ArrayList<Ficha>();
        this.observadores = new ArrayList<Observador>();
    }

    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizarMonton(getCantidad());
        }
    }

    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    public void generarMonton() {
        for (Integer i = 0; i < CANTIDAD_MONTON; i++) {
            Ficha ficha = new Ficha(generarLetraAleatoria());
            this.fichas.add(ficha);
        }
    }

    public Integer getCantidad() {
        return this.fichas.size();
    }

    public Ficha sacarFicha() {
        Integer posicionAleatoria = this.generarPosicionAleatoria();
        Ficha ficha = this.fichas.get(posicionAleatoria);
        this.fichas.remove(ficha);
        notificar();
        return ficha;
    }

    public Integer generarPosicionAleatoria() {
        Integer n = this.fichas.size();
        Integer r = (int) (n * Math.random());
        return r;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public char generarLetraAleatoria() {
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        Integer alfabetoLength = alfabeto.length();
        Integer random = (int) (alfabetoLength * Math.random());
        char letraAleatoria = alfabeto.charAt(random);
        Boolean encontrada = false;
        while (!encontrada && this.fichas.size() < CANTIDAD_MONTON) {
            random = (int) (alfabetoLength * Math.random());
            letraAleatoria = alfabeto.charAt(random);
            if (verificarCantidadDeLetra(letraAleatoria)) {
                encontrada = true;
            }
        }
        return letraAleatoria;
    }

    public boolean verificarCantidadDeLetra(char letra) {
        Integer cantidadDeLetra = cantidadDeLetra(letra);
        Integer contador = 0;
        for (Ficha ficha : this.fichas) {
            if (ficha.getLetraSimbolo() == letra) {
                contador++;
            }
        }
        if (contador < cantidadDeLetra) {
            return true;
        } else {
            return false;
        }
    }

    public Integer cantidadDeLetra(char letra) {
        switch (letra) {
            case 'A':
                return 12;
            case 'B':
                return 4;
            case 'C':
                return 4;
            case 'D':
                return 5;
            case 'E':
                return 12;
            case 'F':
                return 1;
            case 'G':
                return 2;
            case 'H':
                return 2;
            case 'I':
                return 6;
            case 'J':
                return 1;
            case 'K':
                return 1;
            case 'L':
                return 4;
            case 'M':
                return 2;
            case 'N':
                return 5;
            case 'Ñ':
                return 1;
            case 'O':
                return 9;
            case 'P':
                return 2;
            case 'Q':
                return 1;
            case 'R':
                return 5;
            case 'S':
                return 6;
            case 'T':
                return 4;
            case 'U':
                return 5;
            case 'V':
                return 2;
            case 'W':
                return 1;
            case 'X':
                return 1;
            case 'Y':
                return 1;
            case 'Z':
                return 1;
            default:
                return 0;
        }
    }
}
