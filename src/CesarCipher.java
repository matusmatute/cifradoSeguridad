import java.util.Scanner;

public class CesarCipher {
    // Método para cifrar un mensaje utilizando el cifrado César con un desplazamiento dado
    public static String cifrar(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        System.out.println("\nMatriz de cifrado:");
        System.out.println("Alfabeto Normal\tAlfabeto Desplazado");
        // Crear el alfabeto normal y el alfabeto desplazado
        StringBuilder alfabetoNormal = new StringBuilder();
        StringBuilder alfabetoDesplazado = new StringBuilder();
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            alfabetoNormal.append(letra);
            char letraDesplazada = (char) (((letra - 'A' + desplazamiento) % 26) + 'A');
            alfabetoDesplazado.append(letraDesplazada);
        }
        System.out.println(alfabetoNormal.toString() + "\t" + alfabetoDesplazado.toString());

        // Cifrar el mensaje
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            // Verificar si el caracter es una letra
            if (Character.isLetter(caracter)) {
                // Obtener el índice del caracter en el alfabeto normal
                int indice = Character.toUpperCase(caracter) - 'A';
                // Obtener el caracter cifrado
                char caracterCifrado = alfabetoDesplazado.charAt(indice);
                // Mantener el caso del caracter original
                if (Character.isLowerCase(caracter)) {
                    resultado.append(Character.toLowerCase(caracterCifrado));
                } else {
                    resultado.append(caracterCifrado);
                }
            } else {
                // Mantener los caracteres que no son letras sin modificar
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    // Método para descifrar un mensaje cifrado utilizando el cifrado César con un desplazamiento dado
    public static String descifrar(String mensajeCifrado, int desplazamiento) {
        // Para descifrar, simplemente se utiliza el cifrado con un desplazamiento negativo
        return cifrar(mensajeCifrado, -desplazamiento);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cifrado
        System.out.println("Cifrado César");
        System.out.print("Ingrese el texto plano a cifrar (máximo 20 letras): ");
        String textoPlano = scanner.nextLine().toUpperCase();
        // Validar que el texto plano tenga máximo 20 letras
        while (textoPlano.length() > 20) {
            System.out.println("El texto plano debe tener máximo 20 letras. Inténtelo de nuevo:");
            textoPlano = scanner.nextLine().toUpperCase();
        }
        // Definir el desplazamiento inicial en la letra 'E'
        int desplazamiento = 4;
        // Realizar el cifrado
        String criptograma = cifrar(textoPlano, desplazamiento);
        System.out.println("Criptograma: " + criptograma);

        // Descifrado
        System.out.println("\nDescifrado César");
        System.out.print("Ingrese el criptograma a descifrar: ");
        String criptogramaIngresado = scanner.nextLine().toUpperCase();
        // Realizar el descifrado
        String textoDescifrado = descifrar(criptogramaIngresado, desplazamiento);
        System.out.println("Texto Descifrado: " + textoDescifrado);

        scanner.close();
    }
}
