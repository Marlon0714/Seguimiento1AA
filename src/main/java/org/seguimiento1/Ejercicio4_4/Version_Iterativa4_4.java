package org.seguimiento1.Ejercicio4_4;

/**
 * Esta clase contiene un método que verifica si cada par de palabras en la matriz están conectadas de manera iterativa.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Version_Iterativa4_4 {
    /**
     * Este método verifica si cada par de palabras en la matriz están conectadas de manera iterativa.
     * Dos palabras están conectadas si las últimas dos letras de la primera palabra son iguales a las primeras dos letras de la segunda palabra.
     *
     * @param palabras la matriz de palabras
     * @return verdadero si todas las palabras están conectadas, falso en caso contrario
     */
    public static boolean esEncadenamientoValidoIterativo(String[][] palabras) {
        for (int fila = 0; fila < palabras.length; fila++) {
            for (int col = 0; col < palabras[fila].length - 1; col++) {
                if (!palabrasConectadas(palabras[fila][col], palabras[fila][col + 1])) {
                    return false;
                }
            }
            // Verificación de la última palabra de la fila actual con la primera de la siguiente fila
            if (fila < palabras.length - 1 && !palabrasConectadas(palabras[fila][palabras[fila].length - 1], palabras[fila + 1][0])) {
                return false;
            }
        }
        return true;
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
        // Verificación especial para palabras de una sola sílaba
        if (p1.length() == 1) {
            return p1.equalsIgnoreCase(p2.substring(0, 1));
        }
        if (p2.length() == 1) {
            return p1.substring(p1.length() - 1).equalsIgnoreCase(p2);
        }
        // Verificación para palabras de más de una sílaba
        return p1.substring(p1.length() - 2).equalsIgnoreCase(p2.substring(0, 2));
    }
}