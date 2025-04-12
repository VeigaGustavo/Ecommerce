package com.ecommerce.view;

import com.ecommerce.controller.ClienteController;
import com.ecommerce.exception.PedidoVazioException;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws PedidoVazioException {
        int opcao;
        do {
            System.out.println("\n=== Sistema de E-commerce ===");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("3 - Gerenciar Carrinhos");
            System.out.println("4 - Gerenciar Pedidos");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    ClienteController.gerenciarCliente();
                    break;
                case 2:
                    // TODO: Implementar gerenciamento de produtos
                    System.out.println("Funcionalidade em desenvolvimento");
                    break;
                case 3:
                    // TODO: Implementar gerenciamento de carrinhos
                    System.out.println("Funcionalidade em desenvolvimento");
                    break;
                case 4:
                    // TODO: Implementar gerenciamento de pedidos
                    System.out.println("Funcionalidade em desenvolvimento");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
} 