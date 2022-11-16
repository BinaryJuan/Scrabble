package ar.scrabble.unlu;
import java.util.Scanner;
import java.util.ArrayList;

// VALIDAR TODOS LOS INPUTS
public class Juego {
    static ArrayList<Jugador> jugadores;
    static Scanner scanner;
    public static void main(String[] args) {
        Boolean terminado = false;
        while (!terminado) {
            System.out.print("\u001B[34m");
            System.out.println("====================");
            System.out.println("Bienvenido a Scrabble");
            System.out.println("====================");
            System.out.print("\u001B[0m");
            System.out.println("\u001B[32m 1. JUGAR");
            System.out.println("\u001B[31m 2. SALIR");
            System.out.print("\u001B[0m");
            System.out.print("\u001B[33m Ingrese una opcion: ");
            System.out.print("\u001B[0m");
            scanner = new Scanner(System.in);
            Integer opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    Tablero tablero = new Tablero();
                    tablero.generarTablero();
                    Monton monton = new Monton();
                    System.out.println("");
                    tablero.mostrarTablero();
                    System.out.println("");
                    monton.generarMonton();
                    monton.mostrarCantidadMonton();
                    jugadores = new ArrayList<Jugador>();
                    Boolean agregado = false;
                    Integer cantidadJugadores = 0;
                    while (!agregado) {
                        System.out.print("\u001B[33m Ingrese la cantidad de jugadores: ");
                        System.out.print("\u001B[0m");
                        cantidadJugadores = scanner.nextInt();
                        if (cantidadJugadores > 1 && cantidadJugadores < 5) {
                            agregado = true;
                        } else {
                            System.out.println("\u001B[31m" + "Cantidad de jugadores incorrecta");
                            System.out.print("\u001B[0m");
                        }
                    }
                    for (int i = 0; i < cantidadJugadores; i++) {
                        System.out.print("\u001B[33m Ingrese el nombre del jugador " + (i + 1) + ": ");
                        System.out.print("\u001B[0m");
                        String nombre = scanner.next();
                        Jugador jugador = new Jugador(nombre);
                        jugador.getAtril().generarAtril(monton);
                        jugadores.add(jugador);
                    }

                    // System.out.println("Jugadores:");
                    // String jugadoresString = "";
                    // for (Jugador jugador : jugadores) {
                    //     jugadoresString += jugador.getNombre() + " | ";
                    // }
                    // System.out.println(jugadoresString);
                    
                    generarPrimerTurno(monton);
                    Jugador turnoActual = getPrimerTurno();
                    while (monton.getCantidad() > 0 && !terminado) {
                        System.out.println("\u001B[0m" + turnoActual.getNombre() + " es tu turno");
                        System.out.println("\u001B[33m Ingrese una opcion, " + turnoActual.getNombre() + ":");
                        System.out.println("1. Sacar ficha del monton");
                        System.out.println("2. Colocar ficha en el tablero");
                        System.out.println("3. Sacar ficha del tablero");
                        System.out.println("4. Terminar turno");
                        System.out.println("5. Salir del juego");
                        System.out.print("\u001B[0m");
                        Integer opcionJugador = scanner.nextInt();
                        switch (opcionJugador) {
                            case 1:
                                Ficha ficha = monton.sacarFicha();
                                turnoActual.getAtril().agregarFicha(ficha);
                                System.out.println("Ficha sacada: " + ficha.getLetra());
                                turnoActual.getAtril().mostrarAtril();
                                turnoActual = siguienteTurno(turnoActual);
                                break;
                            case 2:
                                tablero.mostrarTablero();
                                turnoActual.getAtril().mostrarAtril();
                                System.out.println("\u001B[33m Ingrese la posicion en el atril de la ficha que desea colocar (1 en adelante): ");
                                Integer posicion = scanner.nextInt();
                                Ficha fichaColocar = turnoActual.getAtril().getFichas().get(posicion - 1);
                                System.out.println("Ingrese la posicion X en la que desea colocar la ficha: ");
                                Integer posicionX = scanner.nextInt();
                                System.out.println("Ingrese la posicion Y en la que desea colocar la ficha: ");
                                System.out.print("\u001B[0m");
                                Integer posicionY = scanner.nextInt();
                                Boolean colocada = tablero.colocarFicha(fichaColocar, posicionX, posicionY);
                                if (colocada) {
                                    turnoActual.getAtril().getFichas().remove(posicion - 1);
                                } else {
                                    System.out.println("\u001B[31m" + "No se pudo colocar la ficha");
                                    System.out.print("\u001B[0m");
                                }
                                tablero.mostrarTablero();
                                System.out.print(turnoActual.getNombre() + " | ");
                                turnoActual.getAtril().mostrarAtril();
                                break;
                            case 3:
                                tablero.mostrarTablero();
                                System.out.println("\u001B[33m Ingrese la posicion X de la ficha que desea sacar: ");
                                Integer posicionXSacar = scanner.nextInt();
                                System.out.println("Ingrese la posicion Y de la ficha que desea sacar: ");
                                System.out.print("\u001B[0m");
                                Integer posicionYSacar = scanner.nextInt();
                                Ficha fichaSacar = tablero.sacarFicha(posicionXSacar, posicionYSacar);
                                tablero.mostrarTablero();
                                if (fichaSacar != null) {
                                    turnoActual.getAtril().agregarFicha(fichaSacar);
                                    System.out.print(turnoActual.getNombre() + " | ");
                                    turnoActual.getAtril().mostrarAtril();
                                } else {
                                    System.out.println("No hay una ficha en esa posicion");
                                }
                                break;
                            case 4:
                                turnoActual.getAtril().completarAtril(monton);
                                // FALTA VALIDAR LA PALABRA QUE SE COLOCA EN EL DICCIONARIO (DENTRO DE LA CLASE PALABRA)
                                // TRATAR DE PONER LOS VALORES COMO SUBINDICES (NUMEROS CHIQUITOS COMO EN QUIMICA)
                                System.out.println("\u001B[33m ¿Usted formo una palabra?: ");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                Integer opcionPalabra = scanner.nextInt();
                                if (opcionPalabra == 1) {
                                    System.out.println("Antes de terminar el turno, seleccione donde empieza y termina su palabra: ");
                                    System.out.println("Ingrese la posicion X de la ficha inicial: ");
                                    Integer posicionXInicial = scanner.nextInt();
                                    System.out.println("Ingrese la posicion Y de la ficha inicial: ");
                                    Integer posicionYInicial = scanner.nextInt();
                                    System.out.println("Ingrese la posicion X de la ficha final: ");
                                    Integer posicionXFinal = scanner.nextInt();
                                    System.out.println("Ingrese la posicion Y de la ficha final: ");
                                    System.out.print("\u001B[0m");
                                    Integer posicionYFinal = scanner.nextInt();
                                    Palabra palabraFormada = new Palabra(0, posicionXInicial, posicionYInicial, posicionXFinal, posicionYFinal);
                                    System.out.println("Palabra formada: " + palabraFormada.calcularPalabra(tablero));
                                    Integer puntosPalabra = palabraFormada.calcularPuntajePalabra(tablero);
                                    System.out.println("Puntos de la palabra: " + puntosPalabra);
                                    palabraFormada.setPuntaje(puntosPalabra);
                                } else {
                                    System.out.println("\u001B[31m No se formo ninguna palabra, por lo que su puntaje del turno es 0");
                                }
                                turnoActual = siguienteTurno(turnoActual);
                                System.out.println("Turno terminado");
                                break;
                            case 5:
                                terminado = true;
                                System.out.print("\u001B[31m");
                                System.out.println("=======================");
                                System.out.println("JUEGO TERMINADO");
                                System.out.println("=======================");
                                System.out.print("\u001B[0m");
                                break;
                            default:
                                System.out.println("\u001B[31m" + "Opcion incorrecta");
                                System.out.print("\u001B[0m");
                                break;
                        }
                    }
                    break;
                case 2:
                    terminado = true;
                    System.out.print("\u001B[31m");
                    System.out.println("=======================");
                    System.out.println("JUEGO TERMINADO");
                    System.out.println("=======================");
                    System.out.print("\u001B[0m");
                    break;
                default:
                    System.out.println("\u001B[31m" + "Opcion incorrecta");
                    System.out.print("\u001B[0m");
                    break;
            }
        }

    }

    public static Boolean quedanFichas() {
        Boolean quedanFichas = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getAtril().getFichas().size() > 0) {
                quedanFichas = true;
            }
        }
        return quedanFichas;
    }

    public static void generarPrimerTurno(Monton monton) {
        for (Jugador jugador : jugadores) {
            Ficha ficha = monton.sacarFicha();
            jugador.setPrimerTurno(ficha);
        }
    }

    public static Jugador getPrimerTurno() {
        Jugador primerTurno = null;
        for (Jugador jugador : jugadores) {
            if (primerTurno == null) {
                primerTurno = jugador;
            } else {
                if (jugador.getPrimerTurno().getLetra() < primerTurno.getPrimerTurno().getLetra()) {
                    primerTurno = jugador;
                }
            }
        }
        return primerTurno;
    }

    public static Jugador siguienteTurno(Jugador jugadorActual) {
        Jugador siguienteTurno = null;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals(jugadorActual.getNombre())) {
                if (i == jugadores.size() - 1) {
                    siguienteTurno = jugadores.get(0);
                } else {
                    siguienteTurno = jugadores.get(i + 1);
                }
            }
        }
        return siguienteTurno;
    }
}
