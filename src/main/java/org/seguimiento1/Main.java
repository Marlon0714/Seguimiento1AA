package org.seguimiento1;

import org.seguimiento1.Ejercicio4_1.Version_Iterativa4_1;
import org.seguimiento1.Ejercicio4_1.Version_Recursiva4_1;
import org.seguimiento1.Ejercicio4_2.Version_Iterativa4_2;
import org.seguimiento1.Ejercicio4_2.Version_Recursiva4_2;
import org.seguimiento1.Ejercicio4_3.Version_Iterativa4_3;
import org.seguimiento1.Ejercicio4_3.Version_Recursiva4_3;
import org.seguimiento1.Ejercicio4_4.Version_Iterativa4_4;
import org.seguimiento1.Ejercicio4_4.Version_Recursiva4_4;
import org.seguimiento1.Ejercicio4_5.Version_Iterativa4_5;
import org.seguimiento1.Ejercicio4_5.Version_Recursiva4_5;
import org.segumiento1.Exceptions.PalabraInvalidaException;
import org.segumiento1.Exceptions.TamanoMatrizInvalidoException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Esta clase contiene métodos para probar los problemas 4.1 a 4.5.
 * Cada método prueba la versión iterativa y recursiva del problema correspondiente,
 * mide el tiempo de ejecución y muestra los resultados.
 *
 * @author Marlon Stiven Espinosa Joaqui
 * @author Juan Esteban Quintero Rodriguez
 * @author Jesus Santiago Ramon Ramos
 */
