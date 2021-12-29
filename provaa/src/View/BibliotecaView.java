package View;

import Controller.BibliotecaController;
import Model.Biblioteca;
import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    BibliotecaController bibliotecaController = new BibliotecaController();
    Scanner input = new Scanner(System.in);

    public void cadastrarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome da Biblioteca: ");
        biblioteca.setNomeBiblioteca(input.nextLine());

        bibliotecaController.cadastrarBiblioteca(biblioteca);
        System.out.println("\n" + biblioteca);
    }




}

/*
    public void editarCategoria(){
        this.listarCategorias();
        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha a categoria a ser editada a partir do ID: ");
        Categoria categoriaSelecionada = categoriaController.selecionarCategoria(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome da categoria: ");
        aux = input.nextLine();
        if (aux != "") {
            categoriaSelecionada.setNomeCategoria(aux);
        }
        categoriaController.editarCategoria(categoriaSelecionada);
    }

    public void removerCategoria() {
        this.listarCategorias();
        System.out.print("Escolha a categoria a ser removida a partir do ID: ");
        Long idCategoria = Long.parseLong(input.nextLine());
        categoriaController.removerCategoria(idCategoria);
        System.out.println("Categoria removida com sucesso!");
    }

    public void listarCategorias() {

        List<Categoria> categorias = categoriaController.listarCategorias();
        System.out.println("\n---------Categorias Disponiveis---------");
        System.out.println();
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println("ID da Categoria: " + categorias.get(i).getIdCategoria() +
                    " | Nome da Categoria: " + categorias.get(i).getNomeCategoria());
        }
        System.out.println();
    }

}
 */
