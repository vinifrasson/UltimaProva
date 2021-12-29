package View;
import Controller.LivroController;
import Model.Livro;
import java.util.List;
import java.util.Scanner;

public class LivroView {

    LivroController livroController = new LivroController();
    Scanner input = new Scanner(System.in);

    public void cadastrarLivro(){

        Livro livro = new Livro();
        Scanner input = new Scanner(System.in);
        System.out.print("Nome do Livro: ");
        livro.setNomeLivro(input.nextLine());

        livroController.cadastrarLivro(livro);
        System.out.println("\n" + livro);
    }

}
