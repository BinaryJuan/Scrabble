package ar.edu.unlu.poo.scrabble.model;
public class Palabra {
    private Integer puntaje;
    private Integer comienzoX;
    private Integer comienzoY;
    private Integer finX;
    private Integer finY;

    public Palabra(Integer puntaje, Integer comienzoX, Integer comienzoY, Integer finX, Integer finY) {
        this.puntaje = puntaje;
        this.comienzoX = comienzoX;
        this.comienzoY = comienzoY;
        this.finX = finX;
        this.finY = finY;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Boolean esHorizontal() {
        return this.comienzoY == this.finY;
    }

    public Boolean esVertical() {
        return this.comienzoX == this.finX;
    }

    public String calcularPalabra(Tablero tablero) {
        String palabra = "";
        if (this.esHorizontal()) {
            for (Integer i = this.comienzoX; i <= this.finX; i++) {
                if (!tablero.getCasillas()[i][this.comienzoY].estaVacia()) {
                    palabra += tablero.getCasillas()[i][this.comienzoY].getFicha().getLetraSimbolo();
                } else {
                    palabra = "Palabra inválida o está vacía";
                }
            }
        } else {
            for (Integer i = this.comienzoY; i <= this.finY; i++) {
                if (!tablero.getCasillas()[this.comienzoX][i].estaVacia()) {
                    palabra += tablero.getCasillas()[this.comienzoX][i].getFicha().getLetraSimbolo();
                } else {
                    palabra = "Palabra inválida o está vacía";
                }
            }
        }
        return palabra;
    }


    public Integer devolverValorSegunCasilla(Casilla casilla) {
        Integer valorFicha = casilla.getFicha().getValor();
        switch(casilla.getColor()) {
            case NORMAL:
                return valorFicha;
            case AZULC:
                return valorFicha * 2;
            case AZUL:
                return valorFicha * 3;
            default:
                return valorFicha;
        }
    }

    public Boolean esLaPalabraMultiplicada(Tablero tablero) {
        if (this.esHorizontal()) {
            for (Integer i = this.comienzoX; i <= this.finX; i++) {
                if (tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROSA || tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROJO) {
                    return true;
                }
            }
        } else {
            for (Integer i = this.comienzoY; i <= this.finY; i++) {
                if (tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROSA || tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROJO) {
                    return true;
                }
            }
        }
        return false;
    }

    public Color colorPalabraMultiplicada(Tablero tablero) {
        if (this.esHorizontal()) {
            for (Integer i = this.comienzoX; i <= this.finX; i++) {
                if (tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROSA || tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROJO) {
                    return tablero.getCasillas()[i][this.comienzoY].getColor();
                }
            }
        } else {
            for (Integer i = this.comienzoY; i <= this.finY; i++) {
                if (tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROSA || tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROJO) {
                    return tablero.getCasillas()[this.comienzoX][i].getColor();
                }
            }
        }
        return Color.NORMAL;
    }

    public Integer calcularPuntajePalabra(Tablero tablero) {
        Integer puntajePalabra = 0;
        Boolean palabraValida = true;
        if (this.esHorizontal()) {
            for (Integer i = this.comienzoX; i <= this.finX; i++) {
                if (!tablero.getCasillas()[i][this.comienzoY].estaVacia()) {
                    puntajePalabra += this.devolverValorSegunCasilla(tablero.getCasillas()[i][this.comienzoY]);
                } else {
                    palabraValida = false;
                }
            }
        } else {
            for (Integer i = this.comienzoY; i <= this.finY; i++) {
                if (!tablero.getCasillas()[this.comienzoX][i].estaVacia()) {
                    puntajePalabra += this.devolverValorSegunCasilla(tablero.getCasillas()[this.comienzoX][i]);
                } else {
                    palabraValida = false;
                }
            }
        }

        if (palabraValida) {
            if (this.esLaPalabraMultiplicada(tablero)) {
                Color colorEncontrado = this.colorPalabraMultiplicada(tablero);
                if (colorEncontrado == Color.ROSA) {
                    puntajePalabra *= 2;
                } else {
                    puntajePalabra *= 3;
                }
            }
        } else {
            System.out.println("La palabra no es válida");
            puntajePalabra = 0;
        }
        return puntajePalabra;
    }
}