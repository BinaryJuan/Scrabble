package ar.scrabble.unlu;

public class Controlador {
    Juego juego;
    Vista vista;

    public Controlador(Juego juego, Vista vista) {
        this.juego = juego;
        this.vista = vista;
    }

    public void partida() {
        vista.mostrarBienvenida();
        Boolean terminado = false;
        while (!terminado) {
            int opcionElegida = vista.inputMenuPrincipal();
            Boolean agregado = false;
            while (!agregado) {
                if (juego.validarOpcionJugadorMenuPrincipal(opcionElegida)) {
                    agregado = true;
                } else {
                    vista.mostrarOpcionInvalida();
                    opcionElegida = vista.inputMenuPrincipal();
                }
            }
            switch (opcionElegida) {
                case 1:
                    Juego juego = new Juego();
                    juego.generarMonton();
                    vista.notificacionCargandoDiccionario();
                    juego.cargarDiccionario();
                    int cantidadJugadores = vista.inputCantidadJugadores();
                    agregado = false;
                    while (!agregado) {
                        if (juego.validarCantidadJugadores(cantidadJugadores)) {
                            agregado = true;
                        } else {
                            vista.mostrarCantidadDeJugadoresIncorrecta();
                            cantidadJugadores = vista.inputCantidadJugadores();
                        }
                    }
                    for (int i = 0; i < cantidadJugadores; i++) {
                        agregado = false;
                        while (!agregado) {
                            String nombre = vista.inputNombreJugador(i + 1);
                            if (juego.validarNombreJugador(nombre)) {
                                juego.agregarJugador(nombre);
                                agregado = true;
                            } else {
                                vista.mostrarNombreDeJugadorIncorrecto();
                                nombre = vista.inputNombreJugador(i + 1);
                            }
                        }
                    }
                    juego.generarTablero();
                    vista.mostrarTablero(juego.getTablero().getCasillas());
                    vista.mostrarCantidadMonton(juego.getMonton().getFichas().size());
                    juego.generarPrimerTurno(juego.getMonton());
                    juego.setTurnoActual(juego.getPrimerTurno());
                    while (juego.getMonton().getCantidad() > 0 && juego.quedanFichasAtriles() && !terminado) {
                        if (juego.limiteVecesConsecutivas()) {
                            vista.mostrarGameover();
                            vista.mostrarVecesConsecutivasSinTurno();
                            vista.mostrarGanador(juego.calcularGanador());
                            terminado = true;
                        }
                        if (!terminado) {
                            vista.mostrarTurno(juego.getTurnoActual().getNombre(), juego.getTurnoActual().getPuntaje());
                            vista.mostrarAtril(juego.getTurnoActual().getAtril());
                            int opcionJugador = vista.inputMenuTurno(juego.getTurnoActual().getNombre());
                            agregado = false;
                            while (!agregado) {
                                if (juego.validarOpcionJugador(opcionJugador)) {
                                    agregado = true;
                                } else {
                                    vista.mostrarOpcionInvalida();
                                    opcionJugador = vista.inputMenuTurno(juego.getTurnoActual().getNombre());
                                }
                            }
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
                                    Integer opcionFichaAtril = vista.inputPosicionAtril();
                                    agregado = false;
                                    while (!agregado) {
                                        if (juego.validarOpcionFichaAtril(opcionFichaAtril, juego.getTurnoActual().getAtril())) {
                                            agregado = true;
                                        } else {
                                            vista.mostrarOpcionInvalidaAtril();
                                            opcionFichaAtril = vista.inputPosicionAtril();
                                        }
                                    }
                                    Ficha fichaColocar = juego.getTurnoActual().getAtril().getFichas().get(opcionFichaAtril - 1);
                                    Integer coordenadaX = vista.inputPosicionX();
                                    Integer coordenadaY = vista.inputPosicionY();
                                    agregado = false;
                                    while (!agregado) {
                                        if (juego.validarPosicionTablero(coordenadaX, coordenadaY)) {
                                            agregado = true;
                                        } else {
                                            vista.mostrarPosicionInvalida();
                                            coordenadaX = vista.inputPosicionX();
                                            coordenadaY = vista.inputPosicionY();
                                        }
                                    }
                                    Boolean colocada = juego.getTablero().colocarFicha(fichaColocar, coordenadaX, coordenadaY);
                                    if (colocada) {
                                        juego.getTurnoActual().getAtril().getFichas().remove(opcionFichaAtril - 1);
                                        fichaColocar.setEsTurnoActualTrue();
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
                                    Boolean sacado = false;
                                    while (!sacado) {
                                        if (juego.validarPosicionTablero(posicionSacarX, posicionSacarY)) {
                                            sacado = true;
                                        } else {
                                            vista.mostrarPosicionInvalida();
                                            posicionSacarX = vista.inputSacarPosicionX();
                                            posicionSacarY = vista.inputSacarPosicionY();
                                        }
                                    }
                                    Ficha fichaInspeccionada = juego.getTablero().inspeccionarFicha(posicionSacarX, posicionSacarY);
                                    if (fichaInspeccionada != null && fichaInspeccionada.getEsTurnoActual()) {
                                        juego.getTablero().sacarFicha(posicionSacarX, posicionSacarY);
                                        vista.mostrarTablero(juego.getTablero().getCasillas());
                                        juego.getTurnoActual().getAtril().agregarFicha(fichaInspeccionada);
                                        vista.notificacionAtrilActualizado();
                                        vista.mostrarAtril(juego.getTurnoActual().getAtril());
                                    } else {
                                        vista.notificacionFichaInexistente();
                                    }
                                    break;
                                case 4:
                                    juego.getTurnoActual().getAtril().completarAtril(juego.getMonton());
                                    Integer opcionPalabra = vista.inputPalabraFormada();
                                    Boolean palabraValida = false;
                                    while (!palabraValida) {
                                        if (juego.validarOpcionPalabra(opcionPalabra)) {
                                            palabraValida = true;
                                        } else {
                                            vista.mostrarOpcionInvalida();
                                            opcionPalabra = vista.inputPalabraFormada();
                                        }
                                    }
                                    if (opcionPalabra == 1) {
                                        vista.mostrarDondeEmpiezaYTerminaPalabra();
                                        Integer posicionXInicial = vista.inputPalabraPosicionInicialX();
                                        Integer posicionYInicial = vista.inputPalabraPosicionInicialY();
                                        Integer posicionXFinal = vista.inputPalabraPosicionFinalX();
                                        Integer posicionYFinal = vista.inputPalabraPosicionFinalY();
                                        Boolean posicionesValidas = false;
                                        while (!posicionesValidas) {
                                            if (juego.validarPosicionTableroPalabra(posicionXInicial, posicionYInicial, posicionXFinal, posicionYFinal)) {
                                                posicionesValidas = true;
                                            } else {
                                                vista.mostrarPosicionInvalida();
                                                posicionXInicial = vista.inputPalabraPosicionInicialX();
                                                posicionYInicial = vista.inputPalabraPosicionInicialY();
                                                posicionXFinal = vista.inputPalabraPosicionFinalX();
                                                posicionYFinal = vista.inputPalabraPosicionFinalY();
                                            }
                                        }
                                        Palabra palabraFormada = juego.crearPalabra(posicionXInicial, posicionYInicial, posicionXFinal, posicionYFinal);
                                        vista.mostrarPalabraFormada(juego.getTablero(), palabraFormada);
                                        String palabraBuscar = palabraFormada.calcularPalabra(juego.getTablero());
                                        if (juego.buscarPalabra(palabraBuscar)) {
                                            juego.reiniciarVecesConsecutivasSinTurno();
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
                                        juego.aumentarVecesConsecutivasSinTurno();
                                        vista.mostrarPalabraNoFormada();
                                    }
                                    juego.setFichasFalse();
                                    break;
                                case 5:
                                    terminado = true;
                                    juego.restarPuntajeFichasAtril();
                                    vista.mostrarRestoDelPuntaje();
                                    vista.mostrarGameover();
                                    vista.mostrarGanador(juego.calcularGanador());
                                    break;
                                default:
                                    vista.mostrarOpcionInvalida();
                                    break;
                            }
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