package org.seguimiento1.Ejercicio4_2;

/**
 * Esta clase contiene un método que encuentra el multiplicador más pequeño para cada número en la matriz que lo convierte en un cuadrado perfecto.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Iterativa4_2 {
    /**
     * Este método encuentra el multiplicador más pequeño para cada número en la matriz que lo convierte en un cuadrado perfecto.
     *
     * @param matriz la matriz de números enteros
     * @return una matriz de multiplicadores
     */
    public static int[][] encontrarMultiplicadorParaCuadradoPerfectoIterativo(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] resultado = new int[filas][columnas];

        // Recorremos cada celda de la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Encontramos el multiplicador para el cuadrado perfecto y lo almacenamos en la matriz de resultados
                resultado[i][j] = multiplicadorParaCuadradoPerfecto(matriz[i][j]);
            }
        }
        return resultado;
    }

    /**
     * Este método encuentra el multiplicador más pequeño que convierte un número en un cuadrado perfecto.
     *
     * @param num el número para el cual encontrar el multiplicador
     * @return el multiplicador más pequeño que convierte el número en un cuadrado perfecto
     */
    private static int multiplicadorParaCuadradoPerfecto(int num) {
        // Recorremos los números desde 1 hasta el número dado
        for (int i = 1; i <= num; i++) {
            // Si el producto del número y el multiplicador es un cuadrado perfecto, devolvemos el multiplicador
            if (esCuadradoPerfecto(num * i)) {
                return i;
            }
        }
        // Si no encontramos un multiplicador, devolvemos el número dado como caso por defecto
        return num;
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