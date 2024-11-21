package entidades;

public class Emprestimo {

    // Atributos
    private Integer idEmprestimo;
    private String data;
    private Cliente cliente;
    private Exemplar[] exemplares = new Exemplar[10];

    // Construtor
    public Emprestimo(Integer idEmprestimo, String data, Cliente cliente, Exemplar[] exemplares) {
        this.idEmprestimo = idEmprestimo;
        this.data = data;
        this.cliente = cliente;
        this.exemplares = exemplares;
    }

    // Getters e Setters
    public Integer getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Integer idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Exemplar[] getExemplares() {
        return exemplares;
    }

    public void setExemplares(Exemplar[] exemplares) {
        this.exemplares = exemplares;
    }

    // Método que lista os exemplares
    public static String listarExemplares(Exemplar[] exemplares) {
        String lista = "";
        for (Exemplar exemplar : exemplares) {
            if (exemplar != null) {
                lista += exemplar.toString() + '\n';
            }
        }
        return lista;
    }

    // Método toString
    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", data='" + data + '\'' +
                ", cliente=" + cliente +
                ", exemplares=" + listarExemplares(exemplares) +
                '}';
    }

}