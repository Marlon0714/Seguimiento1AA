package org.seguimiento1.Ejercicio4_5;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene un método que encuentra los números polidivisibles en la matriz de manera iterativa.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Iterativa4_5 {
    /**
     * Este método encuentra los números polidivisibles en la matriz de manera iterativa.
     * Un número es polidivisible si, para cada dígito en la posición i contando desde la izquierda (comenzando desde 1),
     * el número formado por los primeros i dígitos es divisible por i.
     *
     * @param matriz la matriz de números
     * @return una lista de números polidivisibles
     */
    public static List<Integer> encontrarPolidivisiblesIterativo(int[][] matriz) {
        List<Integer> polidivisibles = new ArrayList<>();
        for (int[] fila : matriz) {
            for (int num : fila) {
                if (esPolidivisible(num)) {
                    polidivisibles.add(num);
                }
            }
        }
        return polidivisibles;
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
        String numero = String.valueOf(num);
        for (int i = 1; i <= numero.length(); i++) {
            if (Integer.parseInt(numero.substring(0, i)) % i != 0) {
                return false;
            }
        }
        return true;
    }
}