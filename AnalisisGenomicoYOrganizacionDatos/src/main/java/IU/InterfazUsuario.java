package IU;
import AnalisisGenomico.*;
import AnalisisNumerico.*;
import GestionInfo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazUsuario extends JFrame{
    private ContadorGenes contadorGenes;
    private CalculoCombGeneticas calculoCombGeneticas;
    private SumYListaNum sumYListaNum;
    private PotenciasMaximos potenciasMaximos;
    private OrdenarLineas ordenarLineas;

    private String dna = "ATGCGTATGAGCTAGCTAGCATG";
    private String gen1 = "ATG";
    private String gen2 = "CGT";

    public InterfazUsuario() {
        contadorGenes = new ContadorGenes();
        calculoCombGeneticas = new CalculoCombGeneticas();
        sumYListaNum = new SumYListaNum();
        potenciasMaximos = new PotenciasMaximos();
        ordenarLineas = new OrdenarLineas();

        JPanel panel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout());
        JPanel southPanel = new JPanel(new FlowLayout());

        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton botonContarGenes = new JButton("Contar Genes");
        JButton botonCalcularCombinaciones = new JButton("Calcular Combinaciones");
        JButton botonSumYListaNum = new JButton("SumYListaNum");
        JButton botonPotenciasMaximos = new JButton("PotenciasMaximos");
        JButton botonOrdenarLineas = new JButton("Ordenar Lineas");

        botonContarGenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numGenes = contadorGenes.contarGenes(dna);
                JOptionPane.showMessageDialog(null, "Número de genes: " + numGenes);
            }
        });

        botonCalcularCombinaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> combinaciones = calculoCombGeneticas.calcularCombinaciones(gen1, gen2);
                JOptionPane.showMessageDialog(null, "Combinaciones genéticas: " + combinaciones);
            }
        });

        botonSumYListaNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sum = sumYListaNum.sumatoria(10);
                JOptionPane.showMessageDialog(null, "La suma de los primeros 10 números naturales es: " + sum);
            }
        });

        botonPotenciasMaximos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] numeros = {1, 3, 7, 2, 5};
                int max = potenciasMaximos.maximo(numeros, 0);
                JOptionPane.showMessageDialog(null, "El valor máximo en el array es: " + max);
            }
        });

        botonOrdenarLineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarLineas.ordenarLineas(textArea);
                JOptionPane.showMessageDialog(null, "Las líneas del texto han sido ordenadas alfabéticamente.");
            }
        });

        northPanel.add(botonContarGenes);
        northPanel.add(botonCalcularCombinaciones);
        northPanel.add(botonOrdenarLineas);

        southPanel.add(botonSumYListaNum);
        southPanel.add(botonPotenciasMaximos);

        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}