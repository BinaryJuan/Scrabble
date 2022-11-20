package ar.scrabble.unlu;

public class Controlador {
    Juego juego;
    Vista vista;

    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void partida() {
        Boolean terminado = false;
        while (!terminado) {
            int opcionElegida = vista.inputMenuPrincipal();
            switch (opcionElegida) {
                case 1:
                    Juego juego = new Juego();
                    juego.generarMonton();
                    vista.notificacionCargandoDiccionario();
                    juego.cargarDiccionario();
                    int cantidadJugadores = vista.inputCantidadJugadores();
                    Boolean agregado = false;
                    while (!agregado) {
                        if (cantidadJugadores > 1 && cantidadJugadores < 5) {
                            agregado = true;
                        } else {
                            vista.mostrarCantidadDeJugadoresIncorrecta();
                        }
                    }
                    for (int i = 0; i < cantidadJugadores; i++) {
                        String nombre = vista.inputNombreJugador(i + 1);
                        juego.agregarJugador(nombre);
                    }
                    juego.generarTablero();
                    vista.mostrarTablero(juego.getTablero().getCasillas());
                    vista.mostrarCantidadMonton(juego.getMonton().getFichas().size());
                    juego.generarPrimerTurno(juego.getMonton());
                    juego.setTurnoActual(juego.getPrimerTurno());
                    while (juego.getMonton().getCantidad() > 0 && juego.quedanFichasAtriles() && !terminado) {
                        vista.mostrarTurno(juego.getTurnoActual().getNombre(), juego.getTurnoActual().getPuntaje());
                        vista.mostrarAtril(juego.getTurnoActual().getAtril());
                        int opcionJugador = vista.inputMenuTurno(juego.getTurnoActual().getNombre());
                        switch (opcionJugador) {
                            case 1:
                                Ficha ficha = juego.getMonton().sacarFicha();
                                vista.mostrarFichaSacada(ficha.getLetraSimbolo());
                                juego.getTurnoActual().getAtril().agregarFicha(ficha);
                                vista.mostrarCantidadMonton(juego.getMonton().getFichas().size());
                                vista.mostrarAtril(juego.getTurnoActual().getAtril());
                                juego.setTurnoActual(juego.siguienteTurno(juego.getTurnoActual()));
                                break;
                            case 2:
                                vista.mostrarTablero(juego.getTablero().getCasillas());
                                vista.mostrarAtril(juego.getTurnoActual().getAtril());
                                int opcionFichaAtril = vista.inputPosicionAtril();
                                Ficha fichaColocar = juego.getTurnoActual().getAtril().getFichas().get(opcionFichaAtril - 1);
                                int coordenadaX = vista.inputPosicionX();
                                int coordenadaY = vista.inputPosicionY();
                                Boolean colocada = juego.getTablero().colocarFicha(fichaColocar, coordenadaX, coordenadaY);
                                if (colocada) {
                                    juego.getTurnoActual().getAtril().getFichas().remove(opcionFichaAtril - 1);
                                } else {
                                    vista.mostrarFichaNoColocada();
                                }
                                vista.mostrarTablero(juego.getTablero().getCasillas());
                                vista.mostrarTurno(juego.getTurnoActual().getNombre(), juego.getTurnoActual().getPuntaje());
                                vista.mostrarAtril(juego.getTurnoActual().getAtril());
                                break;
                            case 3:
                                vista.mostrarTablero(juego.getTablero().getCasillas());
                                Integer posicionSacarX = vista.inputSacarPosicionX();
                                Integer posicionSacarY = vista.inputSacarPosicionY();
                                Ficha fichaSacar = juego.getTablero().sacarFicha(posicionSacarX, posicionSacarY);
                                vista.mostrarTablero(juego.getTablero().getCasillas());
                                if (fichaSacar != null) {
                                    juego.getTurnoActual().getAtril().agregarFicha(fichaSacar);
                                    vista.notificacionAtrilActualizado();
                                    vista.mostrarAtril(juego.getTurnoActual().getAtril());
                                } else {
                                    vista.notificacionFichaInexistente();
                                }
                                break;
                            case 4:
                                juego.getTurnoActual().getAtril().completarAtril(juego.getMonton());
                                Integer opcionPalabra = vista.inputPalabraFormada();
                                if (opcionPalabra == 1) {
                                    vista.mostrarDondeEmpiezaYTerminaPalabra();
                                    Integer posicionXInicial = vista.inputPalabraPosicionInicialX();
                                    Integer posicionYInicial = vista.inputPalabraPosicionInicialY();
                                    Integer posicionXFinal = vista.inputPalabraPosicionFinalX();
                                    Integer posicionYFinal = vista.inputPalabraPosicionFinalY();
                                    Palabra palabraFormada = juego.crearPalabra(posicionXInicial, posicionYInicial, posicionXFinal, posicionYFinal);
                                    vista.mostrarPalabraFormada(juego.getTablero(), palabraFormada);
                                    String palabraBuscar = palabraFormada.calcularPalabra(juego.getTablero());
                                    if (juego.buscarPalabra(palabraBuscar)) {
                                        vista.mostrarPalabraValida();
                                        Integer puntosPalabra = palabraFormada.calcularPuntajePalabra(juego.getTablero());
                                        juego.setPuntajePalabra(palabraFormada, puntosPalabra);
                                        palabraFormada.setPuntaje(puntosPalabra);
                                        vista.mostrarPuntosPalabra(puntosPalabra);
                                        juego.getTurnoActual().setPuntaje(palabraFormada.getPuntaje());
                                        vista.mostrarpuntajeActualizado(juego.getTurnoActual().getNombre(), juego.getTurnoActual().getPuntaje());
                                        juego.setTurnoActual(juego.siguienteTurno(juego.getTurnoActual()));
                                        vista.mostrarTurnoTerminado();
                                        vista.mostrarCantidadMonton(juego.getMonton().getFichas().size());
                                    } else {
                                        vista.mostrarPalabraInvalida();
                                    }
                                } else {
                                    vista.mostrarPalabraNoFormada();
                                }
                                break;
                            case 5:
                                terminado = true;
                                vista.mostrarGameover();
                                vista.mostrarGanador(juego.calcularGanador());
                                break;
                            default:
                                vista.mostrarOpcionInvalida();
                                break;
                        }
                    }
                    if (juego.getMonton().getCantidad() == 0) {
                        vista.mostrarGameover();
                        vista.mostrarGanador(juego.calcularGanador());
                    }
                    break;
                case 2:
                    terminado = true;
                    vista.mostrarGameover();
                    break;
                default:
                    vista.mostrarOpcionInvalida();
                    break;
            }
        }
    }
}