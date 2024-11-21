package aplicacao;

import javax.swing.*;
import entidades.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Principal {

    public static void main(String[] args) {
        // Arrays de objetos
        Filme[] filmeArray = new Filme[100];
        Exemplar[] exemplarArray = new Exemplar[100];
        Cliente[] clienteArray = new Cliente[100];
        Emprestimo[] emprestimoArray = new Emprestimo[100];

        // Instanciando objetos
        Filme filme = new Filme(1, "O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", "19/12/2001");
        filmeArray[0] = filme;
        filme = new Filme(2, "Guerra nas Estrelas", "Ficção científica", "25/05/1977");
        filmeArray[1] = filme;
        filme = new Filme(3, "Clube da Luta", "Drama", "15/10/1999");
        filmeArray[2] = filme;
        filme = null;

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
        cliente = new Cliente("987-789", "Guilherme");
        clienteArray[6] = cliente;
        cliente = null;

        String[] opcoes = { "Cadastro de clientes", "Cadastro de filmes", "Cadastro de exemplares",
                "Realizar emprestimos", "Buscar um filme", "Buscar um cliente", "Listar exemplares",
                "Buscar exemplares disponiveis de um filme", "Sair" };

        String menu = "";
        byte opcoesContador = 0;

        // Construção do menu em formato de String
        for (String opcao : opcoes) {
            menu += opcoesContador + " - " + opcao + '\n';
            opcoesContador++;
        }

        Boolean repetirMenu = false;
        // Loop do menu
        do {

            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja realizar?\n\n" + menu + '\n',
                    "Locadora", JOptionPane.PLAIN_MESSAGE));
            repetirMenu = menu(escolha, clienteArray, filmeArray, exemplarArray, emprestimoArray);

        } while (repetirMenu);

    }

    // Método para controlar as opções do menu
    public static Boolean menu(int escolha, Cliente[] clientes, Filme[] filmes, Exemplar[] exemplares,
            Emprestimo[] emprestimos) {

        int tamanho;

        switch (escolha) {

            case 0:

                // Cadastro de clientes
                tamanho = tamanhoArrayCliente(clientes);
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
                return true;

            case 1:

                // Cadastro de filmes
                tamanho = tamanhoArrayFilme(filmes);
                Filme novoFilme = cadastrarFilme(filmes);
                if (tamanho != -1) {
                    if (novoFilme != null) {
                        filmes[tamanho] = novoFilme;
                        JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso.", "Locadora",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 2:

                // Cadastro de exemplares
                tamanho = tamanhoArrayExemplar(exemplares);
                Exemplar novoExemplar = cadastrarExemplar(filmes, exemplares);
                if (tamanho != -1) {
                    if (novoExemplar != null) {
                        exemplares[tamanho] = novoExemplar;
                        JOptionPane.showMessageDialog(null, "Exemplar cadastrado com sucesso.", "Locadora",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 3:

                // Realizar empréstimos
                tamanho = tamanhoArrayEmprestimo(emprestimos);
                Emprestimo novoEmprestimo = realizarEmprestimo(emprestimos, clientes, exemplares);
                if (tamanho != -1) {
                    if (novoEmprestimo != null) {
                        emprestimos[tamanho] = novoEmprestimo;
                        alterarDisponibilidade(novoEmprestimo, exemplares);
                        JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso.", "Locadora",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tamanho máximo atingido", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 4:

                // Busca um filme
                Filme filmeBuscado = buscarFilme(filmes);
                if (filmeBuscado != null) {
                    JOptionPane.showMessageDialog(null, "Filme encontrado:\n\n" + filmeBuscado.toString(), "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum filme", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 5:

                // Buscar um cliente
                Cliente clienteBuscado = buscarCliente(clientes);
                if (clienteBuscado != null) {
                    JOptionPane.showMessageDialog(null, "Cliente encontrado:\n\n" + clienteBuscado.toString(),
                            "Locadora", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum cliente com esse cpf", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 6:

                // Listar exemplares
                String textExemplares = Emprestimo.listarExemplares(exemplares);
                if (exemplares != null) {
                    JOptionPane.showMessageDialog(null, "Exemplares:\n\n" + textExemplares, "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há exemplares registrados", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                }
                return true;

            case 7:

                // Buscar exemplares disponíveis de um filme
                Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o id do filme procurado?\n",
                        "Locadora", JOptionPane.PLAIN_MESSAGE));
                int quantidadeDeExemplares = Exemplar.quantidadeExemplar(id, exemplares);
                if (quantidadeDeExemplares > 0) {
                    JOptionPane.showMessageDialog(null,
                            "Exemplares disponíveis para empréstimo:\n\n" + quantidadeDeExemplares, "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                } else if (quantidadeDeExemplares == 0) {
                    JOptionPane.showMessageDialog(null, "Não há exemplares disponíveis", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não há quaisquer exemplar registrado", "Locadora",
                            JOptionPane.PLAIN_MESSAGE);
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

    // Metódo que retorna a posição onde o novo cliente pode ser armazenado
    public static int tamanhoArrayCliente(Cliente array[]) {
        // Percorre o array de clientes e retorna o índice do primeiro elemento nulo
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        // Retorna -1 caso o array esteja cheio.
        return -1;
    }

    // Metódo para cadastrar novos clientes
    public static Cliente cadastrarCliente(Cliente clientes[]) {
        String cpf;

        // Solicita ao usuário o CPF, garantindo que ele não seja vazio ou nulo.
        do {
            cpf = JOptionPane.showInputDialog(null, "Informe o CPF: ", "Locadora", JOptionPane.PLAIN_MESSAGE);

            if (cpf == null || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum CPF inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (cpf == null || cpf.isEmpty());

        // Verifica se o CPF já existe no array de clientes.
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "O CPF informado já está registrado na locadora", "Locadora",
                        JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        String nome;

        // Solicita o nome do cliente, garantindo que ele não seja vazio ou nulo.
        do {
            nome = JOptionPane.showInputDialog(null, "Informe o nome: ", "Locadora", JOptionPane.PLAIN_MESSAGE);

            if (nome == null || nome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum nome inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (nome == null || nome.isEmpty());

        // Cria um novo cliente com os dados informados e o retorna.
        Cliente cliente = new Cliente(cpf, nome);
        return cliente;
    }

    public static int tamanhoArrayFilme(Filme[] array) {
        // Percorre o array de filmes e retorna o índice do primeiro elemento nulo.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        // Retorna -1 caso o array esteja cheio.
        return -1;
    }

    public static Filme cadastrarFilme(Filme[] filmes) {
        String idFilmeString;

        // Solicita o ID do filme, garantindo que ele não seja vazio ou nulo.
        do {
            idFilmeString = JOptionPane.showInputDialog(null, "Informe o id do filme: ", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);

            if (idFilmeString == null || idFilmeString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum id inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (idFilmeString == null || idFilmeString.isEmpty());

        Integer idFilme = Integer.parseInt(idFilmeString);

        // Verifica se o ID do filme já está registrado.
        for (Filme filme : filmes) {
            if (filme != null && filme.getIdFilme().equals(idFilme)) {
                JOptionPane.showMessageDialog(null, "O id do filme informado já está registrado na locadora",
                        "Locadora", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        String titulo;

        // Solicita o título do filme.
        do {
            titulo = JOptionPane.showInputDialog(null, "Informe o título do filme:", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);

            if (titulo == null || titulo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum título inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (titulo == null || titulo.isEmpty());

        String genero;

        // Solicita o gênero do filme.
        do {
            genero = JOptionPane.showInputDialog(null, "Informe o gênero do filme:", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);

            if (genero == null || genero.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum gênero inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (genero == null || genero.isEmpty());

        String dataLancamento;

        // Solicita a data de lançamento do filme.
        do {
            dataLancamento = JOptionPane.showInputDialog(null, "Informe a data de lançamento do filme:", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);

            if (dataLancamento == null || dataLancamento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma data de lançamento inserida", "Locadora",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (dataLancamento == null || dataLancamento.isEmpty());

        // Cria um novo filme com os dados informados e o retorna.
        Filme filme = new Filme(idFilme, titulo, genero, dataLancamento);
        return filme;
    }

    public static int tamanhoArrayExemplar(Exemplar[] array) {
        // Percorre o array de exemplares e retorna o índice do primeiro valor nulo
        // encontrado.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        // Retorna -1 se o array estiver cheio
        return -1;
    }

    // Cadastra um exemplar, verificando se o ID já existe e se está disponível para
    // locação
    public static Exemplar cadastrarExemplar(Filme[] filmes, Exemplar[] exemplares) {
        Filme filme = null;
        // Loop para garantir que um filme válido seja selecionado
        do {
            filme = buscarFilme(filmes);
        } while (filme == null);

        String idExemplarString;
        // Loop para garantir que o ID do exemplar seja informado
        do {
            idExemplarString = JOptionPane.showInputDialog(null, "Informe o id do exemplar: ", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);
            if (idExemplarString == null || idExemplarString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum id inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (idExemplarString == null || idExemplarString.isEmpty());

        Integer idExemplar = Integer.parseInt(idExemplarString);

        // Verifica se o ID do exemplar já está cadastrado
        for (Exemplar exemplar : exemplares) {
            if (exemplar != null && exemplar.getIdExemplar().equals(idExemplar)) {
                JOptionPane.showMessageDialog(null, "ID já registrado", "Locadora", JOptionPane.PLAIN_MESSAGE);
                return null;
            }
        }

        Boolean disponivel = null;
        // Loop para garantir que a disponibilidade seja corretamente definida
        do {
            String disponivelString;
            char disponivelTemp = ' ';
            do {
                disponivelString = JOptionPane.showInputDialog(null, "Está disponível? (s/n)", "Locadora",
                        JOptionPane.PLAIN_MESSAGE);
                if (disponivelString != null && !disponivelString.isEmpty()) {
                    disponivelTemp = disponivelString.charAt(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma opção", "Locadora", JOptionPane.ERROR_MESSAGE);
                }
            } while (disponivelString == null || disponivelString.isEmpty());

            if (disponivelTemp == 's' || disponivelTemp == 'S') {
                disponivel = true;
            } else if (disponivelTemp == 'n' || disponivelTemp == 'N') {
                disponivel = false;
            } else {
                JOptionPane.showMessageDialog(null, "Resposta inválida", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (disponivel == null);

        // Cria e retorna o exemplar com as informações fornecidas
        return new Exemplar(filme.getIdFilme(), filme.getTitulo(), filme.getGenero(), filme.getDataLancamento(),
                idExemplar, disponivel);
    }

    public static int tamanhoArrayEmprestimo(Emprestimo[] array) {

        // Percorre o array de exemplares e retorna o índice do primeiro valor nulo
        // encontrado.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        // Retorna -1 caso o array esteja cheio.
        return -1;

    }

    static Integer emprestimosContador = 1;

    // Realiza um empréstimo, registrando os exemplares emprestados e os clientes
    // envolvidos
    public static Emprestimo realizarEmprestimo(Emprestimo[] emprestimos, Cliente[] clientes, Exemplar[] exemplares) {
        Integer idEmprestimo = emprestimosContador;
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
        Cliente cliente = null;

        // Loop para garantir que um cliente válido seja selecionado
        do {
            cliente = buscarCliente(clientes);
        } while (cliente == null);

        Exemplar[] emprestimoExemplares = new Exemplar[10];
        Exemplar exemplar = null;
        Boolean maisExemplares = false;
        char escolha = ' ';

        // Loop para adicionar exemplares ao empréstimo
        do {
            do {
                exemplar = buscarExemplar(exemplares);
                // Verifica se o exemplar está disponível para empréstimo
                if (!exemplar.getDisponivel()) {
                    JOptionPane.showMessageDialog(null, "Exemplar não disponível", "Erro", JOptionPane.WARNING_MESSAGE);
                    exemplar = null;
                }
            } while (exemplar == null);

            emprestimoExemplares[emprestimosContador++] = exemplar;

            // Pergunta ao usuário se deseja alocar mais exemplares
            do {
                if (emprestimosContador < 10) {
                    String escolhaString;
                    do {
                        escolhaString = JOptionPane.showInputDialog(null, "Adicionar mais exemplares? (s/n)",
                                "Locadora", JOptionPane.PLAIN_MESSAGE);
                        if (escolhaString != null && !escolhaString.isEmpty()) {
                            escolha = escolhaString.charAt(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Digite uma opção", "Locadora",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } while (escolhaString == null || escolhaString.isEmpty());

                    if (escolha == 's' || escolha == 'S') {
                        maisExemplares = true;
                    } else if (escolha == 'n' || escolha == 'N') {
                        maisExemplares = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Resposta inválida", "Locadora", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Limite de exemplares atingido", "Locadora",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (escolha != 's' && escolha != 'S' && escolha != 'n' && escolha != 'N');
        } while (maisExemplares);

        // Cria o objeto Emprestimo e retorna
        return new Emprestimo(idEmprestimo, data, cliente, emprestimoExemplares);
    }

    // Metódo que altera a disponibilidade dos exemplares emprestados para não
    // disponível
    public static void alterarDisponibilidade(Emprestimo emprestimo, Exemplar[] exemplares) {
        for (Exemplar exemplar : exemplares) {
            for (Exemplar emprestimoExemplar : emprestimo.getExemplares()) {
                if (exemplar != null && emprestimoExemplar != null
                        && exemplar.getIdExemplar().equals(emprestimoExemplar.getIdExemplar())) {
                    exemplar.setDisponivel(false);
                    emprestimoExemplar.setDisponivel(false);
                }
            }
        }
    }

    // Busca um filme pelo ID e retorna o Filme correspondente
    public static Filme buscarFilme(Filme[] filmes) {
        String idFilmeString;

        // Loop para garantir que um ID de filme válido seja informado
        do {
            idFilmeString = JOptionPane.showInputDialog(null, "Informe o id do filme: ", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);
            if (idFilmeString == null || idFilmeString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum id inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (idFilmeString == null || idFilmeString.isEmpty());

        Integer id = Integer.parseInt(idFilmeString);
        return Filme.buscarFilme(id, filmes); // Retorna o filme encontrado
    }

    // Busca um cliente pelo CPF e retorna o Cliente correspondente
    public static Cliente buscarCliente(Cliente[] clientes) {
        String cpf;

        // Loop para garantir que o CPF seja informado
        do {
            cpf = JOptionPane.showInputDialog(null, "Informe o CPF: ", "Locadora", JOptionPane.PLAIN_MESSAGE);
            if (cpf == null || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum CPF inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (cpf == null || cpf.isEmpty());

        return Cliente.buscarCliente(cpf, clientes); // Retorna o cliente encontrado
    }

    // Busca um exemplar pelo ID e retorna o Exemplar correspondente
    public static Exemplar buscarExemplar(Exemplar[] exemplares) {
        String idExemplarString;

        // Loop para garantir que o ID do exemplar seja informado
        do {
            idExemplarString = JOptionPane.showInputDialog(null, "Informe o id do exemplar: ", "Locadora",
                    JOptionPane.PLAIN_MESSAGE);
            if (idExemplarString == null || idExemplarString.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum id inserido", "Locadora", JOptionPane.ERROR_MESSAGE);
            }
        } while (idExemplarString == null || idExemplarString.isEmpty());

        Integer id = Integer.parseInt(idExemplarString);

        // Busca e retorna o exemplar com o ID fornecido
        for (Exemplar exemplar : exemplares) {
            if (exemplar != null && id.equals(exemplar.getIdExemplar())) {
                return exemplar;
            }
        }

        // Caso não encontre o exemplar com o ID informado, exibe mensagem de erro
        JOptionPane.showMessageDialog(null, "Não há exemplar com o id procurado.", "Erro:1",
                JOptionPane.WARNING_MESSAGE);
        return null;
    }

}