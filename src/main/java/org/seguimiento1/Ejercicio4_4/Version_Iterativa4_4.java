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
	    for (int i = 0; i < palabras.length - 1; i++) {
	        if (!palabrasConectadas(palabras[i][palabras[i].length - 1], palabras[i + 1][0])) {
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
	    String lastTwoLettersFirstWord = p1.substring(Math.max(p1.length() - 2, 0)); // Obtener las últimas dos letras de la primera palabra
	    String firstTwoLettersNextWord = p2.substring(0, Math.min(2, p2.length())); // Obtener las primeras dos letras de la siguiente palabra

	    return lastTwoLettersFirstWord.equals(firstTwoLettersNextWord);
	}


}