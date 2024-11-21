package entidades;

public class Cliente {

    // Atributos
    private String cpf;
    private String nome;

    // Construtor
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Metódo que busca um cliente pelo seu cpf
    public static Cliente buscarCliente(String cpf, Cliente[] clientes) {

        // Caso array nula ou vazia
        if (clientes == null || clientes.length == 0) {
            return null;
        }

        // Busca por cpf
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        // Caso não ache o cliente pelo cpf indicado
        return null;

    }

    @Override
    // Método toString
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}