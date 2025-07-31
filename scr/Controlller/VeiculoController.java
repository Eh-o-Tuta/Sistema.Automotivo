package controller;

import model.Veiculo;
import model.VeiculoDAO;
import view.VeiculoView;
import javax.swing.*;

public class VeiculoController {
    private VeiculoDAO dao;
    private VeiculoView view;

    public VeiculoController(VeiculoView view) {
        this.view = view;
        this.dao = new VeiculoDAO();
    }

    public void saveVeiculo(Veiculo veiculo) {
        dao.addVeiculo(veiculo);
        JOptionPane.showMessageDialog(view.getFrame(), "Veículo cadastrado com sucesso!");
    }
}
