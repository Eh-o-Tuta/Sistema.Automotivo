package model;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private Connection connection;

    // Construtor para inicializar a conexão com o banco
    public VeiculoDAO() {
        try {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL("jdbc:h2:./db/estoque_veiculos");
            dataSource.setUser("sa");
            dataSource.setPassword("");
            connection = dataSource.getConnection();

            // Criar tabela no banco, se não existir
            String createTableSQL = "CREATE TABLE IF NOT EXISTS veiculos (" +
                    "id IDENTITY PRIMARY KEY, " +
                    "modelo VARCHAR(255), " +
                    "marca VARCHAR(255), " +
                    "ano INT, " +
                    "preco DOUBLE, " +
                    "quilometragem INT, " +
                    "status VARCHAR(50))";
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(createTableSQL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para adicionar veículo ao banco
    public void addVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (modelo, marca, ano, preco, quilometragem, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getMarca());
            stmt.setInt(3, veiculo.getAno());
            stmt.setDouble(4, veiculo.getPreco());
            stmt.setInt(5, veiculo.getQuilometragem());
            stmt.setString(6, veiculo.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os veículos
    public List<Veiculo> getVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getDouble("preco"),
                        rs.getInt("quilometragem"),
                        rs.getString("status")
                );
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    // Outros métodos para atualizar e deletar veículos podem ser adicionados
}
