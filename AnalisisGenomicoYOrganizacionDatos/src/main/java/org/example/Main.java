package org.example;
import IU.InterfazUsuario;

public class Main {
    public static void main(String[] args) {
        String dna = "ATGCGTATGAGCTAGCTAGCATG";
        String gen1 = "ATG";
        String gen2 = "CGT";
        new InterfazUsuario(dna, gen1, gen2);
    }
}