package view;

import controller.FiltroController;
import javax.swing.*;
import java.awt.*;

public class FiltroView {
    private JFrame frame;
    private JComboBox<String> marcaComboBox;
    private JComboBox<String> modeloComboBox;
    private JTextField anoTextField;
    private JTextField precoTextField;
    private JButton filtroButton;
    private FiltroController controller;

    public FiltroView(FiltroController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Filtro de Veículos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        marcaComboBox = new JComboBox<>();
        modeloComboBox = new JComboBox<>();
        anoTextField = new JTextField(10);
        precoTextField = new JTextField(10);
        filtroButton = new JButton("Filtrar");

        // Adicionando itens no JComboBox para teste
        marcaComboBox.addItem("Toyota");
        marcaComboBox.addItem("Honda");
        modeloComboBox.addItem("Corolla");
        modeloComboBox.addItem("Civic");

        frame.add(new JLabel("Marca:"));
        frame.add(marcaComboBox);
        frame.add(new JLabel("Modelo:"));
        frame.add(modeloComboBox);
        frame.add(new JLabel("Ano:"));
        frame.add(anoTextField);
        frame.add(new JLabel("Preço:"));
        frame.add(precoTextField);
        frame.add(filtroButton);

        filtroButton.addActionListener(e -> controller.filtrar());

        frame.setVisible(true);
    }

    public JComboBox<String> getMarcaComboBox() {
        return marcaComboBox;
    }

    public JComboBox<String> getModeloComboBox() {
        return modeloComboBox;
    }

    public JTextField getAnoTextField() {
        return anoTextField;
    }

    public JTextField getPrecoTextField() {
        return precoTextField;
    }
}
