package org.seguimiento1.Ejercicio4_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene un método que encuentra las posiciones en la matriz donde las dos palabras son similares de manera iterativa.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Iterativa4_3 {
    /**
     * Este método encuentra las posiciones en la matriz donde las dos palabras son similares.
     * Dos palabras son similares si tienen la misma longitud y contienen los mismos caracteres.
     *
     * @param matriz la matriz de pares de palabras
     * @return una lista de posiciones donde las palabras son similares
     */
    public static List<Integer> encontrarPalabrasSimilaresIterativo(String[][] matriz) {
        List<Integer> posicionesSimilares = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            if (sonPalabrasSimilares(matriz[i][0], matriz[i][1])) {
                posicionesSimilares.add(i);
            }
        }
        return posicionesSimilares;
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
        for (char c : p1.toCharArray()) {
            if (!p2.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}