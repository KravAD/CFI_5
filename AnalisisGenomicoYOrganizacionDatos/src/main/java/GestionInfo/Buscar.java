package GestionInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Buscar {
    public static boolean busquedaLineal(String texto, String palabraBuscada) {
        List<String> palabras = Arrays.asList(texto.split("\\s+"));
        for (String palabra : palabras) {
            if (palabra.equals(palabraBuscada)) {
                return true;
            }
        }
        return false;
    }

    public static boolean busquedaBinaria(String texto, String palabraBuscada) {
        List<String> palabras = Arrays.asList(texto.split("\\s+"));
        Collections.sort(palabras);
        int indice = Collections.binarySearch(palabras, palabraBuscada);
        return indice >= 0;
    }
}
