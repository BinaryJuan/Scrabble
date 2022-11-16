package ar.scrabble.unlu;

public class Tablero {
    // private final Integer DIMENSIONX = 15;
    // private final Integer DIMENSIONY = 15;
    private Casilla[][] casillas;

    public Tablero() {
        this.casillas = new Casilla[][] {
            {new Casilla(0, 0, Color.ROJO), new Casilla(0, 1, Color.NORMAL), new Casilla(0, 2, Color.NORMAL), new Casilla(0, 3, Color.AZULC), new Casilla(0, 4, Color.NORMAL), new Casilla(0, 5, Color.NORMAL), new Casilla(0, 6, Color.NORMAL), new Casilla(0, 7, Color.ROJO), new Casilla(0, 8, Color.NORMAL), new Casilla(0, 9, Color.NORMAL), new Casilla(0, 10, Color.NORMAL), new Casilla(0, 11, Color.AZULC), new Casilla(0, 12, Color.NORMAL), new Casilla(0, 13, Color.NORMAL), new Casilla(0, 14, Color.ROJO)},
            {new Casilla(1, 0, Color.NORMAL), new Casilla(1, 1, Color.ROSA), new Casilla(1, 2, Color.NORMAL), new Casilla(1, 3, Color.NORMAL), new Casilla(1, 4, Color.NORMAL), new Casilla(1, 5, Color.AZUL), new Casilla(1, 6, Color.NORMAL), new Casilla(1, 7, Color.NORMAL), new Casilla(1, 8, Color.NORMAL), new Casilla(1, 9, Color.AZUL), new Casilla(1, 10, Color.NORMAL), new Casilla(1, 11, Color.NORMAL), new Casilla(1, 12, Color.NORMAL), new Casilla(1, 13, Color.ROSA), new Casilla(1, 14, Color.NORMAL)},
            {new Casilla(2, 0, Color.NORMAL), new Casilla(2, 1, Color.NORMAL), new Casilla(2, 2, Color.ROSA), new Casilla(2, 3, Color.NORMAL), new Casilla(2, 4, Color.NORMAL), new Casilla(2, 5, Color.NORMAL), new Casilla(2, 6, Color.AZULC), new Casilla(2, 7, Color.NORMAL), new Casilla(2, 8, Color.AZULC), new Casilla(2, 9, Color.NORMAL), new Casilla(2, 10, Color.NORMAL), new Casilla(2, 11, Color.NORMAL), new Casilla(2, 12, Color.ROSA), new Casilla(2, 13, Color.NORMAL), new Casilla(2, 14, Color.NORMAL)},
            {new Casilla(3, 0, Color.AZULC), new Casilla(3, 1, Color.NORMAL), new Casilla(3, 2, Color.NORMAL), new Casilla(3, 3, Color.ROSA), new Casilla(3, 4, Color.NORMAL), new Casilla(3, 5, Color.NORMAL), new Casilla(3, 6, Color.NORMAL), new Casilla(3, 7, Color.AZULC), new Casilla(3, 8, Color.NORMAL), new Casilla(3, 9, Color.NORMAL), new Casilla(3, 10, Color.NORMAL), new Casilla(3, 11, Color.ROSA), new Casilla(3, 12, Color.NORMAL), new Casilla(3, 13, Color.NORMAL), new Casilla(3, 14, Color.AZULC)},
            {new Casilla(4, 0, Color.NORMAL), new Casilla(4, 1, Color.NORMAL), new Casilla(4, 2, Color.NORMAL), new Casilla(4, 3, Color.NORMAL), new Casilla(4, 4, Color.ROSA), new Casilla(4, 5, Color.NORMAL), new Casilla(4, 6, Color.NORMAL), new Casilla(4, 7, Color.NORMAL), new Casilla(4, 8, Color.NORMAL), new Casilla(4, 9, Color.NORMAL), new Casilla(4, 10, Color.ROSA), new Casilla(4, 11, Color.NORMAL), new Casilla(4, 12, Color.NORMAL), new Casilla(4, 13, Color.NORMAL), new Casilla(4, 14, Color.NORMAL)},
            {new Casilla(5, 0, Color.NORMAL), new Casilla(5, 1, Color.AZUL), new Casilla(5, 2, Color.NORMAL), new Casilla(5, 3, Color.NORMAL), new Casilla(5, 4, Color.NORMAL), new Casilla(5, 5, Color.AZUL), new Casilla(5, 6, Color.NORMAL), new Casilla(5, 7, Color.NORMAL), new Casilla(5, 8, Color.NORMAL), new Casilla(5, 9, Color.AZUL), new Casilla(5, 10, Color.NORMAL), new Casilla(5, 11, Color.NORMAL), new Casilla(5, 12, Color.NORMAL), new Casilla(5, 13, Color.AZUL), new Casilla(5, 14, Color.NORMAL)},
            {new Casilla(6, 0, Color.NORMAL), new Casilla(6, 1, Color.NORMAL), new Casilla(6, 2, Color.AZULC), new Casilla(6, 3, Color.NORMAL), new Casilla(6, 4, Color.NORMAL), new Casilla(6, 5, Color.NORMAL), new Casilla(6, 6, Color.AZULC), new Casilla(6, 7, Color.NORMAL), new Casilla(6, 8, Color.AZULC), new Casilla(6, 9, Color.NORMAL), new Casilla(6, 10, Color.NORMAL), new Casilla(6, 11, Color.NORMAL), new Casilla(6, 12, Color.AZULC), new Casilla(6, 13, Color.NORMAL), new Casilla(6, 14, Color.NORMAL)},
            {new Casilla(7, 0, Color.ROJO), new Casilla(7, 1, Color.NORMAL), new Casilla(7, 2, Color.NORMAL), new Casilla(7, 3, Color.AZULC), new Casilla(7, 4, Color.NORMAL), new Casilla(7, 5, Color.NORMAL), new Casilla(7, 6, Color.NORMAL), new Casilla(7, 7, Color.ROSA), new Casilla(7, 8, Color.NORMAL), new Casilla(7, 9, Color.NORMAL), new Casilla(7, 10, Color.NORMAL), new Casilla(7, 11, Color.AZULC), new Casilla(7, 12, Color.NORMAL), new Casilla(7, 13, Color.NORMAL), new Casilla(7, 14, Color.ROJO)},
            {new Casilla(8, 0, Color.NORMAL), new Casilla(8, 1, Color.NORMAL), new Casilla(8, 2, Color.AZULC), new Casilla(8, 3, Color.NORMAL), new Casilla(8, 4, Color.NORMAL), new Casilla(8, 5, Color.NORMAL), new Casilla(8, 6, Color.AZULC), new Casilla(8, 7, Color.NORMAL), new Casilla(8, 8, Color.AZULC), new Casilla(8, 9, Color.NORMAL), new Casilla(8, 10, Color.NORMAL), new Casilla(8, 11, Color.NORMAL), new Casilla(8, 12, Color.AZULC), new Casilla(8, 13, Color.NORMAL), new Casilla(8, 14, Color.NORMAL)},
            {new Casilla(9, 0, Color.NORMAL), new Casilla(9, 1, Color.AZUL), new Casilla(9, 2, Color.NORMAL), new Casilla(9, 3, Color.NORMAL), new Casilla(9, 4, Color.NORMAL), new Casilla(9, 5, Color.AZUL), new Casilla(9, 6, Color.NORMAL), new Casilla(9, 7, Color.NORMAL), new Casilla(9, 8, Color.NORMAL), new Casilla(9, 9, Color.AZUL), new Casilla(9, 10, Color.NORMAL), new Casilla(9, 11, Color.NORMAL), new Casilla(9, 12, Color.NORMAL), new Casilla(9, 13, Color.AZUL), new Casilla(9, 14, Color.NORMAL)},
            {new Casilla(10, 0, Color.NORMAL), new Casilla(10, 1, Color.NORMAL), new Casilla(10, 2, Color.NORMAL), new Casilla(10, 3, Color.NORMAL), new Casilla(10, 4, Color.ROSA), new Casilla(10, 5, Color.NORMAL), new Casilla(10, 6, Color.NORMAL), new Casilla(10, 7, Color.NORMAL), new Casilla(10, 8, Color.NORMAL), new Casilla(10, 9, Color.NORMAL), new Casilla(10, 10, Color.ROSA), new Casilla(10, 11, Color.NORMAL), new Casilla(10, 12, Color.NORMAL), new Casilla(10, 13, Color.NORMAL), new Casilla(10, 14, Color.NORMAL)},
            {new Casilla(11, 0, Color.AZULC), new Casilla(11, 1, Color.NORMAL), new Casilla(11, 2, Color.NORMAL), new Casilla(11, 3, Color.ROSA), new Casilla(11, 4, Color.NORMAL), new Casilla(11, 5, Color.NORMAL), new Casilla(11, 6, Color.NORMAL), new Casilla(11, 7, Color.AZULC), new Casilla(11, 8, Color.NORMAL), new Casilla(11, 9, Color.NORMAL), new Casilla(11, 10, Color.NORMAL), new Casilla(11, 11, Color.ROSA), new Casilla(11, 12, Color.NORMAL), new Casilla(11, 13, Color.NORMAL), new Casilla(11, 14, Color.AZULC)},
            {new Casilla(12, 0, Color.NORMAL), new Casilla(12, 1, Color.NORMAL), new Casilla(12, 2, Color.ROSA), new Casilla(12, 3, Color.NORMAL), new Casilla(12, 4, Color.NORMAL), new Casilla(12, 5, Color.NORMAL), new Casilla(12, 6, Color.AZULC), new Casilla(12, 7, Color.NORMAL), new Casilla(12, 8, Color.AZULC), new Casilla(12, 9, Color.NORMAL), new Casilla(12, 10, Color.NORMAL), new Casilla(12, 11, Color.NORMAL), new Casilla(12, 12, Color.ROSA), new Casilla(12, 13, Color.NORMAL), new Casilla(12, 14, Color.NORMAL)},
            {new Casilla(13, 0, Color.NORMAL), new Casilla(13, 1, Color.ROSA), new Casilla(13, 2, Color.NORMAL), new Casilla(13, 3, Color.NORMAL), new Casilla(13, 4, Color.NORMAL), new Casilla(13, 5, Color.AZUL), new Casilla(13, 6, Color.NORMAL), new Casilla(13, 7, Color.NORMAL), new Casilla(13, 8, Color.NORMAL), new Casilla(13, 9, Color.AZUL), new Casilla(13, 10, Color.NORMAL), new Casilla(13, 11, Color.NORMAL), new Casilla(13, 12, Color.NORMAL), new Casilla(13, 13, Color.ROSA), new Casilla(13, 14, Color.NORMAL)},
            {new Casilla(14, 0, Color.ROJO), new Casilla(14, 1, Color.NORMAL), new Casilla(14, 2, Color.NORMAL), new Casilla(14, 3, Color.AZULC), new Casilla(14, 4, Color.NORMAL), new Casilla(14, 5, Color.NORMAL), new Casilla(14, 6, Color.NORMAL), new Casilla(14, 7, Color.ROJO), new Casilla(14, 8, Color.NORMAL), new Casilla(14, 9, Color.NORMAL), new Casilla(14, 10, Color.NORMAL), new Casilla(14, 11, Color.AZULC), new Casilla(14, 12, Color.NORMAL), new Casilla(14, 13, Color.NORMAL), new Casilla(14, 14, Color.ROJO)},
        };
        // for (int i = 0; i < 15; i++) {
        //     for (int j = 0; j < 15; j++) {
        //         this.casillas[i][j] = new Casilla(i, j);
        //     }
        // }
    }

