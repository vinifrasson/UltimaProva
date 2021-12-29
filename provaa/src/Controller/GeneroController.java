package Controller;

import DAO.GeneroDAO;
import Model.Genero;

import java.util.List;

public class GeneroController {

    GeneroDAO generoDAO = new GeneroDAO();

    public void cadastrarGenero(Genero genero){
        generoDAO.cadastrarGenero(genero);
    }

    public List<Genero> listarGenero() {
        return generoDAO.listarGenero();
    }

    public void editarGenero(Genero genero) {
        generoDAO.editarGenero(genero);
    }

    public Genero selecionarGenero(Long idGenero){
        return generoDAO.selecionarGenero(idGenero);
    }

    public void removerGenero(Long idGenero) {
        generoDAO.removerGenero(idGenero);
    }

    }

/*
    public List<Produto> listarProdutosPorCategoria(Long idCategoria) {
        return produtoDAO.listarProdutosPorCategoria(idCategoria);
    }
 */
