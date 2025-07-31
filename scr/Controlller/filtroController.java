package controller;

import model.VeiculoDAO;
import view.FiltroView;
import java.util.List;

public class FiltroController {
    private FiltroView view;
    private VeiculoDAO dao;

    public FiltroController(FiltroView view) {
        this.view = view;
        this.dao = new VeiculoDAO();
    }

    public void filtrar() {
        // Recuperar dados de filtro da interface gráfica
        String marca = (String) view.getMarcaComboBox().getSelectedItem();
        String modelo = (String) view.getModeloComboBox().getSelectedItem();
        String ano = view.getAnoTextField().getText();
        String preco = view.getPrecoTextField().getText();

        // Lógica de filtragem (aqui você aplicaria as regras de filtro)
        List<Veiculo> veiculos = dao.getVeiculos(); // Este método deve ser filtrado conforme os parâmetros

        // Aqui você pode exibir ou manipular os resultados
        for (Veiculo veiculo : veiculos) {
            System.out.println("Veículo: " + veiculo.getModelo());
        }
    }
}
