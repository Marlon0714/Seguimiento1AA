package org.seguimiento1.Ejercicio4_1;

/**
 * Esta clase contiene un método para llenar una matriz cuadrada de tamaño n x n en un patrón espiral de manera iterativa.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Iterativa4_1 {
    /**
     * Este método llena una matriz cuadrada de tamaño n x n en un patrón espiral.
     * Comienza desde la esquina superior izquierda y se mueve hacia abajo, luego a la derecha,
     * hacia arriba y hacia la izquierda, repitiendo el patrón en espiral.
     *
     * @param n el tamaño de la matriz a llenar
     * @return la matriz llenada en un patrón espiral
     */
    public static int[][] llenarMatrizEnEspiralIterativo(int n) {
        // Inicializamos la matriz
        int[][] matriz = new int[n][n];
        int valor = 1;
        int minCol = 0;
        int maxCol = n - 1;
        int minRow = 0;
        int maxRow = n - 1;

        while (valor <= n * n) {
            // Llenar hacia abajo
            for (int i = minRow; i <= maxRow; i++) {
                matriz[i][minCol] = valor++;
            }
            minCol++;

            // Llenar hacia la derecha
            for (int i = minCol; i <= maxCol; i++) {
                matriz[maxRow][i] = valor++;
            }
            maxRow--;

            // Llenar hacia arriba
            for (int i = maxRow; i >= minRow; i--) {
                matriz[i][maxCol] = valor++;
            }
            maxCol--;

            // Llenar hacia la izquierda
            for (int i = maxCol; i >= minCol; i--) {
                matriz[minRow][i] = valor++;
            }
            minRow++;
        }
        return matriz;
    }
}
