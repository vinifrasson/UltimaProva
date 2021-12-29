package Controller;

import DAO.LivroDAO;
import Model.Livro;

public class LivroController {

    LivroDAO livroDAO = new LivroDAO();

    public void cadastrarLivro(Livro livro){
        livroDAO.cadastrarLivro(livro);

    }
}
