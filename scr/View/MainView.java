package view;

import controller.VeiculoController;
import javax.swing.*;
import java.awt.*;

public class MainView {
    private JFrame frame;
    private JButton btnCadastrarVeiculo;
    private JButton btnFiltrarVeiculos;

    public MainView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Gestão Automotiva");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
        btnFiltrarVeiculos = new JButton("Filtrar Veículos");

        btnCadastrarVeiculo.addActionListener(e -> openCadastroView());
        btnFiltrarVeiculos.addActionListener(e -> openFiltroView());

        frame.add(btnCadastrarVeiculo);
        frame.add(btnFiltrarVeiculos);

        frame.setVisible(true);
    }

    private void openCadastroView() {
        VeiculoView veiculoView = new VeiculoView(new VeiculoController(veiculoView));
        veiculoView.getFrame().setVisible(true);
    }

    private void openFiltroView() {
        FiltroView filtroView = new FiltroView(new FiltroController(filtroView));
        filtro
