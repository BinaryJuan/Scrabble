package ar.scrabble.unlu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diccionario {
    private String[] palabras;

    public Diccionario() {
        this.palabras = null;
    }

    public void agregarPalabra(String palabra) {
        if (this.palabras == null) {
            this.palabras = new String[1];
            this.palabras[0] = palabra;
        } else {
            String[] palabrasAux = new String[this.palabras.length + 1];
            for (int i = 0; i < this.palabras.length; i++) {
                palabrasAux[i] = this.palabras[i];
            }
            palabrasAux[palabrasAux.length - 1] = palabra;
            this.palabras = palabrasAux;
        }
    }

    public void cargarDiccionario() {
        try {
            File archivo = new File("assets/palabras.txt");
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String palabra = sc.nextLine();
                this.agregarPalabra(palabra);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error al cargar el diccionario");
            e.printStackTrace();
        }
    }

    public boolean buscarPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        boolean existe = false;
        int i = 0;
        while (!existe && i < this.palabras.length) {
            if (this.palabras[i].equals(palabra)) {
                existe = true;
            }
            i++;
        }
        return existe;
    }

}
