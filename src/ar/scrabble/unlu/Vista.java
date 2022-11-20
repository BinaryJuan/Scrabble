package ar.scrabble.unlu;
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    static Scanner sc;

    public int inputMenuPrincipal() {
        sc = new Scanner(System.in);
        System.out.print("\u001B[34m");
        System.out.println("====================");
        System.out.println("¡Bienvenido a Scrabble!");
        System.out.println("====================");
        System.out.print("\u001B[0m");
        System.out.println("\u001B[32m 1. JUGAR");
        System.out.println("\u001B[31m 2. SALIR");
        System.out.print("\u001B[0m");
        System.out.print("\u001B[33m Ingrese una opción: ");
        System.out.print("\u001B[0m");
        int opcionElegida = sc.nextInt();
        return opcionElegida;
    }

    public int inputMenuTurno(String jugador) {
        System.out.println("\u001B[33m Ingrese una opción, " + jugador + ":");
        System.out.println("1. Sacar ficha del montón");
        System.out.println("2. Colocar ficha en el tablero");
        System.out.println("3. Sacar ficha del tablero");
        System.out.println("4. Terminar turno");
        System.out.println("5. Salir del juego");
        System.out.print("\u001B[0m");
        Integer opcionJugador = sc.nextInt();
        return opcionJugador;
    }

    public int inputCantidadJugadores() {
        System.out.print("\u001B[33m Ingrese la cantidad de jugadores: ");
        System.out.print("\u001B[0m");
        Integer cantidadJugadores = sc.nextInt();
        return cantidadJugadores;
    }

    public String inputNombreJugador(Integer numeroJugador) {
        System.out.print("\u001B[33m Ingrese el nombre del jugador " + numeroJugador + ": ");
        System.out.print("\u001B[0m");
        String nombre = sc.next();
        return nombre;
    }

    public Integer inputPosicionAtril() {
        System.out.println("\u001B[33mIngrese la \u001B[34mposición en el atril\u001B[33m de la ficha que desea colocar (pos. de 1 en adelante): ");
        Integer posicionAtril = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionAtril;
    }

    public Integer inputPosicionX() {
        System.out.println("Ingrese la \u001B[34mposición X\u001B[0m en la que desea \u001B[34mcolocar la ficha\u001B[0m: ");
        Integer posicionX = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionX;
    }

    public Integer inputPosicionY() {
        System.out.println("Ingrese la \u001B[34mposición Y\u001B[0m en la que desea \u001B[34mcolocar la ficha\u001B[0m: ");
        Integer posicionY = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionY;
    }

    public Integer inputSacarPosicionX() {
        System.out.println("\u001B[33m Ingrese la \u001B[34mposición X\u001B[0m de la ficha que desea sacar: ");
        Integer posicionXSacar = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionXSacar;
    }

    public Integer inputSacarPosicionY() {
        System.out.println("Ingrese la \u001B[34mposición Y\u001B[34m de la ficha que desea \u001B[31msacar\u001B[0m: ");
        Integer posicionYSacar = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionYSacar;
    }

    public Integer inputPalabraFormada() {
        System.out.println("\u001B[33m ¿Usted formó una palabra?: ");
        System.out.println("1. Sí");
        System.out.println("2. No");
        Integer opcionPalabra = sc.nextInt();
        return opcionPalabra;
    }

    public Integer inputPalabraPosicionInicialX() {
        System.out.print("\u001B[33m");
        System.out.println("Ingrese la \u001B[34mposición X\u001B[33m de la ficha inicial: ");
        Integer posicionXInicial = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionXInicial;
    }

    public Integer inputPalabraPosicionInicialY() {
        System.out.print("\u001B[33m");
        System.out.println("Ingrese la \u001B[34mposición Y\u001B[33m de la ficha inicial: ");
        Integer posicionYInicial = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionYInicial;
    }

    public Integer inputPalabraPosicionFinalX() {
        System.out.print("\u001B[33m");
        System.out.println("Ingrese la \u001B[34mposición X\u001B[33m de la ficha final: ");
        Integer posicionXFinal = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionXFinal;
    }

    public Integer inputPalabraPosicionFinalY() {
        System.out.print("\u001B[33m");
        System.out.println("Ingrese la \u001B[34mposición Y\u001B[33m de la ficha final: ");
        Integer posicionYFinal = sc.nextInt();
        System.out.print("\u001B[0m");
        return posicionYFinal;
    }

    public void mostrarTurno(String jugador, Integer puntaje) {
        System.out.println("--------------------");
        System.out.println("\u001B[34m [Turno de " + jugador + "]");
        System.out.println("\u001B[34m PUNTAJE: " + puntaje);
        System.out.print("\u001B[0m");
        System.out.println("--------------------");
    }

    public void mostrarCantidadDeJugadoresIncorrecta() {
        System.out.println("\u001B[31m ¡La cantidad de jugadores debe ser entre 2 y 4!");
        System.out.print("\u001B[0m");
    }

    public void mostrarGameover() {
        System.out.print("\u001B[31m");
        System.out.println("=======================");
        System.out.println("JUEGO TERMINADO");
        System.out.println("=======================");
        System.out.print("\u001B[0m");
    }

    public void mostrarOpcionInvalida() {
        System.out.println("\u001B[31m" + "Opción incorrecta");
        System.out.print("\u001B[0m");
    }

    public void mostrarFichaSacada(char letra) {
        System.out.println("Ficha sacada del montón: " + letra);
    }

    public void mostrarTablero(Casilla[][] casillas) {
        String tabla = "\u001B[33m       Y0   Y1   Y2   Y3   Y4   Y5   Y6   Y7   Y8   Y9   Y10  Y11  Y12  Y13  Y14  \u001B[0m";
        for (int i = 0; i < 15; i++) {
            tabla += "\n \u001B[33m X" + String.format("%1$2s", i) + " \u001B[0m";
            for (int j = 0; j < 15; j++) {
                tabla += casillas[i][j].devolverCasillaConValorYLetra();
            }
        }
        System.out.println("");
        System.out.println(tabla);
        System.out.println("");
        System.out.print("\u001B[0m");
    }

    public void mostrarCantidadMonton(Integer cantidad) {
        System.out.println("Montón: " + "quedan [" + cantidad + "] fichas");
    }

    public void mostrarAtril(Atril atril) {
        String fichasString = " ";
        Integer posicion = 0;
        for (Ficha ficha : atril.getFichas()) {
            posicion++;
            fichasString += ficha.getLetraSimbolo() + "(" + posicion + ") ";
        }
        System.out.println("Atril: " + fichasString + "[" + atril.getFichas().size() + "]");
    }

    
    public void mostrarFichaNoColocada() {
        System.out.println("\u001B[31m" + "No se pudo colocar la ficha");
        System.out.print("\u001B[0m");
    }

    public void mostrarGanador(ArrayList<Jugador> ganadores) {
        if (ganadores.size() == 1) {
            System.out.println("\u001B[32m" + "El ganador es: " + ganadores.get(0).getNombre() + " con un puntaje de " + ganadores.get(0).getPuntaje());
            System.out.print("\u001B[0m");
        } else {
            System.out.println("\u001B[32m" + "[EMPATE] Los ganadores son: ");
            for (Jugador jugador : ganadores) {
                System.out.println("- " + jugador.getNombre() + " con un puntaje de " + jugador.getPuntaje());
            }
            System.out.print("\u001B[0m");
        }
    }

    public void mostrarDondeEmpiezaYTerminaPalabra() {
        System.out.println("Antes de terminar el turno, ingrese las posiciones en donde empieza y termina su palabra: ");
    }

    public void mostrarPalabraFormada(Tablero tablero, Palabra palabraFormada) {
        System.out.println("Palabra formada: " + palabraFormada.calcularPalabra(tablero));
    }

    public void mostrarPuntosPalabra(Integer puntos) {
        System.out.println("Puntos de la palabra: " + puntos);
    }

    public void mostrarpuntajeActualizado(String jugador, Integer puntaje) {
        System.out.println("\u001B[32m El puntaje de " + jugador + " es ahora de: " + puntaje);
        System.out.print("\u001B[0m");
    }

    public void mostrarPalabraNoFormada() {
        System.out.println("\u001B[31m No se formó ninguna palabra, por lo que su puntaje del turno es 0");
        System.out.print("\u001B[0m");
    }

    public void mostrarTurnoTerminado() {
        System.out.println("Turno terminado");
    }

    public void mostrarPalabraValida() {
        System.out.println("\u001B[32m" + "La palabra es válida en el diccionario");
        System.out.print("\u001B[0m");
    }

    public void mostrarPalabraInvalida() {
        System.out.println("\u001B[31m" + "La palabra no es válida en el diccionario");
        System.out.print("\u001B[0m");
    }

    public void notificacionAtrilActualizado() {
        System.out.println("Atril actualizado");
    }

    public void notificacionFichaInexistente() {
        System.out.println("\u001B[31m" + "La ficha que trata de sacar en esa posición no existe");
        System.out.print("\u001B[0m");
    }

    public void notificacionCargandoDiccionario() {
        System.out.println(" Cargando diccionario...");
    }
}
