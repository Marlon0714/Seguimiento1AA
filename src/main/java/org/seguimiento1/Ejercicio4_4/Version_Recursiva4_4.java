package org.seguimiento1.Ejercicio4_4;

/**
 * Esta clase contiene un método que verifica si cada par de palabras en la matriz están conectadas de manera recursiva.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Recursiva4_4 {
    /**
     * Este método principal verifica si cada par de palabras en la matriz están conectadas de manera recursiva.
     * Dos palabras están conectadas si las últimas dos letras de la primera palabra son iguales a las primeras dos letras de la segunda palabra.
     *
     * @param palabras la matriz de palabras
     * @return verdadero si todas las palabras están conectadas, falso en caso contrario
     */
    public static boolean esEncadenamientoValidoRecursivo(String[][] palabras) {
        return verificarEncadenamiento(palabras, 0, 0);
    }

    /**
     * Este método verifica si dos palabras están conectadas.
     * Dos palabras están conectadas si las últimas dos letras de la primera palabra son iguales a las primeras dos letras de la segunda palabra.
     *
     * @param p1 la primera palabra
     * @param p2 la segunda palabra
     * @return verdadero si las palabras están conectadas, falso en caso contrario
     */
    private static boolean palabrasConectadas(String p1, String p2) {
        return p1.substring(p1.length() - 2).equals(p2.substring(0, 2));
    }

    /**
     * Este método auxiliar recursivo verifica si cada par de palabras en la matriz están conectadas.
     * Recorre la matriz de palabras de manera recursiva, verificando si las palabras en las posiciones actuales están conectadas.
     *
     * @param palabras la matriz de palabras
     * @param fila el índice de la fila actual
     * @param col el índice de la columna actual
     * @return verdadero si todas las palabras están conectadas, falso en caso contrario
     */
    private static boolean verificarEncadenamiento(String[][] palabras, int fila, int col) {
        if (fila == palabras.length - 1) {
            return true;
        }
        if (col == palabras[fila].length) {
            return verificarEncadenamiento(palabras, fila + 1, 0);
        }
        if (!palabrasConectadas(palabras[fila][col], palabras[fila + 1][col])) {
            return false;
        }
        return verificarEncadenamiento(palabras, fila, col + 1);
    }
}