import exceptions.PedidoVazioException;
import exceptions.ProdutoJaExisteNoCarrinhoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Map<Cliente, Carrinho> carrinhos = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws PedidoVazioException {
        // Inicializar clientes
        Cliente cliente1 = new Cliente("Cliente1", "Endereço1", "email1@example.com");
        Cliente cliente2 = new Cliente("Cliente2", "Endereço2", "email2@example.com");
        Cliente cliente3 = new Cliente("Cliente3", "Endereço3", "email3@example.com");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Inicializar produtos
        Produto produto1 = new Eletronicos("Produto1", 100.0f, "Descrição1", "Marca1", "1 ano");
        Produto produto2 = new Livros("Produto2", 50.0f, "Descrição2", "Autor1", "Editora1");
        Produto produto3 = new Roupas("Produto3", 30.0f, "Descrição3", "M", "Azul");
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        // Adicionar produtos ao carrinho do cliente1
        Carrinho carrinho1 = new Carrinho(null);
        try {
            carrinho1.adicionarProduto(produto1);
            carrinho1.adicionarProduto(produto2);
            carrinho1.adicionarProduto(produto3);
        } catch (ProdutoJaExisteNoCarrinhoException e) {
            System.out.println(e.getMessage());
        }
        carrinhos.put(cliente1, carrinho1);

        // Continuar com o menu principal
        int opcao;
        do {
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Produto");
            System.out.println("3 - Carrinho");
            System.out.println("4 - Pedido");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    gerenciarCliente();
                    break;
                case 2:
                    gerenciarProduto();
                    break;
                case 3:
                    gerenciarCarrinho();
                    break;
                case 4:
                    gerenciarPedido();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    //Methods Cliente
    private static void gerenciarCliente() {
        int opcao;
        do {
            System.out.println("Cliente");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Visualizar Clientes");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Histórico de Compras");
            System.out.println("5 - Retornar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    visualizarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    historicoCompras();
                    break;
                case 5:
                    System.out.println("Voltando ao MENU INICIAL...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, endereco, email);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void visualizarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    private static void atualizarCliente() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                System.out.print("Novo nome: ");
                cliente.setNome(scanner.nextLine());
                System.out.print("Novo endereço: ");
                cliente.setEndereco(scanner.nextLine());
                System.out.print("Novo email: ");
                cliente.setEmail(scanner.nextLine());
                System.out.println("Cliente atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    //Methods Produto
    private static void gerenciarProduto() {
        int opcao;
        do {
            System.out.println("Produtos");
            System.out.println("1-Cadastrar Produto");
            System.out.println("2-Consultar Produto");
            System.out.println("3-Remover Produto");
            System.out.println("4-Atualizar Produto");
            System.out.println("5-Voltar ao MENU INICIAL");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    consultarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    System.out.println("Voltando ao MENU INICIAL...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        float precoProduto = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.println("Categoria do Produto: ");
        System.out.println("1- Eletrônicos");
        System.out.println("2- Livros");
        System.out.println("3- Roupas");

        System.out.print("Escolha a categoria do produto: ");
        int categoriaEscolhida = scanner.nextInt();
        scanner.nextLine();

        switch (categoriaEscolhida) {
            case 1:
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Garantia: ");
                String garantia = scanner.nextLine();
                produtos.add(new Eletronicos(nome, precoProduto, descricao, marca, garantia));
                break;
            case 2:
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("Editora: ");
                String editora = scanner.nextLine();
                produtos.add(new Livros(nome, precoProduto, descricao, autor, editora));
                break;
            case 3:
                System.out.print("Tamanho: ");
                String tamanho = scanner.nextLine();
                System.out.print("Cor: ");
                String cor = scanner.nextLine();
                produtos.add(new Roupas(nome, precoProduto, descricao, tamanho, cor));
                break;
            default:
                System.out.println("Categoria inválida!");
        }
    }

    private static void consultarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println(produto);
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private static void removerProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private static void atualizarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.print("Novo nome: ");
                produto.setNome(scanner.nextLine());
                System.out.print("Novo preço: ");
                produto.setPreco(scanner.nextFloat());
                scanner.nextLine();
                System.out.print("Nova descrição: ");
                produto.setDescricao(scanner.nextLine());
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }


    //Methods Carrinho
    private static void gerenciarCarrinho() throws PedidoVazioException {
        int opcao;
        do {
            System.out.println("Carrinho");
            System.out.println("1-Adicionar Produto ao Carrinho");
            System.out.println("2-Remover Produto do Carrinho");
            System.out.println("3-Consultar Carrinho");
            System.out.println("4-Finalizar Compra");
            System.out.println("5-Voltar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProdutoCarrinho();
                    break;
                case 2:
                    removerProdutoCarrinho();
                    break;
                case 3:
                    consultarCarrinho();
                    break;
                case 4:
                    finalizarCompra();
                    break;
                case 5:
                    System.out.println("Voltando ao MENU INICIAL...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void adicionarProdutoCarrinho()  {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                System.out.println("Produtos disponíveis:");
                for (int j = 0; j < produtos.size(); j++) {
                    System.out.println((j + 1) + "- " + produtos.get(j).getNome());
                }
                System.out.print("Escolha o produto: ");
                int produtoEscolhido = scanner.nextInt();
                scanner.nextLine();

                if (produtoEscolhido > 0 && produtoEscolhido <= produtos.size()) {
                    Carrinho carrinho = carrinhos.get(cliente);
                    if (carrinho == null) {
                        Produto produtoInicial = produtos.get(0); // Produto inicial
                        carrinho = new Carrinho(produtoInicial);
                        carrinhos.put(cliente, carrinho);
                    }
                    try {
                        carrinho.adicionarProduto(produtos.get(produtoEscolhido - 1));
                        System.out.println("Produto adicionado ao carrinho com sucesso!");
                    } catch (ProdutoJaExisteNoCarrinhoException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Produto inválido!");
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    private static void removerProdutoCarrinho() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente foi encontrado");
                Carrinho carrinho = carrinhos.get(cliente);
                if (carrinho == null || carrinho.getProdutos().isEmpty()) {
                    System.out.println("Carrinho vazio ou inexistente!");
                    return;
                }

                System.out.println("Produtos no Carrinho:");
                List<Produto> produtosCarrinho = new ArrayList<>(carrinho.getProdutos().keySet());
                for (int i = 0; i < produtosCarrinho.size(); i++) {
                    System.out.println( produtosCarrinho.get(i).getNome());
                }

                System.out.print("Nome do produto para remover: ");
                String escolhido = scanner.nextLine();
                boolean success = false;
                for (Produto p: produtosCarrinho)
                {
                    if (p.getNome().equals(escolhido))
                    {
                        carrinho.removerProduto(p);
                        System.out.println(p.getNome() + " foi removido do carrinho!");
                        success = true;
                    }
                }
                if (!success) {

                    System.out.println("Não foi possível remover o produto.");
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    private static void consultarCarrinho() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                Carrinho carrinho = carrinhos.get(cliente);
                if (!carrinho.getProdutos().isEmpty()) //o carrinho nao eh nulo, so eh vazio apos apagar todos os itens
                {

                    System.out.println("Produtos no carrinho:");
                    for (Map.Entry<Produto, Integer> entry : carrinho.getItens().entrySet()) {
                        Produto produto = entry.getKey();
                        Integer quantidade = entry.getValue();
                        System.out.println(produto.getNome() + " - " + quantidade + " unidade(s)");
                    }
                } else {
                    System.out.println("Carrinho vazio!");
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    private static void finalizarCompra() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();


        System.out.println("Cliente não encontrado!");
    }

    //Methods Pedido
    private static void gerenciarPedido() {
        int opcao;
        do {
            System.out.println("Pedidos");
            System.out.println("1-Atualizar Status do Pedido");
            System.out.println("2-Exibir Pedido");
            System.out.println("3-Voltar ao Menu Inicial");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    atualizarStatusPedido();
                    break;
                case 2:
                    exibirPedido();
                    break;
                case 3:
                    System.out.println("Voltando ao MENU INICIAL...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private static void atualizarStatusPedido() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Pedidos do Cliente:");
        for (Pedido pedido : pedidos) {
            if (clienteEncontrado.getHistoricoPedidos().contains(pedido)) {
                System.out.println("ID: " + pedido.getId() + " - Status: " + pedido.getStatus());
            }
        }

        System.out.print("ID do Pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id && clienteEncontrado.getHistoricoPedidos().contains(pedido)) {
                System.out.println("Itens do Pedido:");
                for (Map.Entry<Produto, Integer> entry : pedido.getItens().entrySet()) {
                    Produto produto = entry.getKey();
                    Integer quantidade = entry.getValue();
                    System.out.println(produto.getNome() + " - " + quantidade + " unidade(s)");
                }
                System.out.print("Novo status do Pedido: ");
                String novoStatus = scanner.nextLine();
                pedido.atualizarStatus(novoStatus);
                System.out.println("Status do pedido atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Pedido não encontrado!");
    }

    private static void exibirPedido() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        boolean pedidoEncontrado = false;

        for (Pedido pedido : pedidos) {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equals(nome) && cliente.getHistoricoPedidos().contains(pedido)) {
                    if (!pedido.getItens().isEmpty()) {
                        System.out.println("Pedido #" + pedido.getId() + "- Status Atual (" + pedido.getStatus() + "):");
                        for (Map.Entry<Produto, Integer> entry : pedido.getItens().entrySet()) {
                            Produto produto = entry.getKey();
                            Integer quantidade = entry.getValue();
                            System.out.println(produto.getNome() + " - " + quantidade + " unidade(s)");
                        }
                        pedidoEncontrado = true;
                    }
                }
            }
        }
        if (!pedidoEncontrado) {
            System.out.println("Carrinho vazio ou cliente não possui pedidos!");
        }
    }

    private static void historicoCompras() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                cliente.exibirHistoricoPedidos();
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

}