import controller.VeiculoController;
import view.VeiculoView;

public class Main {
    public static void main(String[] args) {
        VeiculoView view = new VeiculoView(new VeiculoController(view));
        view.getFrame().setVisible(true);
    }
