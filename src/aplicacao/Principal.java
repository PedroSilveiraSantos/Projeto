package aplicacao;

import javax.swing.*;
import entidades.*;
import java.time.*;

public class Principal {

    public static void main(String[] args) {

        Filme[] filmeArray = new Filme[100];
        Exemplar[] exemplarArray = new Exemplar[100];
        Cliente[] clienteArray = new Cliente[100];
        Emprestimo[] emprestimoArray = new Emprestimo[100];

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
        cliente = new Cliente("321-123", "Lucca");
        clienteArray[3] = cliente;
        cliente = new Cliente("654-456", "Fernanda");
        clienteArray[4] = cliente;
        cliente = new Cliente("987-789", "Giovanna");
        clienteArray[5] = cliente;
        cliente = null;
        // TODO: A esse ponto vcs já sabem oq é pra fazer

        String[] opcoes = { "Cadastro de clientes", "Cadastro de filmes", "Cadastro de exemplares",
                "Realizar emprestimos", "Buscar um filme", "Buscar um cliente", "Listar exemplares",
                "Buscar exemplares disponiveis de um filme", "Sair" };

        String menu = "";
        byte opcoesContador = 0;

        for (String opcao : opcoes) {
            menu += opcoesContador + " - " + opcao + '\n';
            opcoesContador++;
        }

        Boolean repetirMenu = false;

        do {

            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja realizar?\n\n" + menu + '\n',
                "Locadora", JOptionPane.PLAIN_MESSAGE));
            repetirMenu = menu(escolha, clienteArray, filmeArray, exemplarArray, emprestimoArray);

        } while (repetirMenu);
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

    public static Boolean menu(int escolha, Cliente[] clientes, Filme[] filmes, Exemplar[] exemplares, Emprestimo[] emprestimos) {

        int tamanho;

        switch (escolha) {

            case 0:

                // Cadastro de clientes
                tamanho = tamanhoArrayCliente(clientes);
                Cliente novoCliente = cadastrarCliente(clientes);
                if (tamanho != -1) {
                    if (novoCliente != null) {
                        clientes[tamanho] = novoCliente;
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Locadora", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 1:

                // Cadastro de filmes
                tamanho = tamanhoArrayFilme(filmes);
                Filme novoFilme = cadastrarFilme(filmes);
                if (tamanho != -1) {
                    if (novoFilme != null) {
                        filmes[tamanho] = novoFilme;
                        JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso.", "Locadora", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 2:

                // Cadastro de exemplares
                tamanho = tamanhoArrayExemplar(exemplares);
                Exemplar novoExemplar = cadastrarExemplar(filmes, exemplares);
                if (tamanho != -1) {
                    if (novoExemplar != null) {
                        exemplares[tamanho] = novoExemplar;
                        JOptionPane.showMessageDialog(null, "Exemplar cadastrado com sucesso.", "Locadora", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 3:

                // Realizar empréstimos
                tamanho = tamanhoArrayEmprestimo(emprestimos);
                Emprestimo novoEmprestimo = realizarEmprestimo(emprestimos, clientes, exemplares);
                if (tamanho != -1) {
                    if (novoEmprestimo != null) {
                        emprestimos[tamanho] = novoEmprestimo;
                        JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso.", "Locadora", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 4:

                // Busca um filme
                Filme filmeBuscado = buscarFilme(filmes);
                if (filmeBuscado != null) {
                    JOptionPane.showMessageDialog(null, "Filme encontrado:\n\n" + filmeBuscado.toString(), "Locadora", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum filme", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 5:

                // Buscar um cliente
                Cliente clienteBuscado = buscarCliente(clientes);
                if (clienteBuscado != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado:\n\n" + clienteBuscado.toString(), "Locadora", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum cliente com esse cpf", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 6:

                // Listar exemplares
                String textExemplares = Emprestimo.listarExemplares(exemplares);
                if(exemplares != null){
                    JOptionPane.showMessageDialog(null, "Exemplares:\n\n" + textExemplares, "Locadora", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há exemplares registrados", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 7:

                // Buscar exemplares disponíveis de um filme
                Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o id do filme procurado?\n", "Locadora", JOptionPane.PLAIN_MESSAGE));
                int quantidadeDeExemplares = Exemplar.quantidadeExemplar(id, exemplares);
                if(quantidadeDeExemplares > 0){
                    JOptionPane.showMessageDialog(null, "Exemplares disponíveis para empréstimo:\n\n" + quantidadeDeExemplares, "Locadora", JOptionPane.PLAIN_MESSAGE);
                }else if (quantidadeDeExemplares == 0){
                    JOptionPane.showMessageDialog(null, "Não há exemplares disponíveis", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Não há quaisquer exemplar registrado", "Locadora", JOptionPane.PLAIN_MESSAGE);
                }
                return true;                

            case 8:
            
                // Fecha o programa ao retornar para a main
                return false;

            default:

                // Caso seja uma opção inválida.
                JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.WARNING_MESSAGE);
                return true;

        }
    }

    public static int tamanhoArrayCliente(Cliente array[]) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public static Cliente cadastrarCliente(Cliente clientes[]) {
        String cpf = JOptionPane.showInputDialog(null, "Informe o CPF: ", "Locadora", JOptionPane.PLAIN_MESSAGE);
        String nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "Locadora", JOptionPane.PLAIN_MESSAGE);

        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "O CPF informado já está registrado na locadora", "Locadora",
                        JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        Cliente cliente = new Cliente(cpf, nome);
        return cliente;
    }

    public static int tamanhoArrayFilme(Filme[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public static Filme cadastrarFilme(Filme[] filmes) {
        Integer idFilme = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Informe o id do filme: ", "Locadora", JOptionPane.PLAIN_MESSAGE));
        String titulo = JOptionPane.showInputDialog(null, "Informe o título do filme: ", "Locadora",
                JOptionPane.PLAIN_MESSAGE);
        String genero = JOptionPane.showInputDialog(null, "Informe o gênero do filme: ", "Locadora",
                JOptionPane.PLAIN_MESSAGE);
        String dataLancamento = JOptionPane.showInputDialog(null, "Informe a data de lançamento do filme: ", "Locadora",
                JOptionPane.PLAIN_MESSAGE);

        for (Filme filme : filmes) {
            if (filme != null && filme.getIdFilme().equals(idFilme)) {
                JOptionPane.showMessageDialog(null, "O id do filme informado já está registrado na locadora",
                        "Locadora", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        Filme filme = new Filme(idFilme, titulo, genero, dataLancamento);
        return filme;
    }

    public static int tamanhoArrayExemplar(Exemplar[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    public static Exemplar cadastrarExemplar(Filme[] filmes, Exemplar[] exemplares) {

        Filme filme = null;
        do {

            filme = buscarFilme(filmes);

        } while (filme == null);

        Integer idExemplar = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Informe o id do exemplar: ", "Locadora", JOptionPane.PLAIN_MESSAGE));
        Boolean disponivel = null;

        do {

            char disponivelTemp = JOptionPane
                    .showInputDialog(null, "O exemplar está disponível? (s/n)", "Locadora", JOptionPane.PLAIN_MESSAGE)
                    .charAt(0);
            if (disponivelTemp == 's' || disponivelTemp == 'S') {
                disponivel = true;
            } else if (disponivelTemp == 'n' || disponivelTemp == 'N') {
                disponivel = false;
            } else {
                JOptionPane.showMessageDialog(null, "Resposta inválida", "Locadora", JOptionPane.ERROR_MESSAGE);
            }

        } while (disponivel == null);

        for (Exemplar exemplar : exemplares) {
            if (exemplar != null && exemplar.getIdExemplar().equals(idExemplar)) {
                JOptionPane.showMessageDialog(null, "O id do exemplar informado já está registrado na locadora",
                        "Locadora", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        Exemplar exemplar = new Exemplar(filme.getIdFilme(), filme.getTitulo(), filme.getGenero(),
                filme.getDataLancamento(), idExemplar, disponivel);
        return exemplar;

    }

    public static int tamanhoArrayEmprestimo(Emprestimo[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;

    }

    static Integer emprestimosContador = 0;

    public static Emprestimo realizarEmprestimo(Emprestimo[] emprestimos, Cliente[] clientes, Exemplar[] exemplares) {

        Integer idEmprestimo = emprestimosContador;
        String data = LocalDate.now().toString();
        Cliente cliente = null;

        do {

            cliente = buscarCliente(clientes);

        } while (cliente == null);

        Exemplar[] emprestimoExemplares = new Exemplar[10];
        Exemplar exemplar = null;
        Boolean maisExemplares = false;
        char escolha = ' ';

        do {
            
            do {
    
                exemplar = buscarExemplar(exemplares);
    
            } while (exemplar == null);

            emprestimoExemplares[emprestimosContador++] = exemplar;

            do {

                if (emprestimosContador >= 10) {
                    escolha = JOptionPane
                    .showInputDialog(null, "Mais exemplares foram emprestados? (s/n)", "Locadora", JOptionPane.PLAIN_MESSAGE)
                    .charAt(0);
                    if (escolha == 's' || escolha == 'S') {
                        maisExemplares = true;
                    } else if (escolha == 'n' || escolha == 'N') {
                        maisExemplares = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Resposta inválida", "Locadora", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "O limite máximo de exemplares por empréstimo foi atingido", "Locadora", JOptionPane.ERROR_MESSAGE);
                }

            } while (escolha != 's' && escolha != 'S' && escolha != 'n' && escolha != 'N' && emprestimosContador < 10);

        } while (maisExemplares == true);

        Emprestimo emprestimo = new Emprestimo(idEmprestimo, data, cliente, emprestimoExemplares);
        return emprestimo;
    }

    public static Filme buscarFilme(Filme[] filmes) {

        Integer id = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Informe o id do filme: ", "Locadora", JOptionPane.PLAIN_MESSAGE));
        Filme filme = Filme.buscarFilme(id, filmes);
        return filme;

    }

    public static Cliente buscarCliente(Cliente[] clientes) {
        String cpf = JOptionPane.showInputDialog(null, "Informe o cpf do cliente:", "Locadora",
                JOptionPane.PLAIN_MESSAGE);
        Cliente cliente = Cliente.buscarCliente(cpf, clientes);
        return cliente;
    }

    public static Exemplar buscarExemplar(Exemplar[] exemplares) {

        Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o id do exemplar: ", "Locadora", JOptionPane.PLAIN_MESSAGE));
        
        for (Exemplar exemplar : exemplares) {
            if (exemplar != null && id.equals(exemplar.getIdExemplar())) {
                return exemplar;
            }
        }

        JOptionPane.showMessageDialog(null, "Não há exemplar com o id procurado.", "Erro:1", JOptionPane.WARNING_MESSAGE);
        return null;

    }

}