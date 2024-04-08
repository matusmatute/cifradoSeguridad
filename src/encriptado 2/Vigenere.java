import java.util.Scanner;

public class Vigenere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        // Cifrado
        System.out.println("Cifrado Vigenère:");
        System.out.print("Ingrese el texto plano (máximo 30 caracteres): ");
        String textoPlano = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine().toUpperCase();

        System.out.println("\nAlfabeto con sus valores:");
        mostrarAlfabeto();

        System.out.println("\nNúmeros de las letras cifradas del texto ingresado:");
        mostrarValores(textoPlano);

        System.out.println("\nClave con sus valores:");
        mostrarValores(clave);
      
        System.out.println("\nClave en texto:"+ clave);

        String criptograma = cifrarVigenere(textoPlano, clave);
        System.out.println("\nCriptograma con sus valores:");
        mostrarValoresConPosiciones(criptograma);
        System.out.println("Criptograma en texto:");
        mostrarCriptograma(criptograma);

        // Descifrado
        System.out.println("\nDescifrado Vigenère:");
        System.out.print("Ingrese el criptograma: ");
        String criptogramaIngresado = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la clave: ");
        String claveDescifrado = scanner.nextLine().toUpperCase();

        System.out.println("\nCriptograma con sus valores:");
        mostrarValoresConPosiciones(criptogramaIngresado);
        System.out.println("Criptograma en texto:");
        mostrarCriptograma(criptogramaIngresado);

        System.out.println("\nClave con sus valores:");
        mostrarValores(claveDescifrado);

        System.out.println("\nAlfabeto con sus valores:");
mostrarAlfabetoConAsociaciones();

        
        System.out.println("\nClave en texto:"+ claveDescifrado);

        String textoPlanoDescifrado = descifrarVigenere(criptogramaIngresado, claveDescifrado);
        System.out.println("\nTexto plano descifrado con sus valores:");
        mostrarValoresConPosiciones(textoPlanoDescifrado);
        System.out.println("Texto plano descifrado sin números:");
        mostrarCriptograma(textoPlanoDescifrado);
    }

    private static void mostrarAlfabeto() {
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            System.out.print(letra + "(" + (letra - 'A') + ") ");
        }
        System.out.println();
    }
    

    
    private static void mostrarValores(String texto) {
        for (char letra : texto.toCharArray()) {
            if (letra == ' ') {
                System.out.print("  ");
            } else {
                System.out.print((letra - 'A') + " ");
            }
        }
        System.out.println();
    }
    

    private static void mostrarValoresConPosiciones(String texto) {
        for (char letra : texto.toCharArray()) {
            if (letra == ' ') {
                System.out.print("    ");
            } else {
                System.out.print(letra + "(" + (letra - 'A') + ") ");
            }
        }
        System.out.println();
    }

    private static void mostrarAlfabetoConAsociaciones() {
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            System.out.print(letra + "(" + (letra - 'A') + ") ");
        }
        System.out.println();
    }
    

    private static void mostrarCriptograma(String texto) {
        for (char letra : texto.toCharArray()) {
            if (letra == ' ') {
                System.out.print(" ");
            } else {
                System.out.print(letra);
            }
        }
        System.out.println();
    }

    private static String cifrarVigenere(String textoPlano, String clave) {
        StringBuilder resultado = new StringBuilder();
        int n = textoPlano.length();

        for (int i = 0; i < n; i++) {
            char letraTexto = textoPlano.charAt(i);
            char letraClave = clave.charAt(i % clave.length());

            if (letraTexto == ' ') {
                resultado.append(' ');
            } else {
                int valorCifrado = ((letraTexto - 'A') + (letraClave - 'A')) % 26;
                resultado.append((char) (valorCifrado + 'A'));
            }
        }

        return resultado.toString();
    }
    

    private static String descifrarVigenere(String criptograma, String clave) {
        StringBuilder resultado = new StringBuilder();
        int n = criptograma.length();

        for (int i = 0; i < n; i++) {
            char letraCifrado = criptograma.charAt(i);
            char letraClave = clave.charAt(i % clave.length());

            if (letraCifrado == ' ') {
                resultado.append(' ');
            } else {
                int valorDescifrado = ((letraCifrado - 'A') - (letraClave - 'A') + 26) % 26;
                resultado.append((char) (valorDescifrado + 'A'));
            }
        }

        

        return resultado.toString();
    }
}
