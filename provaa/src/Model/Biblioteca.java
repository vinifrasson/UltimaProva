package Model;

public class Biblioteca {

    private String nomeBiblioteca;
    private long idBiblioteca;
    private String endereco;

    public Biblioteca() {
    }

    public Biblioteca(String nomeBiblioteca, long idBiblioteca, String endereco) {
        this.nomeBiblioteca = nomeBiblioteca;
        this.idBiblioteca = idBiblioteca;
        this.endereco = endereco;
    }

    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }

    public long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nomeBiblioteca='" + nomeBiblioteca + '\'' +
                ", idBiblioteca=" + idBiblioteca +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
