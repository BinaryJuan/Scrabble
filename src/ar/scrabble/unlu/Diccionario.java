package ar.scrabble.unlu;
import java.util.ArrayList;

public class Diccionario {
    private ArrayList<Palabra> palabras;

    public Diccionario() {
        this.palabras = new ArrayList<Palabra>();
    }

    public Boolean existePalabra(String palabra) {
        for (Palabra palabraDiccionario : this.palabras) {
            if (palabraDiccionario.getPalabra().equals(palabra)) {
                return true;
            }
        }
        return false;
    }
}
