package View;
import Controller.GeneroController;
import Model.Genero;


import java.util.List;
import java.util.Scanner;

public class GeneroView {

    GeneroController generoController = new GeneroController();
    Scanner input = new Scanner(System.in);
    BibliotecaView bibliotecaView = new BibliotecaView();

    public void cadastrarGenero() {
        Genero genero = new Genero();

        Scanner input = new Scanner(System.in);
        System.out.print("Nome do Gênero: ");
        genero.setNomeGenero(input.nextLine());

        //BibliotecaView.listarCategorias();
        //qSystem.out.print("ID da Categoria para este Produto: ");
        //produto.setIdCategoria(Long.parseLong(input.nextLine()));
        //System.out.println("\nProduto adicionado a Categoria Escolhida.");*/


        generoController.cadastrarGenero(genero);
        System.out.println("\n" + genero);

    }

    public void editarGenero(){

        this.listarProdutos();
        System.out.println("Pressione ENTER caso não queira mudar o campo pedido.");
        System.out.print("Escolha o produto a ser editado a partir do ID: ");
        Genero produtoSelecionado = generoController.selecionarGenero(Long.parseLong(input.nextLine()));

        String aux;

        System.out.print("Novo nome do genero: ");
        aux = input.nextLine();
        if (aux != "") {
            produtoSelecionado.setIdGenero(aux);
        }

        generoController.editarGenero(produtoSelecionado);

    }
}
