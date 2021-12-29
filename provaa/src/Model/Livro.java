package Model;

public class Livro {

    private String nomeLivro;
    private long idLivro;

    public Livro() {
    }

    public Livro(String nomeLivro, long idLivro) {
        this.nomeLivro = nomeLivro;
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", idLivro=" + idLivro +
                '}';
    }
}
