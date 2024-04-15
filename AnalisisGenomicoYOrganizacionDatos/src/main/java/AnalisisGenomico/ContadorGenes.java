package AnalisisGenomico;

public class ContadorGenes {
    public int contarGenes(String dna) {
        if (dna.length() < 3) return 0;
        if (dna.startsWith("ATG")) {
            return 1 + contarGenes(dna.substring(3));
        } else {
            return contarGenes(dna.substring(1));
        }
    }
}
