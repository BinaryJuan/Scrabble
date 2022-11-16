package ar.scrabble.unlu;
import java.util.ArrayList;

public class Atril {
    private Integer tamanio;
    private ArrayList<Ficha> fichas;

    public Atril(Integer tamanio) {
        this.tamanio = tamanio;
        this.fichas = new ArrayList<Ficha>();
    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    public void eliminarFicha(Ficha ficha) {
        this.fichas.remove(ficha);
    }

    public void mostrarAtril() {
        String fichasString = " ";
        for (Ficha ficha : this.fichas) {
            fichasString += ficha.getLetra() + " ";
        }
        System.out.println("Atril: " + fichasString + "[" + this.fichas.size() + "]");
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public Ficha sacarFicha(Monton monton) {
        int posicion = (int) (Math.random() * monton.getFichas().size());
        Ficha ficha = monton.getFichas().get(posicion);
        monton.getFichas().remove(posicion);
        return ficha;
    }

    public void generarAtril(Monton monton) {
        for (int i = 0; i < this.tamanio; i++) {
            Ficha fichaDelMonton = sacarFicha(monton);
            this.agregarFicha(fichaDelMonton);
        }
    }

    public void completarAtril(Monton monton) {
        while (this.fichas.size() < 7) {
            Ficha fichaDelMonton = sacarFicha(monton);
            this.agregarFicha(fichaDelMonton);
        }
    }
}
