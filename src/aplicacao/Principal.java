package aplicacao;

import javax.swing.*;
import entidades.*;

public class Principal {

    public static void main(String[] args) {

        Filme filmeArray[] = new Filme[100];
        Exemplar exemplarArray[] = new Exemplar[100];
        Cliente clienteArray[] = new Cliente[100];

        Filme filme = new Filme(1, "O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", "19/12/2001");
        filmeArray[0] = filme;
        filme = new Filme(2, "Guerra nas Estrelas", "Ficção científica", "25/05/1977");
        filmeArray[1] = filme;
        filme = new Filme(3, "Clube da Luta", "Drama", "15/10/1999");
        filmeArray[2] = filme;
        filme = null;
        // TODO: Usa esse obj filme para passar os novos filmes

        Exemplar exemplar = new Exemplar(1, "O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", "19/12/2001", 1,
                true);
        exemplarArray[0] = exemplar;
        exemplar = new Exemplar(1, "O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", "19/12/2001", 2, false);
        exemplarArray[1] = exemplar;
        exemplar = new Exemplar(2, "Guerra nas Estrelas", "Ficção científica", "25/05/1977", 3, true);
        exemplarArray[2] = exemplar;
        exemplar = new Exemplar(2, "Guerra nas Estrelas", "Ficção científica", "25/05/1977", 4, true);
        exemplarArray[3] = exemplar;
        exemplar = new Exemplar(3, "Clube da Luta", "Drama", "15/10/1999", 5, false);
        exemplarArray[4] = exemplar;
        exemplar = new Exemplar(3, "Clube da Luta", "Drama", "15/10/1999", 6, false);
        exemplarArray[5] = exemplar;
        exemplar = null;
        // TODO: Mesmo caso de filme

        Cliente cliente = new Cliente("123-321", "Marco");
        clienteArray[0] = cliente;
        cliente = new Cliente("456-654", "Albert");
        clienteArray[1] = cliente;
        cliente = new Cliente("789-987", "Pedro");
        clienteArray[2] = cliente;
        cliente = null;
        // TODO: A esse ponto vcs já sabem oq é pra fazer

        Object[] opcoes = { "Cadastro de clientes", "Cadastro de filmes", "Cadastro de exemplares",
                "Realizar emprestimos", "Buscar um filme", "Buscar um cliente", "Listar exemplares",
                "Buscar exemplares disponiveis de um filme" };
        int escolha = JOptionPane.showOptionDialog(null, "O que deseja realizar?", "Locadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
        Menu(escolha);
        // TODO: Fazer as opções ficarem uma embaixo da outra
        // Filme filme1 = new Filme(1, "O Senhor dos Anéis: A Sociedade do Anel",
        // "Fantasia", "19/12/2001");
        // filmeArray[0] = filme1;
        // Filme filme2 = new Filme(2, "Guerra nas Estrelas", "Ficção científica",
        // "25/05/1977");
        // filmeArray[1] = filme2;
        // Filme filme3 = new Filme(3, "Clube da Luta", "Drama", "15/10/1999");
        // filmeArray[2] = filme3;

        // Exemplar exemplar1 = new Exemplar(1, "O Senhor dos Anéis: A Sociedade do
        // Anel", "Fantasia", "19/12/2001", 1, true);
        // exemplarArray[0] = exemplar1;
        // Exemplar exemplar2 = new Exemplar(1, "O Senhor dos Anéis: A Sociedade do
        // Anel", "Fantasia", "19/12/2001", 2, false);
        // exemplarArray[1] = exemplar2;
        // Exemplar exemplar3 = new Exemplar(2, "Guerra nas Estrelas", "Ficção
        // científica", "25/05/1977", 3, true);
        // exemplarArray[2] = exemplar3;
        // Exemplar exemplar4 = new Exemplar(2, "Guerra nas Estrelas", "Ficção
        // científica", "25/05/1977", 4, true);
        // exemplarArray[3] = exemplar4;
        // Exemplar exemplar5 = new Exemplar(3, "Clube da Luta", "Drama", "15/10/1999",
        // 5, false);
        // exemplarArray[4] = exemplar5;
        // Exemplar exemplar6 = new Exemplar(3, "Clube da Luta", "Drama", "15/10/1999",
        // 6, false);
        // exemplarArray[5] = exemplar6;

        // Cliente cliente1 = new Cliente ("123-321", "Marco");
        // clienteArray[0] = cliente1;
        // Cliente cliente2 = new Cliente ("456-654", "Albert");
        // clienteArray[1] = cliente2;
        // Cliente cliente3 = new Cliente ("789-987", "Pedro");
        // clienteArray[2] = cliente3;
    }

    public static void Menu(int escolha, Cliente clientes[], Filme filmes[], Exemplar exemplares[]) {
        switch (escolha) {
            case 0:

                // Cadastro de clientes
                int tamanho = TamanhoArrayCliente(clientes);
                Cliente novoCliente = cadastrarCliente(clientes);
                if (tamanho != -1) {
                    if (novoCliente != null) {
                        clientes[tamanho] = novoCliente;
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Locadora",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                break;

            case 1:

                // Cadastro de filmes

            case 2:

                // C adastro de exemplares

            case 3:

                // Realizar empréstimos

            case 4:

                // Busca um filme

            case 5:

                // Buscar um cliente

            case 6:

                // Listar exemplares

            case 7:

                // Buscar exemplares disponíveis de um filme

            default:

                // Caso seja uma opção inválida ou usuário fechar o menu.

        }
    }

    public static int TamanhoArrayCliente(Cliente array[]) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public static Cliente cadastrarCliente(Cliente clientes[]) {
        String cpf = JOptionPane.showInputDialog(null, "Informe o cpf: ", "Locadora", JOptionPane.PLAIN_MESSAGE);
        String nome = JOptionPane.showInputDialog(null, "informe o nome: ", "Locadora", JOptionPane.PLAIN_MESSAGE);

        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "O cpf informado já está registrado na locadora", "Locadora",
                        JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        Cliente cliente = new Cliente(cpf, nome);
        return cliente;
    }
}