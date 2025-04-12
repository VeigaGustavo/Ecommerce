package com.ecommerce.controller;

import com.ecommerce.model.Cliente;
import com.ecommerce.service.ClienteService;

import java.util.Scanner;

public class ClienteController {
    private static final ClienteService clienteService = new ClienteService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void gerenciarCliente() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Clientes");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Consultar Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Remover Cliente");
            System.out.println("5 - Listar Clientes");
            System.out.println("6 - Voltar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, email);
        clienteService.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void consultarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorNome(nome);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void atualizarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorNome(nome);
        if (cliente != null) {
            System.out.print("Novo endereço: ");
            cliente.setEndereco(scanner.nextLine());
            System.out.print("Novo email: ");
            cliente.setEmail(scanner.nextLine());
            clienteService.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void removerCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = clienteService.buscarClientePorNome(nome);
        if (cliente != null) {
            clienteService.removerCliente(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void listarClientes() {
        System.out.println("\nLista de Clientes:");
        clienteService.listarClientes().forEach(System.out::println);
    }
}
