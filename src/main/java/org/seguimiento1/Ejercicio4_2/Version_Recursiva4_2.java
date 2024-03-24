package org.seguimiento1.Ejercicio4_2;

/**
 * Esta clase contiene un método que encuentra el multiplicador más pequeño para cada número en la matriz que lo convierte en un cuadrado perfecto.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Recursiva4_2 {
    /**
     * Este método principal encuentra el multiplicador más pequeño para cada número en la matriz que lo convierte en un cuadrado perfecto de manera recursiva.
     *
     * @param matriz la matriz de números enteros
     * @return una matriz de multiplicadores
     */
    public static int[][] encontrarMultiplicadorParaCuadradoPerfectoRecursivo(int[][] matriz) {
        return encontrarMultiplicadorAux(matriz, 0, 0);
    }

    /**
     * Este método auxiliar recorre la matriz de manera recursiva.
     *
     * @param matriz la matriz de números enteros
     * @param fila el índice de la fila actual
     * @param col el índice de la columna actual
     * @return una matriz de multiplicadores
     */
    private static int[][] encontrarMultiplicadorAux(int[][] matriz, int fila, int col) {
        if (fila == matriz.length) {
            return matriz;
        }
        if (col == matriz[fila].length) {
            return encontrarMultiplicadorAux(matriz, fila + 1, 0);
        }
        matriz[fila][col] = multiplicadorParaCuadradoPerfecto(matriz[fila][col], 1);
        return encontrarMultiplicadorAux(matriz, fila, col + 1);
    }

    /**
     * Este método encuentra el multiplicador más pequeño que convierte un número en un cuadrado perfecto.
     *
     * @param num el número para el cual encontrar el multiplicador
     * @param multiplicador el multiplicador actual
     * @return el multiplicador más pequeño que convierte el número en un cuadrado perfecto
     */
    private static int multiplicadorParaCuadradoPerfecto(int num, int multiplicador) {
        if (esCuadradoPerfecto(num * multiplicador)) {
            return multiplicador;
        }
        return multiplicadorParaCuadradoPerfecto(num, multiplicador + 1);
    }

    /**
     * Este método verifica si un número es un cuadrado perfecto.
     *
     * @param num el número a verificar
     * @return verdadero si el número es un cuadrado perfecto, falso en caso contrario
     */
    private static boolean esCuadradoPerfecto(int num) {
        int raiz = (int) Math.sqrt(num);
        // Un número es un cuadrado perfecto si la raíz cuadrada del número, redondeada al entero más cercano, al cuadrado, es igual al número original
        return raiz * raiz == num;
    }
}