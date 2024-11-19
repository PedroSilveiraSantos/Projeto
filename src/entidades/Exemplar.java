package entidades;

public class Exemplar extends Filme {

    // Atributos
    private Integer idExemplar;
    private Boolean disponivel;

    // Construtor
    public Exemplar(Integer idFilme, String titulo, String genero, String dataLancamento, Integer idExemplar, Boolean disponivel) {
        super(idFilme, titulo, genero, dataLancamento);
        this.idExemplar = idExemplar;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public Integer getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Integer idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    //TODO: Criar um método extra para a classe

    // Método toString
    @Override
    public String toString() {
        return "Exemplar{" +
                "idExemplar=" + idExemplar +
                ", disponivel=" + disponivel +
                "} " + super.toString();
    }

}