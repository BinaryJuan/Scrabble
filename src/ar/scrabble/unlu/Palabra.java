package ar.scrabble.unlu;
public class Palabra {
    private Integer puntaje;
    private Integer comienzoX;
    private Integer comienzoY;
    private Integer finX;
    private Integer finY;

    // constructor para palabras verticales
    public Palabra(Integer puntaje, Integer comienzoX, Integer comienzoY, Integer finX, Integer finY) {
        this.puntaje = puntaje;
        this.comienzoX = comienzoX;
        this.comienzoY = comienzoY;
        this.finX = finX;
        this.finY = finY;
    }

    public String getPalabra() {
        return null;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getComienzoX() {
        return comienzoX;
    }

    public Integer getComienzoY() {
        return comienzoY;
    }

    public Integer getFinX() {
        return finX;
    }

    public Integer getFinY() {
        return finY;
    }

    public void setComienzoX(Integer comienzoX) {
        this.comienzoX = comienzoX;
    }

    public void setComienzoY(Integer comienzoY) {
        this.comienzoY = comienzoY;
    }

    public void setFinX(Integer finX) {
        this.finX = finX;
    }

    public void setFinY(Integer finY) {
        this.finY = finY;
    }

    // // metodo para recorrer el tablero desde comienzoX hasta finX y retornar un string
    // public String getPalabraHorizontal(Tablero tablero) {
    //     String palabra = "";
    //     for (int i = this.comienzoX; i <= this.finX; i++) {
    //         palabra += tablero.getCasillas()[i][this.comienzoY].getFicha().getLetra();
    //     }
    //     System.out.println(palabra);
    //     return palabra;
    // }

    // public String getPalabraVertical(Tablero tablero) {
    //     String palabra = "";
    //     for (int i = this.comienzoY; i <= this.finY; i++) {
    //         palabra += tablero.getCasillas()[this.comienzoX][i].getFicha().getLetra();
    //     }
    //     System.out.println(palabra);
    //     return palabra;
    // }

    public Boolean esHorizontal() {
        return this.comienzoY == this.finY;
    }

    public Boolean esVertical() {
        return this.comienzoX == this.finX;
    }

    // public Boolean esValida(Tablero tablero) {
    //     if (this.esHorizontal()) {
    //         return this.getPalabraHorizontal(tablero).length() >= 2;
    //     } else {
    //         return this.getPalabraVertical(tablero).length() >= 2;
    //     }
    // }

    // public Boolean esValida(Tablero tablero, Diccionario diccionario) {
    //     if (this.esHorizontal()) {
    //         return diccionario.existePalabra(this.getPalabraHorizontal(tablero));
    //     } else {
    //         return diccionario.existePalabra(this.getPalabraVertical(tablero));
    //     }
    // }

    // metodo para recorrer el tablero usando comienzoX y comienzoY y finX y finY y retornar un string con la palabra que se forma en el tablero
    public String calcularPalabra(Tablero tablero) {
        String palabra = "";
        if (this.esHorizontal()) {
            for (int i = this.comienzoX; i <= this.finX; i++) {
                if (!tablero.getCasillas()[i][this.comienzoY].estaVacia()) {
                    palabra += tablero.getCasillas()[i][this.comienzoY].getFicha().getLetra();
                } else {
                    palabra = "Palabra invalida";
                }
            }
        } else {
            for (int i = this.comienzoY; i <= this.finY; i++) {
                if (!tablero.getCasillas()[this.comienzoX][i].estaVacia()) {
                    palabra += tablero.getCasillas()[this.comienzoX][i].getFicha().getLetra();
                } else {
                    palabra = "Palabra invalida";
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
            for (int i = this.comienzoX; i <= this.finX; i++) {
                if (tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROSA || tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROJO) {
                    return true;
                }
            }
        } else {
            for (int i = this.comienzoY; i <= this.finY; i++) {
                if (tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROSA || tablero.getCasillas()[this.comienzoX][i].getColor() == Color.ROJO) {
                    return true;
                }
            }
        }
        return false;
    }

    public Color colorPalabraMultiplicada(Tablero tablero) {
        if (this.esHorizontal()) {
            for (int i = this.comienzoX; i <= this.finX; i++) {
                if (tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROSA || tablero.getCasillas()[i][this.comienzoY].getColor() == Color.ROJO) {
                    return tablero.getCasillas()[i][this.comienzoY].getColor();
                }
            }
        } else {
            for (int i = this.comienzoY; i <= this.finY; i++) {
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
            for (int i = this.comienzoX; i <= this.finX; i++) {
                if (!tablero.getCasillas()[i][this.comienzoY].estaVacia()) {
                    puntajePalabra += this.devolverValorSegunCasilla(tablero.getCasillas()[i][this.comienzoY]);
                } else {
                    palabraValida = false;
                }
            }
        } else {
            for (int i = this.comienzoY; i <= this.finY; i++) {
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
            System.out.println("La palabra no es valida");
            puntajePalabra = 0;
        }
        return puntajePalabra;
    }
}
