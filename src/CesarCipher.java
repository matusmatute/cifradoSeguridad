import java.util.Scanner;

public class CesarCipher {
    // Método para cifrar un mensaje utilizando el cifrado César con un desplazamiento dado
    public static String cifrar(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        System.out.println("\nMatriz de cifrado:");
        System.out.println("Texto Claro\tCriptograma");
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);

            // Verificar si el caracter es una letra
            if (Character.isLetter(caracter)) {
                // Obtener el código ASCII del caracter
                int codigoAscii = (int) caracter;

                // Determinar si el caracter es mayúscula o minúscula
                boolean esMayuscula = Character.isUpperCase(caracter);

                // Aplicar el desplazamiento
                codigoAscii += desplazamiento;

                // Ajustar el código ASCII si se sale del rango de letras
                if (esMayuscula) {
                    while (codigoAscii > 'Z') {
                        codigoAscii -= 26;
                    }
                } else {
                    while (codigoAscii > 'z') {
                        codigoAscii -= 26;
                    }
                }

                char criptogramaChar = (char) codigoAscii;
                resultado.append(criptogramaChar);

                // Imprimir la matriz de cifrado
                System.out.println(caracter + "\t\t" + criptogramaChar);
            } else {
                // Mantener los caracteres que no son letras sin modificar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    // Método para desencriptar un mensaje cifrado utilizando el cifrado César con un desplazamiento dado
    public static String descifrar(String mensajeCifrado, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        System.out.println("\nMatriz de descifrado:");
        System.out.println("Criptograma\tTexto Claro");
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char caracter = mensajeCifrado.charAt(i);

            // Verificar si el caracter es una letra
            if (Character.isLetter(caracter)) {
                // Obtener el código ASCII del caracter
                int codigoAscii = (int) caracter;

                // Determinar si el caracter es mayúscula o minúscula
                boolean esMayuscula = Character.isUpperCase(caracter);

                // Aplicar el desplazamiento
                codigoAscii -= desplazamiento;

                // Ajustar el código ASCII si se sale del rango de letras
                if (esMayuscula) {
                    while (codigoAscii < 'A') {
                        codigoAscii += 26;
                    }
                } else {
                    while (codigoAscii < 'a') {
                        codigoAscii += 26;
                    }
                }

                char textoClaroChar = (char) codigoAscii;
                resultado.append(textoClaroChar);

                // Imprimir la matriz de descifrado
                System.out.println(caracter + "\t\t" + textoClaroChar);
            } else {
                // Mantener los caracteres que no son letras sin modificar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la palabra a cifrar
        System.out.print("Ingrese la palabra a cifrar: ");
        String palabra = scanner.nextLine();

        // Definir el desplazamiento
        int desplazamiento = 3;

        // Cifrar la palabra ingresada por el usuario
        String criptograma = cifrar(palabra, desplazamiento);

        // Mostrar el resultado del cifrado
        System.out.println("\nCriptograma: " + criptograma);

        // Solicitar al usuario que ingrese el criptograma a descifrar
        System.out.print("\nIngrese el criptograma a descifrar: ");
        String criptogramaIngresado = scanner.nextLine();

        // Descifrar el criptograma ingresado por el usuario
        String mensajeDescifrado = descifrar(criptogramaIngresado, desplazamiento);

        // Mostrar el resultado del descifrado
        System.out.println("\nMensaje Descifrado: " + mensajeDescifrado);

        scanner.close();
    }
}
