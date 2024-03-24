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

import java.util.List;

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
        int tamaño = 5;
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
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.2.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema42() {
        int[][] matriz = {{4, 8}, {12, 4}};
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
    }

    /**
     * Este método prueba la versión iterativa y recursiva del Problema 4.3.
     * Mide el tiempo de ejecución y muestra los resultados.
     */
    private static void testProblema43() {
        String[][] matriz = {{"cama", "acma"}, {"oso", "roso"}, {"tela", "late"}};
        long inicio = System.nanoTime();
        List<Integer> resultadoIterativo = Version_Iterativa4_3.encontrarPalabrasSimilaresIterativo(matriz);
        long fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.3 (Iterativo): " + (fin - inicio) + " ns");

        inicio = System.nanoTime();
        List<Integer> resultadoRecursivo = Version_Recursiva4_3.encontrarPalabrasSimilaresRecursivo(matriz);
        fin = System.nanoTime();
        System.out.println("Tiempo de ejecución del problema 4.3 (Recursivo): " + (fin - inicio) + " ns");

        // Impresión de los resultados
        System.out.println("Resultado Iterativo: " + resultadoIterativo);
        System.out.println("Resultado Recursivo: " + resultadoRecursivo);
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
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}