package view;

import controller.VeiculoController;
import javax.swing.*;
import java.awt.*;

public class VeiculoView {
    private JFrame frame;
    private JTextField modeloField, marcaField, anoField, precoField, quilometragemField;
    private JButton btnSalvar, btnFiltrar;
    private VeiculoController controller;

    public VeiculoView(VeiculoController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Cadastro de Veículos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Campos de cadastro
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 30, 100, 25);
        frame.add(lblModelo);

        modeloField = new JTextField();
        modeloField.setBounds(150, 30, 200, 25);
        frame.add(modeloField);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 60, 100, 25);
        frame.add(lblMarca);

        marcaField = new JTextField();
        marcaField.setBounds(150, 60, 200, 25);
        frame.add(marcaField);

        JLabel lblAno = new JLabel("Ano:");
        lblAno.setBounds(30, 90, 100, 25);
        frame.add(lblAno);

        anoField = new JTextField();
        anoField.setBounds(150, 90, 200, 25);
        frame.add(anoField);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(30, 120, 100, 25);
        frame.add(lblPreco);

        precoField = new JTextField();
        precoField.setBounds(150, 120, 200, 25);
        frame.add(precoField);

        JLabel lblQuilometragem = new JLabel("Quilometragem:");
        lblQuilometragem.setBounds(30, 150, 120, 25);
        frame.add(lblQuilometragem);

        quilometragemField = new JTextField();
        quilometragemField.setBounds(150, 150, 200, 25);
        frame.add(quilometragemField);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 200, 100, 30);
        btnSalvar.addActionListener(e -> saveVeiculo());
        frame.add(btnSalvar);

        btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBounds(270, 200, 100, 30);
        btnFiltrar.addActionListener(e -> openFiltroView());
        frame.add(btnFiltrar);

        frame.setVisible(true);
    }

    private void saveVeiculo() {
        // Método para salvar veículo
        Veiculo veiculo = new Veiculo(
                modeloField.getText(),
                marcaField.getText(),
                Integer.parseInt(anoField.getText()),
                Double.parseDouble(precoField.getText()),
                Integer.parseInt(quilometragemField.getText()),
                "Disponível"
        );
        controller.saveVeiculo(veiculo);
    }

    private void openFiltroView() {
        // Abrir a janela de filtro
        FiltroView filtroView = new FiltroView(new FiltroController(new FiltroView(new FiltroController(null))));
        filtroView.getFrame().setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }
}
