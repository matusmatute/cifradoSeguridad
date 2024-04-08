

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class prueba {
    public static void main(String[] args) {
        // Rutas de los archivos de entrada y salida
        String inputFile = "home\\laura\\cifradoSeguridad\\src\\xor\\prueba.txt";
        String outputFile = "home\\laura\\cifradoSeguridad\\src\\xor\\pruebabinario.txt";
   


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {


            // Leer el texto cifrado en binario y la clave cifrada en binario
            String mensajeBinario = reader.readLine();
            String claveBinaria = reader.readLine();


            // Verificar que la longitud de la clave sea igual a la del mensaje
            if (mensajeBinario.length() != claveBinaria.length()) {
                System.out.println("La longitud de la clave debe ser igual a la del mensaje.");
                return;
            }


            // Realizar el descifrado XOR
            StringBuilder mensajeDescifradoBinario = new StringBuilder();
            for (int i = 0; i < mensajeBinario.length(); i++) {
                char bitMensaje = mensajeBinario.charAt(i);
                char bitClave = claveBinaria.charAt(i);


                // Aplicar la operación XOR bit a bit
                char bitDescifrado = (bitMensaje == bitClave) ? '0' : '1';
                mensajeDescifradoBinario.append(bitDescifrado);
            }


            // Convertir el mensaje descifrado a texto ASCII
            String mensajeDescifradoASCII = binaryToASCIIZ(mensajeDescifradoBinario.toString());


            // Mostrar resultados
            System.out.println("Texto descifrado en binario: " + mensajeDescifradoBinario.toString());
            System.out.println("Texto descifrado en ASCII: " + mensajeDescifradoASCII);
            System.out.println("Mensaje original en ASCII: " + binaryToASCII(mensajeBinario));


            // Escribir en el archivo de salida
            writer.write("Texto descifrado en binario: " + mensajeDescifradoBinario.toString());
            writer.newLine();
            writer.write("Texto descifrado en ASCII: " + mensajeDescifradoASCII);
            writer.newLine();
            writer.write("Mensaje original en ASCII: " + binaryToASCII(mensajeBinario));
            writer.newLine();


            System.out.println("Descifrado completado. Verifica el archivo archivo_descifrado.txt.");
        } catch (IOException e) {
            System.err.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }


    // Método para convertir una cadena binaria a texto ASCII
    private static String binaryToASCII(String binaryString) {
        StringBuilder stringBuilder = new StringBuilder();


        // Completar con ceros a la izquierda si es necesario
        int padding = 8 - (binaryString.length() % 8);
        String paddedBinaryString = "0".repeat(padding) + binaryString;


        for (int i = 0; i < paddedBinaryString.length(); i += 8) {
            String binaryByte = paddedBinaryString.substring(i, i + 8);
            int asciiValue = Integer.parseInt(binaryByte, 2);
           
            char asciiChar = (char) asciiValue;
            stringBuilder.append(asciiChar);
        }


        return stringBuilder.toString();
    }


    private static String binaryToASCIIZ(String binaryString) {
        StringBuilder stringBuilder = new StringBuilder();


        // Completar con ceros a la izquierda si es necesario
        int padding = 8 - (binaryString.length() % 8);
        String paddedBinaryString = "0".repeat(padding) + binaryString;


        for (int i = 0; i < paddedBinaryString.length(); i += 8) {
            String binaryByte = paddedBinaryString.substring(i, i + 8);
            int asciiValue = Integer.parseInt(binaryByte, 2);
           


            // Verificar si el valor ASCII está en el rango deseado (0 - 100000)
            if (asciiValue >= 0 && asciiValue <= 32 ) {
                stringBuilder.append('!');
            }
                else {
                    // De lo contrario, convertir a carácter ASCII normal
                    char asciiChar = (char) asciiValue;
                    stringBuilder.append(asciiChar);
                   
                }
               
               
           
           
        }


    return stringBuilder.toString();
}


}





