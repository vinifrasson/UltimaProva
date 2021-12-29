package Controller;

import DAO.BibliotecaDAO;
import Model.Biblioteca;

import java.util.List;

public class BibliotecaController {

    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();

    public void cadastrarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.cadastrarBiblioteca(biblioteca);
    }

    public void editarBiblioteca(Biblioteca biblioteca){
        bibliotecaDAO.editarBiblioteca(biblioteca);
    }

    public Biblioteca selecionarBiblioteca(Long idBiblioteca){
        return  bibliotecaDAO.selecionarBiblioteca(idBiblioteca);
    }

    public void removerBiblioteca(Long idBiblioteca){
        bibliotecaDAO.removerBiblioteca(idBiblioteca);
    }
}


/*

    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }
 */