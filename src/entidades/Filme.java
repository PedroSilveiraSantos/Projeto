package entidades;

public class Filme {

    // Atributos
    private Integer idFilme;
    private String titulo;
    private String genero;
    private String dataLancamento;

    // Construtor
    public Filme(Integer idFilme, String titulo, String genero, String dataLancamento) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    //TODO: Criar um método extra para a classe

    // Método toString
    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

}