package View;
import DAO.*;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public void menuPrincipal() {

        while (true) {

            System.out.println("-------------Menu Principal-------------");
            System.out.println("-           1 > Biblioteca             -");
            System.out.println("-           2 > Gênero                 -");
            System.out.println("-           3 > Livro                  -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    menuBiblioteca();
                    break;
                case 2:
                    menuCategorias();
                    break;
                case 3:
                    menuCategorias();
                    break;
            }
        }
    }

    public int menuBiblioteca() {

        BibliotecaView bibliotecaView = new BibliotecaView();
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        bibliotecaDAO.criarTabelaBiblioteca();

        while (true) {
            System.out.println("\n-------------Menu Produtos----------------");
            System.out.println("-      1 > Cadastrar Biblioteca            -");
            System.out.println("-      2 > Listar Livros Por Biblioteca    -");
            System.out.println("-      3 > Voltar                          -");
            System.out.println("--------------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    bibliotecaView.cadastrarBiblioteca();
                    break;
                case 2:

                    break;
                case 3:
                    return -1;
            }
        }
    }

    public int menuGenero(){
        GeneroView generoView = new GeneroView();
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.criarTabelaGenero();
        while (true){
            System.out.println("------------Menu Categorias-------------");
            System.out.println("-       1 > Cadastrar Genero           -");
            System.out.println("-       2 > Editar Genero              -");
            System.out.println("-       3 > Voltar                     -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    generoView.cadastrarProduto();
                    break;
                case 2:
                    generoView.editarProduto();
                    break;
                case 3:
                    return -1;
            }
        }
    }

    public int menuGenero(){
        GeneroView generoView = new GeneroView();
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.criarTabelaGenero();
        while (true){
            System.out.println("------------Menu Categorias-------------");
            System.out.println("-       1 > Cadastrar Genero           -");
            System.out.println("-       2 > Editar Genero              -");
            System.out.println("-       3 > Voltar                     -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    generoView.cadastrarGenero();
                    break;
                case 2:
                    generoView.editarGenero();
                    break;
                case 3:
                    return -1;
            }
        }
    }

    public int menuLivro(){
        LivroView livroView = new LivroView();
        LivroDAO livroDAO = new LivroDAO();

        livroDAO.criarTabelaLivro();
        while (true){
            System.out.println("---------------Menu Livro--------------");
            System.out.println("-       1 > Cadastrar Livro           -");
            System.out.println("-       2 > Voltar                    -");
            System.out.println("---------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    livroDAO.cadastrarLivro();
                    break;
                case 2:
                    return -1;
            }
        }
    }
}