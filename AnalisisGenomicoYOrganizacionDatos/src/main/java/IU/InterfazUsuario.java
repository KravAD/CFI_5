package IU;
import AnalisisGenomico.*;
import AnalisisNumerico.*;
import GestionInfo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InterfazUsuario extends JFrame{
    private ContadorGenes contadorGenes;
    private CalculoCombGeneticas calculoCombGeneticas;
    private SumYListaNum sumYListaNum;
    private PotenciasMaximos potenciasMaximos;
    private OrdenarLineas ordenarLineas;
    private Buscar buscar;
    private GestionExperimento gestionExperimento;



    private String dna = "ATGCGTATGAGCTAGCTAGCATG";
    private String gen1 = "ATG";
    private String gen2 = "CGT";

    public InterfazUsuario() {
        contadorGenes = new ContadorGenes();
        calculoCombGeneticas = new CalculoCombGeneticas();
        sumYListaNum = new SumYListaNum();
        potenciasMaximos = new PotenciasMaximos();
        ordenarLineas = new OrdenarLineas();
        buscar = new Buscar();
        gestionExperimento = new GestionExperimento();

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
        JButton botonBuscar = new JButton("Buscar");
        JButton botonAgregar = new JButton("Agregar Experimento");
        JButton botonListar = new JButton("Listar Experimentos");


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
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabraBuscada = JOptionPane.showInputDialog("Ingrese la palabra que desea buscar:");
                String textoCompleto = textArea.getText();
                boolean encontrado = Buscar.busquedaBinaria(textoCompleto, palabraBuscada);
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "La palabra '" + palabraBuscada + "' fue encontrada.");
                } else {
                    JOptionPane.showMessageDialog(null, "La palabra '" + palabraBuscada + "' no fue encontrada.");
                }
            }
        });
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha del experimento (formato YYYY-MM-DD):");
                String resultado = JOptionPane.showInputDialog("Ingrese el resultado del experimento:");
                try {
                    LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
                    Experimento experimento = new Experimento(fecha, resultado);
                    gestionExperimento.agregarExperimento(experimento);
                    JOptionPane.showMessageDialog(null, "Experimento agregado exitosamente.");
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Por favor, ingrese la fecha en el formato correcto (YYYY-MM-DD).");
                }
            }
        });

        botonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Experimento experimento : gestionExperimento.getExperimentosOrdenados()) {
                    sb.append(experimento.getFecha()).append(": ").append(experimento.getResultado()).append("\n");
                }
                textArea.setText(sb.toString());
            }
        });

        northPanel.add(botonContarGenes);
        northPanel.add(botonCalcularCombinaciones);
        northPanel.add(botonOrdenarLineas);
        northPanel.add(botonBuscar);
        northPanel.add(botonAgregar);
        northPanel.add(botonListar);

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