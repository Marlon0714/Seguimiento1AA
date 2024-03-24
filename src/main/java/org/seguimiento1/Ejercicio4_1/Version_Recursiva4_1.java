package org.seguimiento1.Ejercicio4_1;

/**
 * Esta clase contiene un método que llena una matriz cuadrada de tamaño n x n en un patrón espiral de manera recursiva.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Recursiva4_1 {
    /**
     * Este método llena una matriz cuadrada de tamaño n x n en un patrón espiral de manera recursiva.
     * Comienza desde la esquina superior izquierda y se mueve hacia abajo, a la derecha, hacia arriba y
     * a la izquierda, repitiendo el patrón en espiral.
     *
     * @param matriz la matriz a llenar
     * @param valor el valor inicial para llenar la matriz
     * @param minCol el índice de la columna mínima a llenar
     * @param maxCol el índice de la columna máxima a llenar
     * @param minRow el índice de la fila mínima a llenar
     * @param maxRow el índice de la fila máxima a llenar
     */
    public static void llenarMatrizEnEspiralRecursivo(int[][] matriz, int valor, int minCol, int maxCol, int minRow, int maxRow) {
        if (valor > matriz.length * matriz.length)
            return;

        // Llenar hacia abajo
        for (int i = minRow; i <= maxRow; i++) {
            matriz[i][minCol] = valor++;
        }

        // Llenar hacia la derecha
        for (int i = minCol + 1; i <= maxCol; i++) {
            matriz[maxRow][i] = valor++;
        }

        // Llenar hacia arriba
        for (int i = maxRow - 1; i >= minRow; i--) {
            matriz[i][maxCol] = valor++;
        }

        // Llenar hacia la izquierda
        for (int i = maxCol - 1; i > minCol; i--) {
            matriz[minRow][i] = valor++;
        }

        llenarMatrizEnEspiralRecursivo(matriz, valor, minCol + 1, maxCol - 1, minRow + 1, maxRow - 1);
    }
}