package GestionInfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class OrdenarLineas {

    public void ordenarLineas(JTextArea textArea) {
        String contenido = textArea.getText();
        List<String> lineas = new ArrayList<>(Arrays.asList(contenido.split("\n")));

        Collections.sort(lineas);

        String contenidoOrdenado = String.join("\n", lineas);
        textArea.setText(contenidoOrdenado);
    }
}
