package IU;
import AnalisisGenomico.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazUsuario extends JFrame{
    private ContadorGenes contadorGenes;
    private CalculoCombGeneticas calculoCombGeneticas;

    public InterfazUsuario(String dna, String gen1, String gen2) {
        contadorGenes = new ContadorGenes();
        calculoCombGeneticas = new CalculoCombGeneticas();

        JPanel panel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout());

        JButton botonContarGenes = new JButton("Contar Genes");
        JButton botonCalcularCombinaciones = new JButton("Calcular Combinaciones");

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

        northPanel.add(botonContarGenes);
        northPanel.add(botonCalcularCombinaciones);

        panel.add(northPanel, BorderLayout.NORTH);

        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}