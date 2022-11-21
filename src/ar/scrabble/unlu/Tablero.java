package ar.scrabble.unlu;
import java.util.ArrayList;

public class Tablero implements Observable {
    private Casilla[][] casillas;
    private ArrayList<Observador> observadores;

    public Tablero() {
        this.casillas = new Casilla[][] {
            {new CasillaPalabraTriple(0, 0), new CasillaNormal(0, 1), new CasillaNormal(0, 2), new CasillaLetraDoble(0, 3), new CasillaNormal(0, 4), new CasillaNormal(0, 5), new CasillaNormal(0, 6), new CasillaPalabraTriple(0, 7), new CasillaNormal(0, 8), new CasillaNormal(0, 9), new CasillaNormal(0, 10), new CasillaLetraDoble(0, 11), new CasillaNormal(0, 12), new CasillaNormal(0, 13), new CasillaPalabraTriple(0, 14)},
            {new CasillaNormal(1, 0), new CasillaPalabraDoble(1, 1), new CasillaNormal(1, 2), new CasillaNormal(1, 3), new CasillaNormal(1, 4), new CasillaLetraTriple(1, 5), new CasillaNormal(1, 6), new CasillaNormal(1, 7), new CasillaNormal(1, 8), new CasillaLetraTriple(1, 9), new CasillaNormal(1, 10), new CasillaNormal(1, 11), new CasillaNormal(1, 12), new CasillaPalabraDoble(1, 13), new CasillaNormal(1, 14)},
            {new CasillaNormal(2, 0), new CasillaNormal(2, 1), new CasillaPalabraDoble(2, 2), new CasillaNormal(2, 3), new CasillaNormal(2, 4), new CasillaNormal(2, 5), new CasillaLetraDoble(2, 6), new CasillaNormal(2, 7), new CasillaLetraDoble(2, 8), new CasillaNormal(2, 9), new CasillaNormal(2, 10), new CasillaNormal(2, 11), new CasillaPalabraDoble(2, 12), new CasillaNormal(2, 13), new CasillaNormal(2, 14)},
            {new CasillaLetraDoble(3, 0), new CasillaNormal(3, 1), new CasillaNormal(3, 2), new CasillaPalabraDoble(3, 3), new CasillaNormal(3, 4), new CasillaNormal(3, 5), new CasillaNormal(3, 6), new CasillaLetraDoble(3, 7), new CasillaNormal(3, 8), new CasillaNormal(3, 9), new CasillaNormal(3, 10), new CasillaPalabraDoble(3, 11), new CasillaNormal(3, 12), new CasillaNormal(3, 13), new CasillaLetraDoble(3, 14)},
            {new CasillaNormal(4, 0), new CasillaNormal(4, 1), new CasillaNormal(4, 2), new CasillaNormal(4, 3), new CasillaPalabraDoble(4, 4), new CasillaNormal(4, 5), new CasillaNormal(4, 6), new CasillaNormal(4, 7), new CasillaNormal(4, 8), new CasillaNormal(4, 9), new CasillaPalabraDoble(4, 10), new CasillaNormal(4, 11), new CasillaNormal(4, 12), new CasillaNormal(4, 13), new CasillaNormal(4, 14)},
            {new CasillaNormal(5, 0), new CasillaLetraTriple(5, 1), new CasillaNormal(5, 2), new CasillaNormal(5, 3), new CasillaNormal(5, 4), new CasillaLetraTriple(5, 5), new CasillaNormal(5, 6), new CasillaNormal(5, 7), new CasillaNormal(5, 8), new CasillaLetraTriple(5, 9), new CasillaNormal(5, 10), new CasillaNormal(5, 11), new CasillaNormal(5, 12), new CasillaLetraTriple(5, 13), new CasillaNormal(5, 14)},
            {new CasillaNormal(6, 0), new CasillaNormal(6, 1), new CasillaLetraDoble(6, 2), new CasillaNormal(6, 3), new CasillaNormal(6, 4), new CasillaNormal(6, 5), new CasillaLetraDoble(6, 6), new CasillaNormal(6, 7), new CasillaLetraDoble(6, 8), new CasillaNormal(6, 9), new CasillaNormal(6, 10), new CasillaNormal(6, 11), new CasillaLetraDoble(6, 12), new CasillaNormal(6, 13), new CasillaNormal(6, 14)},
            {new CasillaPalabraTriple(7, 0), new CasillaNormal(7, 1), new CasillaNormal(7, 2), new CasillaLetraDoble(7, 3), new CasillaNormal(7, 4), new CasillaNormal(7, 5), new CasillaNormal(7, 6), new CasillaPalabraDoble(7, 7), new CasillaNormal(7, 8), new CasillaNormal(7, 9), new CasillaNormal(7, 10), new CasillaLetraDoble(7, 11), new CasillaNormal(7, 12), new CasillaNormal(7, 13), new CasillaPalabraTriple(7, 14)},
            {new CasillaNormal(8, 0), new CasillaNormal(8, 1), new CasillaLetraDoble(8, 2), new CasillaNormal(8, 3), new CasillaNormal(8, 4), new CasillaNormal(8, 5), new CasillaLetraDoble(8, 6), new CasillaNormal(8, 7), new CasillaLetraDoble(8, 8), new CasillaNormal(8, 9), new CasillaNormal(8, 10), new CasillaNormal(8, 11), new CasillaLetraDoble(8, 12), new CasillaNormal(8, 13), new CasillaNormal(8, 14)},
            {new CasillaNormal(9, 0), new CasillaLetraTriple(9, 1), new CasillaNormal(9, 2), new CasillaNormal(9, 3), new CasillaNormal(9, 4), new CasillaLetraTriple(9, 5), new CasillaNormal(9, 6), new CasillaNormal(9, 7), new CasillaNormal(9, 8), new CasillaLetraTriple(9, 9), new CasillaNormal(9, 10), new CasillaNormal(9, 11), new CasillaNormal(9, 12), new CasillaLetraTriple(9, 13), new CasillaNormal(9, 14)},
            {new CasillaNormal(10, 0), new CasillaNormal(10, 1), new CasillaNormal(10, 2), new CasillaNormal(10, 3), new CasillaPalabraDoble(10, 4), new CasillaNormal(10, 5), new CasillaNormal(10, 6), new CasillaNormal(10, 7), new CasillaNormal(10, 8), new CasillaNormal(10, 9), new CasillaPalabraDoble(10, 10), new CasillaNormal(10, 11), new CasillaNormal(10, 12), new CasillaNormal(10, 13), new CasillaNormal(10, 14)},
            {new CasillaLetraDoble(11, 0), new CasillaNormal(11, 1), new CasillaNormal(11, 2), new CasillaPalabraDoble(11, 3), new CasillaNormal(11, 4), new CasillaNormal(11, 5), new CasillaNormal(11, 6), new CasillaLetraDoble(11, 7), new CasillaNormal(11, 8), new CasillaNormal(11, 9), new CasillaNormal(11, 10), new CasillaPalabraDoble(11, 11), new CasillaNormal(11, 12), new CasillaNormal(11, 13), new CasillaLetraDoble(11, 14)},
            {new CasillaNormal(12, 0), new CasillaNormal(12, 1), new CasillaPalabraDoble(12, 2), new CasillaNormal(12, 3), new CasillaNormal(12, 4), new CasillaNormal(12, 5), new CasillaLetraDoble(12, 6), new CasillaNormal(12, 7), new CasillaLetraDoble(12, 8), new CasillaNormal(12, 9), new CasillaNormal(12, 10), new CasillaNormal(12, 11), new CasillaPalabraDoble(12, 12), new CasillaNormal(12, 13), new CasillaNormal(12, 14)},
            {new CasillaNormal(13, 0), new CasillaPalabraDoble(13, 1), new CasillaNormal(13, 2), new CasillaNormal(13, 3), new CasillaNormal(13, 4), new CasillaLetraTriple(13, 5), new CasillaNormal(13, 6), new CasillaNormal(13, 7), new CasillaNormal(13, 8), new CasillaLetraTriple(13, 9), new CasillaNormal(13, 10), new CasillaNormal(13, 11), new CasillaNormal(13, 12), new CasillaPalabraDoble(13, 13), new CasillaNormal(13, 14)},
            {new CasillaPalabraTriple(14, 0), new CasillaNormal(14, 1), new CasillaNormal(14, 2), new CasillaLetraDoble(14, 3), new CasillaNormal(14, 4), new CasillaNormal(14, 5), new CasillaNormal(14, 6), new CasillaPalabraTriple(14, 7), new CasillaNormal(14, 8), new CasillaNormal(14, 9), new CasillaNormal(14, 10), new CasillaLetraDoble(14, 11), new CasillaNormal(14, 12), new CasillaNormal(14, 13), new CasillaPalabraTriple(14, 14)},
        };
        this.observadores = new ArrayList<Observador>();
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizarTablero(this.casillas);
        }
    }

    public void enlazarObservador(Observador o) {
        observadores.add(o);
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Boolean colocarFicha(Ficha ficha, Integer x, Integer y) {
        Ficha fichaAColocar = this.casillas[x][y].getFicha();
        if (fichaAColocar == null) {
            this.casillas[x][y].setFicha(ficha);
            notificar();
            return true;
        } else {
            System.out.println("La casilla ya está ocupada");
            return false;
        }
    }

    public Ficha sacarFicha(Integer x, Integer y) {
        Ficha ficha = this.casillas[x][y].getFicha();
        if (ficha != null) {
            this.casillas[x][y].setFicha(null);
            notificar();
        }
        return ficha;
    }

    public Ficha inspeccionarFicha(Integer x, Integer y) {
        Ficha ficha = this.casillas[x][y].getFicha();
        return ficha;
    }

    public void setFichasFalse() {
        for (Integer i = 0; i < 15; i++) {
            for (Integer j = 0; j < 15; j++) {
                if (this.casillas[i][j].getFicha() != null) {
                    this.casillas[i][j].getFicha().setEsTurnoActual(false);
                }
            }
        }
    }

    public Casilla[][] getTablero() {
        return this.casillas;
    }

    public ArrayList<Ficha> sacarFichasTurnoActual() {
        ArrayList<Ficha> fichas = new ArrayList<Ficha>();
        for (Integer i = 0; i < 15; i++) {
            for (Integer j = 0; j < 15; j++) {
                if (this.casillas[i][j].getFicha() != null) {
                    if (this.casillas[i][j].getFicha().getEsTurnoActual()) {
                        fichas.add(this.casillas[i][j].getFicha());
                        this.casillas[i][j].setFicha(null);
                    }
                }
            }
        }
        return fichas;
    }
}