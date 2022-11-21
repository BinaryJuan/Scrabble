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
        if (ficha != null) {
            this.fichas.remove(ficha);
        } else {
            System.out.println("[ERROR MODELO] No se puede eliminar una ficha nula");
        }
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
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
        while (this.fichas.size() < this.tamanio) {
            Ficha fichaDelMonton = sacarFicha(monton);
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
}
