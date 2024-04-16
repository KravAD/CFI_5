package GestionInfo;

import java.time.LocalDate;

public class Experimento {
    private LocalDate fecha;
    private String resultado;

    public Experimento(LocalDate fecha, String resultado) {
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }
}
