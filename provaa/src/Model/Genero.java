package Model;

public class Genero {

    private String nomeGenero;
    private long idGenero;

    public Genero() {
    }

    public Genero(String nomeGenero, long idGenero) {
        this.nomeGenero = nomeGenero;
        this.idGenero = idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(long idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nomeGenero='" + nomeGenero + '\'' +
                ", idGenero=" + idGenero +
                '}';
    }
}
