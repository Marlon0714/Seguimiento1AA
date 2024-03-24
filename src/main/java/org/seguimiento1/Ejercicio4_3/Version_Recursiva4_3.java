package org.seguimiento1.Ejercicio4_3;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase contiene un método que encuentra las posiciones en la matriz donde las dos palabras son similares de manera recursiva.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Recursiva4_3 {
    /**
     * Este método principal encuentra las posiciones en la matriz donde las dos palabras son similares de manera recursiva.
     * Dos palabras son similares si tienen la misma longitud y contienen los mismos caracteres.
     *
     * @param matriz la matriz de pares de palabras
     * @return una lista de posiciones donde las palabras son similares
     */
    public static List<Integer> encontrarPalabrasSimilaresRecursivo(String[][] matriz) {
        return encontrarSimilaresAux(matriz, 0, new ArrayList<>());
    }

    /**
     * Este método auxiliar recorre las filas de la matriz de manera recursiva.
     *
     * @param matriz la matriz de pares de palabras
     * @param fila el índice de la fila actual
     * @param posicionesSimilares la lista de posiciones donde las palabras son similares
     * @return una lista de posiciones donde las palabras son similares
     */
    private static List<Integer> encontrarSimilaresAux(String[][] matriz, int fila, List<Integer> posicionesSimilares) {
        if (fila == matriz.length) {
            return posicionesSimilares;
        }
        if (sonPalabrasSimilares(matriz[fila][0], matriz[fila][1])) {
            posicionesSimilares.add(fila);
        }
        return encontrarSimilaresAux(matriz, fila + 1, posicionesSimilares);
    }

    /**
     * Este método verifica si dos palabras son similares.
     * Dos palabras son similares si tienen la misma longitud y contienen los mismos caracteres.
     *
     * @param p1 la primera palabra
     * @param p2 la segunda palabra
     * @return verdadero si las palabras son similares, falso en caso contrario
     */
    private static boolean sonPalabrasSimilares(String p1, String p2) {
        if (p1.length() != p2.length()) {
            return false;
        }
        return tieneTodasLasLetras(p1, p2, 0);
    }

    /**
     * Este método auxiliar recursivo verifica si p2 contiene todas las letras de p1.
     *
     * @param p1 la primera palabra
     * @param p2 la segunda palabra
     * @param index el índice actual en la primera palabra
     * @return verdadero si p2 contiene todas las letras de p1, falso en caso contrario
     */
    private static boolean tieneTodasLasLetras(String p1, String p2, int index) {
        if (index == p1.length()) {
            return true;
        }
        if (!p2.contains(p1.substring(index, index + 1))) {
            return false;
        }
        return tieneTodasLasLetras(p1, p2, index + 1);
    }
}