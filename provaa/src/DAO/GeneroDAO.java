package DAO;

import Factory.ConnectionFactory;
import Model.Genero;
import View.GeneroView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO {

    private Connection connection;

    public GeneroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaGenero() {
        String sql = "CREATE TABLE IF NOT EXISTS generos (" +
                "idGenero INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeGenero VARCHAR(50)," +
                "idBiblioteca INT NOT NULL," +
                "CONSTRAINT fk_idBiblioteca FOREIGN KEY (idBiblioteca)" +
                "REFERENCES bibliotecas(idBiblioteca)" +
                "ON DELETE CASCADE," +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("\nVoce ja cadastrou uma Biblioteca? Se não, crie-os e depois cadastre um genero\n");
            throw new RuntimeException(e);
        }
    }

    public void cadastrarGenero(Genero genero) {
        String sql = "INSERT INTO generos(nomeProduto, idBiblioteca) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setLong(2, genero.idBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                genero.setIdGenero(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void editarGenero(Genero genero) {
        String sql = "UPDATE generos SET nomeGenero = ?  WHERE idGenero = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, genero.getNomeGenero());
            preparedStatement.setLong(2, genero.getIdGenero());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nGenero editado: ID: " + genero.getIdGenero() +
                    " | Nome do produto: " + genero.getNomeGenero());

            System.out.println();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Genero selecionarGenero(Long idGenero) {
        String sql = "SELECT * FROM generos WHERE idGenero = ?";
        Genero genero = new Genero();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idGenero);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genero;
    }

    public void removerGenero(Long idGenero) {
        String sql = "DELETE FROM generos WHERE idGenero = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idGenero);
            Genero genero = selecionarGenero(idGenero);
            System.out.println("Removendo o Genero " + genero.getNomeGenero() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Genero> listarGenero() {
        String sql = "SELECT * FROM generos";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Genero> generos = new ArrayList<>();

            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setIdGenero(resultSet.getInt("idGenero"));
                genero.setNomeGenero(resultSet.getString("nomeGenero"));

                generos.add(genero);
            }
            return generos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
        /*


    public List<Produto> listarProdutosPorCategoria(Long idCategoria){
        String sql = "SELECT produtos.nomeProduto, categorias.idCategoria " +
                "FROM produtos " +
                "INNER JOIN categorias " +
                "ON produtos.idCategoria = categorias.idCategoria " +
                "WHERE categorias.idCategoria = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            preparedStatement.setLong(1,idCategoria);
            categoriaDAO.selecionarCategoria(idCategoria);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Produto> listarProdutosPorCategoria = new ArrayList<>();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setNomeProduto(resultSet.getString("nomeProduto"));
                produto.setIdCategoria(resultSet.getInt("idCategoria"));

                listarProdutosPorCategoria.add(produto);
            }
            return listarProdutosPorCategoria;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 */