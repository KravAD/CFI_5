package GestionInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestionExperimento {
    private List<Experimento> experimentos;

    public GestionExperimento() {
        this.experimentos = new ArrayList<>();
    }

    public void agregarExperimento(Experimento experimento) {
        this.experimentos.add(experimento);
    }

    public List<Experimento> getExperimentosOrdenados() {
        this.experimentos.sort(Comparator.comparing(Experimento::getFecha));
        return this.experimentos;
    }
}
