package AnalisisGenomico;
import java.util.ArrayList;
import java.util.List;
public class CalculoCombGeneticas {
    public List<String> calcularCombinaciones(String gen1, String gen2) {
        List<String> combinaciones = new ArrayList<>();
        calcularCombinacionesRecursivo("", gen1, gen2, combinaciones);
        return combinaciones;
    }

    private void calcularCombinacionesRecursivo(String prefix, String gen1, String gen2, List<String> combinaciones) {
        if (gen1.isEmpty() || gen2.isEmpty()) {
            combinaciones.add(prefix + gen1 + gen2);
            return;
        }

        for (int i = 0; i < gen2.length(); i++) {
            calcularCombinacionesRecursivo(prefix + gen1.charAt(0) + gen2.charAt(i), gen1.substring(1), gen2.substring(0, i) + gen2.substring(i + 1), combinaciones);
        }
    }
}
