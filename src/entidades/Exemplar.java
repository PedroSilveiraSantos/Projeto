package entidades;

public class Exemplar extends Filme {

    // Atributos
    private Integer idExemplar;
    private Boolean disponivel;

    // Construtor
    public Exemplar(Integer idFilme, String titulo, String genero, String dataLancamento, Integer idExemplar,
            Boolean disponivel) {
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

    // Metódo que retorna a quantidade de exemplares disponíveis de um filme com
    // base no id do filme
    public static int quantidadeExemplar(Integer id, Exemplar[] exemplares) {

        int cont = 0;
        // Caso array nula ou vazia
        if (exemplares == null || exemplares.length == 0) {
            return -1;
        }

        // Busca por exemplares não nulos disponiveis
        for (Exemplar exemplar : exemplares) {
            if (exemplar != null && exemplar.getIdFilme().equals(id) && exemplar.getDisponivel()) {
                cont += 1;
            }
        }

        if (cont == 0) { // Caso nenhum exemplar disponível
            return 0;
        }

        // Caso haja exemplares
        return cont;

    }

    // Método toString
    @Override
    public String toString() {
        return "Exemplar{" +
                "idExemplar=" + idExemplar +
                ", disponivel=" + disponivel +
                "} " + super.toString();
    }

}