public class Main {
    public static void main(String[] args) {
        // Test y medición del tiempo para Problema 4.1
        System.out.println("----- Inicio del Problema 4.1 -----");
        testProblema41();
        System.out.println("----- Fin del Problema 4.1 -----\n");

        // Test y medición del tiempo para Problema 4.2
        System.out.println("----- Inicio del Problema 4.2 -----");
        testProblema42();
        System.out.println("----- Fin del Problema 4.2 -----\n");

        // Test y medición del tiempo para Problema 4.3
        System.out.println("----- Inicio del Problema 4.3 -----");
        testProblema43();
        System.out.println("----- Fin del Problema 4.3 -----\n");

        // Test y medición del tiempo para Problema 4.4
        System.out.println("----- Inicio del Problema 4.4 -----");
        testProblema44();
        System.out.println("----- Fin del Problema 4.4 -----\n");

        // Test y medición del tiempo para Problema 4.5
        System.out.println("----- Inicio del Problema 4.5 -----");
        testProblema45();
        System.out.println("----- Fin del Problema 4.5 -----\n");
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.1.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema41() {
        int tamaño = obtenerTamanoMatriz();

        try {
            long inicio = System.nanoTime();
            int[][] resultadoIterativo = Version_Iterativa4_1.llenarMatrizEnEspiralIterativo(tamaño);
            long fin = System.nanoTime();
            System.out.println("Tiempo de ejecución del problema 4.1 (Iterativo): " + (fin - inicio) + " ns");

            int[][] matrizRecursiva = new int[tamaño][tamaño];
            inicio = System.nanoTime();
            Version_Recursiva4_1.llenarMatrizEnEspiralRecursivo(matrizRecursiva, 1, 0, tamaño - 1, 0, tamaño - 1);
            fin = System.nanoTime();
            System.out.println("Tiempo de ejecución del problema 4.1 (Recursivo): " + (fin - inicio) + " ns");

            // Impresión de los resultados
            System.out.println("Resultado Iterativo:");
            imprimirMatriz(resultadoIterativo);

            System.out.println("Resultado Recursivo:");
            imprimirMatriz(matrizRecursiva);
        } catch (Exception e) {
            System.err.println("Error en la ejecución del programa: " + e.getMessage());
        }
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.2.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema42() {
        int n = obtenerTamanoMatriz(); // tamaño de la matriz

        try {
            int[][] matriz = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double valor = Math.random() + 1;
                    int valorEntero = (int) (valor * 5);
                    matriz[i][j] = valorEntero; // Matriz aleatoria de prueba
                    // matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese valores a la matriz")); // En caso de que el usuario quiera llenar la matriz
                }
            }

            // Mostrar la matriz de prueba de forma alineada
            System.out.println("Matriz ingresada de prueba:");
            imprimirMatriz(matriz); 

            long inicio = System.nanoTime();
            int[][] resultadoIterativo = Version_Iterativa4_2.encontrarMultiplicadorParaCuadradoPerfectoIterativo(matriz);
            long fin = System.nanoTime();
            System.out.println("Tiempo de ejecución del problema 4.2 (Iterativo): " + (fin - inicio) + " ns");

            inicio = System.nanoTime();
            int[][] resultadoRecursivo = Version_Recursiva4_2.encontrarMultiplicadorParaCuadradoPerfectoRecursivo(matriz);
            fin = System.nanoTime();
            System.out.println("Tiempo de ejecución del problema 4.2 (Recursivo): " + (fin - inicio) + " ns");

            // Impresión de los resultados
            System.out.println("Resultado Iterativo:");
            imprimirMatriz(resultadoIterativo);

            System.out.println("Resultado Recursivo:");
            imprimirMatriz(resultadoRecursivo);
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.3.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema43() {
        int n = obtenerTamanoMatriz(); // Número de filas de la matriz
        String[][] matriz = new String[n][2]; 

        // Solicitar al usuario que ingrese las palabras para cada fila de la matriz
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese la palabra para la fila " + (i + 1) + "\n" + "Palabras con la letra 'ñ' y tildes '´' no están permitidas");
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Por favor, escribe la palabra para la columna 1: ");
                String palabra1 = scanner.next();
                if (!palabra1.matches("[a-zA-Z]+") || palabra1.length() < 3 || palabra1.contains(" ") || palabra1.contains("ñ")) {
                    throw new PalabraInvalidaException("Error: La palabra no debe contener números y al menos tres caracteres.");
                }

                System.out.print("Por favor, escribe la palabra para la columna 2: ");
                String palabra2 = scanner.next();
                if (!palabra2.matches("[a-zA-Z]+") || palabra2.length() < 3 || palabra2.contains(" ") || palabra2.contains("ñ")) {
                    throw new PalabraInvalidaException("Error: La palabra no debe contener números y al menos tres caracteres.");
                }

                matriz[i][0] = palabra1;
                matriz[i][1] = palabra2;
            } catch (PalabraInvalidaException e) {
                System.err.println(e.getMessage());
                i--; // Repetir la misma fila si se produce un error
            }
        }
        imprimirMatrizCadena(matriz);
        long inicio = System.nanoTime();
        List<Integer> resultadoIterativo = Version_Iterativa4_3.encontrarPalabrasSimilaresIterativo(matriz);
        long fin = System.nanoTime();
        System.out.println("\n"+"Tiempo de ejecución del problema 4.3 (Iterativo): " + (fin - inicio) + " ns");
        inicio = System.nanoTime();
        List<Integer> resultadoRecursivo = Version_Recursiva4_3.encontrarPalabrasSimilaresRecursivo(matriz);
        fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.3 (Recursivo): " + (fin - inicio) + " ns");
        // Verificar si ninguna palabra es igual a otra en la matriz
        if(resultadoIterativo.isEmpty() && resultadoRecursivo.isEmpty()) {
            System.out.println("La matriz está vacía, ninguna palabra es igual a otra.");
        } else {
            // Impresión de los resultados
            System.out.println("Resultado Iterativo: \n"
                    + "las palabras con las mismas letras y el mismo tamaño se encuentran en la posición " + resultadoIterativo
                    + " de la matriz");
            System.out.println("Resultado Recursivo: \n" 
                    + "las palabras con las mismas letras y el mismo tamaño se encuentran en la posición " + resultadoRecursivo
                    + " de la matriz");
        }
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.4.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema44() {
        String[][] matriz = {{"Sien", "encima", "mapa"}, {"Pata", "tapa", "papa"}, {"Pato", "toma", "mama"}};
        long inicio = System.nanoTime();
        boolean resultadoIterativo = Version_Iterativa4_4.esEncadenamientoValidoIterativo(matriz);
        long fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.4 (Iterativo): " + (fin - inicio) + " ns");

        inicio = System.nanoTime();
        boolean resultadoRecursivo = Version_Recursiva4_4.esEncadenamientoValidoRecursivo(matriz);
        fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.4 (Recursivo): " + (fin - inicio) + " ns");

        // Impresión de los resultados
        System.out.println("Resultado Iterativo: " + resultadoIterativo);
        System.out.println("Resultado Recursivo: " + resultadoRecursivo);
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.5.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema45() {
        int[][] matriz = {{2016, 4233}, {1024, 123456}};
        long inicio = System.nanoTime();
        List<Integer> resultadoIterativo = Version_Iterativa4_5.encontrarPolidivisiblesIterativo(matriz);
        long fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.5 (Iterativo): " + (fin - inicio) + " ns");

        inicio = System.nanoTime();
        List<Integer> resultadoRecursivo = Version_Recursiva4_5.encontrarPolidivisiblesRecursivo(matriz);
        fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.5 (Recursivo): " + (fin - inicio) + " ns");

        // Impresión de los resultados
        System.out.println("Resultado Iterativo: " + resultadoIterativo);
        System.out.println("Resultado Recursivo: " + resultadoRecursivo);
    }

    /**
     * Este método imprime una matriz de enteros.
     * @param matriz la matriz a imprimir
     */
    private static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%5d", matriz[i][j]); // Ajusta el ancho de cada elemento según tus necesidades
            }
            System.out.println(); // Salto de línea para imprimir la siguiente fila
        }
    } 
    
    /*
     * Este método pide al usuario el tamaño que quiere para las matrices
     * y maneja los tipos de excepciones que pueden existir al ingresar algún valor
     */
    private static int obtenerTamanoMatriz() {
        int tamaño = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese el tamaño n de la matriz");

                if (input == null) {
                    throw new TamanoMatrizInvalidoException("No se ingresó ningún valor. Por favor, intente de nuevo.");
                }

                input = input.trim();
                if (input.isEmpty() || !input.matches("([2-9]|[12]\\d|30)")) { // Modificación en la expresión regular para aceptar valores entre 2 y 30
                    throw new TamanoMatrizInvalidoException("Ingrese un número entero válido para el tamaño de la matriz entre 2 y 30.");
                }

                tamaño = Integer.parseInt(input);
                entradaValida = true;
            } catch (TamanoMatrizInvalidoException e) {
                System.err.println("Error en el tamaño de la matriz: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Error: Ingrese un número entero válido para el tamaño de la matriz.");
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
            }
        }

        return tamaño;
    }


    
    private static void imprimirMatrizCadena(String[][] matriz) {
        System.out.println("Matriz ingresada:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%-15s", matriz[i][j]); // Ajusta el ancho de cada elemento según tus necesidades
            }
            System.out.println(); // Salto de línea para imprimir la siguiente fila
        }
    }
}