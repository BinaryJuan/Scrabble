package ar.scrabble.unlu;
import java.util.ArrayList;

public class Monton {

    private ArrayList<Ficha> fichas;
    public Monton() {
        this.fichas = new ArrayList<Ficha>();
    }

    public void generarMonton() {
        for (int i = 0; i < 100; i++) {
            Ficha ficha = new Ficha('-', 0);
            ficha.cargarFicha();
            this.fichas.add(ficha);
        }
    }

    public Integer getCantidad() {
        return this.fichas.size();
    }

    public void mostrarMonton() {
        String montonString = " ";
        for (Ficha ficha : this.fichas) {
            montonString += ficha.getLetra() + " ";
        }
        System.out.println("Monton:" + montonString + "[" + this.fichas.size() + "]");
    }

    public void mostrarCantidadMonton() {
        System.out.println("Monton:" + "quedan [" + this.fichas.size() + "] fichas");
    }

    public Ficha sacarFicha() {
        Integer posicionAleatoria = this.generarPosicionAleatoria();
        Ficha ficha = this.fichas.get(posicionAleatoria);
        this.fichas.remove(ficha);
        return ficha;
    }

    public Integer generarPosicionAleatoria() {
        int n = this.fichas.size();
        int r = (int) (n * Math.random());
        return r;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }
}
