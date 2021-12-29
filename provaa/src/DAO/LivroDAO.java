package DAO;

import Factory.ConnectionFactory;
import Model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection;

    public LivroDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaLivro() {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "idLivro INT PRIMARY KEY AUTO_INCREMENT," +
                "nomeLivro VARCHAR(50)," +
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
            System.out.println("\nVoce ja cadastrou uma Biblioteca? Se não, crie-os e depois cadastre um livro\n");
            throw new RuntimeException(e);
        }
    }

    public void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros(nomeLivro, idBiblioteca) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setLong(2, livro.getIdBiblioteca());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                livro.setIdLivro(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
