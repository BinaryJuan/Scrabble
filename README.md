# Scrabble
##### _Autor: Dante Terranova_

###
###
### Descripción
Proyecto para la Universidad Nacional de Luján (POO). Consiste en desarrollar un videojuego de mesa usando Java.
- Lenguaje: Java
- Interfaz gráfica: consola
- Patrón de diseño: MVC

### ¿Cómo jugar?
El objetivo del juego es obtener la mayor cantidad de puntos al formar palabras en un tablero que se conecten a las palabras (o no) creadas por los otros jugadores. Para jugar Scrabble, necesitarás al menos otro jugador (de 2 a 4 jugadores).
1. Una vez que esté el tablero, el montón y los atriles con fichas, cada jugador agarrará una ficha del montón, y la que esté más cerca de la letra "A" será el que tenga el primer turno.
2. Ahora que el jugador tiene el turno, deberá decidir si quiere:
    - Sacar ficha del montón: en caso de que el jugador no se de cuenta de qué palabra puede generar, no pueda, o incluso si no quiere, puede pasar el turno y agarrar una ficha del montón.
    - Colocar ficha en el tablero: a través de coordenadas en el tablero se selecciona la ficha que se quiere colocar/agregar al tablero y se saca del atril.
    - Sacar ficha del tablero: a través de coordenadas en el tablero se selecciona la ficha que se quiere eliminar y devolver al atril.
    - Terminar turno: una vez que el jugador, ya sea porque no puede o no quiere generar una palabra nueva, o si formó una, esta opción permite pasar el turno y previamente preguntarle al jugador si formó o no una palabra. Si eligió la opción afirmativa, el jugador deberá seleccionar dónde empieza y termina su palabra a través de coordenadas en el tablero.
    - Salir del juego: automáticamente termina el juego y se muestra el ganador.

### Reglas generales
- El objetivo es generar la mayor cantidad de puntos.
- Cada jugador toma 7 fichas en sus atriles al comenzar el juego. Cuando termina el turno, el atril debe reponer las fichas que gastó hasta llegar a 7 (salvo que no haya gastado).
- Cada jugador podrá formar solo una palabra por turno.
- Suma de puntos: considerando la cifra de valor que cada letra tiene (las palabras valen la suma de todas las cifras de valor de cada letra). Al terminar la partida, los jugadores deben restar de su puntaje los valores de las letras sobrantes del atril.
- Casillas del tablero: azul cielo duplica el valor de la letra; azul triplica el valor de la letra; rosa duplica el valor de la palabra que cruce sobre ella; roja triplica el valor de la palabra que cruce sobre ella.
- En esta versión se eliminaron los comodines.
- El juego termina cuando: un jugador gasta todas las fichas de su atril y ya no hay fichas en el monton; cuando ningún jugador puede colocar más palabras en el tablero y han pasado 2 veces consecutivas.
 
![](https://media.istockphoto.com/id/502558269/es/foto/letras-de-scrabble.jpg?s=612x612&w=0&k=20&c=GOwivnVneQm1epYLWneIFEFjojL2jqXm8p2Uu_doyLk=)

### UML
