package org.seguimiento1.Ejercicio4_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene un método que encuentra los números polidivisibles en la matriz de manera recursiva.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Recursiva4_5 {
    /**
     * Este método principal encuentra los números polidivisibles en la matriz de manera recursiva.
     * Un número es polidivisible si, para cada dígito en la posición i contando desde la izquierda (comenzando desde 1),
     * el número formado por los primeros i dígitos es divisible por i.
     *
     * @param matriz la matriz de números
     * @return una lista de números polidivisibles
     */
    public static List<Integer> encontrarPolidivisiblesRecursivo(int[][] matriz) {
        return encontrarPolidivisiblesAux(matriz, 0, 0, new ArrayList<>());
    }

    /**
     * Este método auxiliar recorre la matriz de números de manera recursiva.
     * Si el número en la posición actual es polidivisible, se añade a la lista de números polidivisibles.
     *
     * @param matriz la matriz de números
     * @param fila el índice de la fila actual
     * @param columna el índice de la columna actual
     * @param polidivisibles la lista de números polidivisibles
     * @return una lista de números polidivisibles
     */
    private static List<Integer> encontrarPolidivisiblesAux(int[][] matriz, int fila, int columna, List<Integer> polidivisibles) {
        if (fila == matriz.length) {
            return polidivisibles;
        }
        if (columna == matriz[fila].length) {
            return encontrarPolidivisiblesAux(matriz, fila + 1, 0, polidivisibles);
        }
        if (esPolidivisible(matriz[fila][columna])) {
            polidivisibles.add(matriz[fila][columna]);
        }
        return encontrarPolidivisiblesAux(matriz, fila, columna + 1, polidivisibles);
    }

    /**
     * Este método verifica si un número es polidivisible.
     * Un número es polidivisible si, para cada dígito en la posición i contando desde la izquierda (comenzando desde 1),
     * el número formado por los primeros i dígitos es divisible por i.
     *
     * @param num el número a verificar
     * @return verdadero si el número es polidivisible, falso en caso contrario
     */
    private static boolean esPolidivisible(int num) {
        return esPolidivisibleRecursivo(String.valueOf(num), 1);
    }

    /**
     * Este método auxiliar recursivo verifica si un número es polidivisible.
     * Recorre el número de manera recursiva, verificando si el número formado por los primeros i dígitos es divisible por i.
     *
     * @param numero el número a verificar como una cadena de caracteres
     * @param longitud la longitud del número a verificar
     * @return verdadero si el número es polidivisible, falso en caso contrario
     */
    private static boolean esPolidivisibleRecursivo(String numero, int longitud) {
        if (longitud > numero.length()) {
            return true;
        }
        int subNumero = Integer.parseInt(numero.substring(0, longitud));
        if (subNumero % longitud != 0) {
            return false;
        }
        return esPolidivisibleRecursivo(numero, longitud + 1);
    }
}