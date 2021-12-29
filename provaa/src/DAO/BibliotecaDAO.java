package DAO;

import Factory.ConnectionFactory;
import Model.Biblioteca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {

    private Connection connection;

    public BibliotecaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaBiblioteca(){
            String sql = "CREATE TABLE IF NOT EXISTS bibliotecas (" +
                    "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                    "nomeBiblioteca VARCHAR(50)" +
                    ");";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public void cadastrarBiblioteca(Biblioteca biblioteca) {
        String sql = "INSERT INTO bibliotecas (nomeBiblioteca) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void editarBiblioteca(Biblioteca biblioteca) {
        String sql = "UPDATE biblioteca SET nomeBiblioteca = ? WHERE idBiblioteca = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, biblioteca.getNomeBiblioteca());
            preparedStatement.setLong(2, biblioteca.getIdBiblioteca());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("\nBiblioteca editada: ID: " + biblioteca.getIdBiblioteca() +
                    " | Nome da Biblioteca: " + biblioteca.getNomeBiblioteca());
            System.out.println();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Biblioteca selecionarBiblioteca(Long idBiblioteca) {
        String sql = "SELECT * FROM bibliotacas WHERE idBiblioteca = ?";
        Biblioteca biblioteca = new Biblioteca();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idBiblioteca);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                biblioteca.setIdBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeBiblioteca(resultSet.getString("nomeBiblioteca"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return biblioteca;
    }

    public void removerBiblioteca(Long idBiblioteca) {
        String sql = "DELETE FROM bibliotecas WHERE idBiblioteca = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, idBiblioteca);
            Biblioteca biblioteca = selecionarBiblioteca(idBiblioteca);
            System.out.println("Removendo a biblioteca " + biblioteca.getNomeBiblioteca() + "...");
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

/*
    public List<Categoria> listarCategorias() {
        String sql = "SELECT * FROM categorias";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Categoria> categorias = new ArrayList<>();

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));
                categoria.setNomeCategoria(resultSet.getString("nomeCategoria"));
                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
 */
