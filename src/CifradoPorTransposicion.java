import java.util.Scanner;

public class CifradoPorTransposicion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cifrar
        System.out.print("Ingrese el texto plano para cifrar: ");
        String textoPlano = scanner.nextLine();

        // Cifrar el texto
        char[][] matrizCifrada = cifrarPorTransposicion(textoPlano);

        // Mostrar la matriz cifrada
        System.out.println("\nMatriz Cifrada:");
        mostrarMatriz(matrizCifrada);

        // Mostrar el criptograma
        String criptograma = obtenerCriptograma(matrizCifrada);
        System.out.println("\nCriptograma: " + criptograma);

        // Descifrar
        System.out.print("\nIngrese el criptograma para descifrar: ");
        String criptoInput = scanner.nextLine();

        // Obtener y mostrar la matriz descifrada
        char[][] matrizDescifrada = obtenerMatrizDesdeCriptograma(criptoInput);
        System.out.println("\nMatriz Descifrada:");
        mostrarMatriz(matrizDescifrada);

        // Obtener y mostrar el texto plano
        String textoDescifrado = descifrarPorTransposicion(matrizDescifrada);
        System.out.println("\nTexto Plano Descifrado: " + textoDescifrado);

        scanner.close();
    }

    // Método para cifrar el texto por transposición horizontal
    private static char[][] cifrarPorTransposicion(String textoPlano) {
        int longitud = textoPlano.length();
        int numFilas = 6;
        int numColumnas = 6;

        char[][] matrizCifrada = new char[numFilas][numColumnas];
        int indice = 0;

        // Llenar la matriz de izquierda a derecha y de arriba hacia abajo
        for (int fila = 0; fila < numFilas; fila++) {
            for (int columna = 0; columna < numColumnas; columna++) {
                if (indice < longitud) {
                    matrizCifrada[fila][columna] = textoPlano.charAt(indice++);
                } else {
                    break;
                }
            }
        }

        // Llenar los espacios restantes con 'x' de derecha a izquierda y de abajo hacia arriba
        for (int fila = numFilas - 1; fila >= 0; fila--) {
            for (int columna = numColumnas - 1; columna >= 0; columna--) {
                if (matrizCifrada[fila][columna] == '\0') {
                    matrizCifrada[fila][columna] = 'x';
                }
            }
        }

        return matrizCifrada;
    }

    // Método para mostrar una matriz de caracteres
    private static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para obtener el criptograma a partir de la matriz cifrada
    private static String obtenerCriptograma(char[][] matrizCifrada) {
        StringBuilder criptograma = new StringBuilder();

        for (int columna = 0; columna < matrizCifrada[0].length; columna++) {
            for (int fila = 0; fila < matrizCifrada.length; fila++) {
                criptograma.append(matrizCifrada[fila][columna]);
            }
        }

        return criptograma.toString();
    }

    // Método para obtener la matriz descifrada a partir del criptograma
    private static char[][] obtenerMatrizDesdeCriptograma(String criptograma) {
        int longitud = criptograma.length();
        int numFilas = 6;
        int numColumnas = 6;

        char[][] matrizDescifrada = new char[numFilas][numColumnas];
        int indice = 0;

        for (int columna = 0; columna < numColumnas; columna++) {
            for (int fila = 0; fila < numFilas; fila++) {
                if (indice < longitud) {
                    matrizDescifrada[fila][columna] = criptograma.charAt(indice++);
                } else {
                    break;
                }
            }
        }

        return matrizDescifrada;
    }

    // Método para descifrar el texto por transposición
    private static String descifrarPorTransposicion(char[][] matrizDescifrada) {
        StringBuilder textoDescifrado = new StringBuilder();

        // Leer la matriz por filas (horizontalmente) para obtener el texto plano
        for (int fila = 0; fila < matrizDescifrada.length; fila++) {
            for (int columna = 0; columna < matrizDescifrada[fila].length; columna++) {
                if (matrizDescifrada[fila][columna] != 'x') {
                    textoDescifrado.append(matrizDescifrada[fila][columna]);
                }
            }
        }

        return textoDescifrado.toString();
    }
}