    // public void mostrarTablero() {
    //     for (int i = 0; i < 15; i++) {
    //         for (int j = 0; j < 15; j++) {
    //             this.casillas[i][j].mostrarCasillaConValorYLetra();
    //         }
    //         System.out.println();
    //     }
    // }

    public void mostrarTablero() {
        String tabla = "\u001B[33m       Y0   Y1   Y2   Y3   Y4   Y5   Y6   Y7   Y8   Y9   Y10  Y11  Y12  Y13  Y14  \u001B[0m";
        for (int i = 0; i < 15; i++) {
            tabla += "\n \u001B[33m X" + String.format("%1$2s", i) + " \u001B[0m";
            for (int j = 0; j < 15; j++) {
                tabla += this.casillas[i][j].devolverCasillaConValorYLetra();
            }
        }
        System.out.println(tabla);
        System.out.print("\u001B[0m");
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Boolean colocarFicha(Ficha ficha, Integer x, Integer y) {
        Ficha fichaAColocar = this.casillas[x][y].getFicha();
        if (fichaAColocar == null) {
            this.casillas[x][y].setFicha(ficha);
            return true;
        } else {
            System.out.println("La casilla ya esta ocupada");
            return false;
        }
    }

    public Ficha sacarFicha(Integer x, Integer y) {
        Ficha ficha = this.casillas[x][y].getFicha();
        if (ficha != null) {
            this.casillas[x][y].setFicha(null);
        }
        return ficha;
    }

    public void eliminarFicha(Integer fila, Integer columna) {
        this.casillas[fila][columna].setFicha(null);
    }

    public void generarTablero() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.casillas[i][j].setFicha(null);
            }
        }
    }
}
