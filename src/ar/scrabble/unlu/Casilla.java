package ar.scrabble.unlu;
enum Color {
    NORMAL,
    AZULC,
    AZUL,
    ROSA,
    ROJO
}

public class Casilla {
    private Ficha ficha;
    private Color color;
    private Integer coordenadaX;
    private Integer coordenadaY;
    public Casilla(Integer coordenadaX, Integer coordenadaY, Color color) {
        this.ficha = null;
        this.color = color;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    // public Color elegirColor() {
    //     int color = new Random().nextInt(Color.values().length);
    //     return Color.values()[color];
    // }

    public Color getColor() {
        return color;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Boolean estaVacia() {
        return this.ficha == null;
    }

    public String colorConsola() {
        switch (this.color) {
            case NORMAL:
                return "\u001B[0m";
            case AZULC:
                return "\u001B[36m";
            case AZUL:
                return "\u001B[34m";
            case ROSA:
                return "\u001B[35m";
            case ROJO:
                return "\u001B[31m";
            default:
                return "\u001B[0m";
        }
    }

    // public void mostrarCasillaConValorYLetra() {
    //     if (this.estaVacia()) {
    //         System.out.print(this.colorConsola() + " [" + "X:" + this.coordenadaX + " Y:" + this.coordenadaY + "] ");
    //     } else {
    //         System.out.print(this.colorConsola() + " [" + this.ficha.getLetra() + this.ficha.getValor() + "]");
    //     }
    //     System.out.print("\u001B[0m");
    // }

    public String devolverCasillaConValorYLetra() {
        if (this.estaVacia()) {
            return this.colorConsola() + " [ ] ";
        } else {
            return this.colorConsola() + " [" + this.ficha.getLetra() + this.ficha.getValor() + "]";
        }
    }

    // public String transformarASuperindice(Ficha ficha) {
    //     Integer numero = ficha.getValor();
    //     String superindice = "";
    //     switch (numero) {
    //         case 0:
    //             superindice = "⁰";
    //             break;
    //         case 1:
    //             superindice = "¹";
    //             break;
    //         case 2:
    //             superindice = "²";
    //             break;
    //         case 3:
    //             superindice = "³";
    //             break;
    //         case 4:
    //             superindice = "⁴";
    //             break;
    //         case 5:
    //             superindice = "⁵";
    //             break;
    //         case 8:
    //             superindice = "⁸";
    //             break;
    //         case 10:
    //             superindice = "¹⁰";
    //             break;
    //         default:
    //             superindice = "⁰";
    //             break;
    //     }
    //     return superindice;
    // }


}
