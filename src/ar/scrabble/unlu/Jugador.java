package ar.scrabble.unlu;
public class Jugador {
    private String nombre;
    private Integer puntaje;
    private Atril atril;
    private Ficha primerTurno;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.atril = new Atril(7);
        this.primerTurno = null;
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

    public void setPuntaje(Integer puntaje) {
        this.puntaje += puntaje;
    }

    public Atril getAtril() {
        return atril;
    }

    public void setAtril(Atril atril) {
        this.atril = atril;
    }

    public void agregarPuntaje(Integer puntaje) {
        this.puntaje += puntaje;
    }

    public void agregarFicha(Ficha ficha) {
        this.atril.agregarFicha(ficha);
    }

    public void eliminarFicha(Ficha ficha) {
        this.atril.eliminarFicha(ficha);
    }

    public void mostrarPuntaje() {
        System.out.println(this.puntaje);
    }

    public char tomarFichaTurno(Monton monton) {
        Ficha ficha = monton.sacarFicha();
        return ficha.getLetra();
    }
}
