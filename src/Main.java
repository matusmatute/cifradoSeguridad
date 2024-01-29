

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Opción para cifrar o descifrar
        System.out.print("Seleccione una opción (1 para cifrar, 2 para descifrar): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (opcion == 1) {
            // Cifrar
            System.out.print("Ingrese el texto plano a cifrar: ");
            String textoPlano = scanner.nextLine();

            // Llamar a la función de cifrado
            String criptograma = cifrarPorColumnas(textoPlano);

            // Mostrar resultados
            System.out.println("Arreglo de 6 columnas:");
            mostrarArreglo(criptograma, 6);
            System.out.println("Criptograma: " + criptograma);

            System.out.println("¿Desea desencriptar la frase? 1.- Si  2.- No");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1)
            {
                String textoPlanoEncriptado = descifrarPorColumnas(criptograma);

                // Mostrar resultados
                System.out.println("Arreglo de 6 columnas:");
                mostrarArreglo(textoPlanoEncriptado, 6);
                System.out.println("Texto plano: " + textoPlanoEncriptado);
            } else {
                System.out.println("Opción no válida");
            }


        } else if (opcion == 2) {
            // Descifrar
            System.out.print("Ingrese el criptograma a descifrar: ");
            String criptograma = scanner.nextLine();

            // Llamar a la función de descifrado
            String textoPlano = descifrarPorColumnas(criptograma);

            // Mostrar resultados
            System.out.println("Arreglo de 6 columnas:");
            mostrarArreglo(textoPlano, 6);
            System.out.println("Texto plano: " + textoPlano);
        } else {
            System.out.println("Opción no válida");
        }

        scanner.close();
    }

    // Función para cifrar por columnas
    private static String cifrarPorColumnas(String textoPlano) {
        int columnas = 6;
        int filas = (int) Math.ceil((double) textoPlano.length() / columnas);
        char[][] matriz = new char[filas][columnas];
        int indice = 0;

        // Llenar la matriz con el texto plano
        for (int col = 0; col < columnas; col++) {
            for (int fila = 0; fila < filas; fila++) {
                if (indice < textoPlano.length()) {
                    matriz[fila][col] = textoPlano.charAt(indice++);
                } else {
                    matriz[fila][col] = ' '; // Agregar espacios si es necesario
                }
            }
        }

        // Construir el criptograma a partir de la matriz
        StringBuilder criptograma = new StringBuilder();
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                criptograma.append(matriz[fila][col]);
            }
        }

        return criptograma.toString();
    }

    // Función para descifrar por columnas
    private static String descifrarPorColumnas(String criptograma) {
        int columnas = 6;
        int filas = criptograma.length() / columnas;
        char[][] matriz = new char[filas][columnas];
        int indice = 0;

        // Llenar la matriz con el criptograma
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                matriz[fila][col] = criptograma.charAt(indice++);
            }
        }

        // Construir el texto plano a partir de la matriz
        StringBuilder textoPlano = new StringBuilder();
        for (int col = 0; col < columnas; col++) {
            for (int fila = 0; fila < filas; fila++) {
                textoPlano.append(matriz[fila][col]);
            }
        }

        return textoPlano.toString();
    }

    // Función para mostrar el arreglo de 6 columnas
    private static void mostrarArreglo(String texto, int columnas) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i) + " ");
            if ((i + 1) % columnas == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}