package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private String email;
    private final List<Pedido> historicoPedidos;

    public Cliente(String nome, String endereco, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.historicoPedidos = new ArrayList<>();
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void adicionarPedidoAoHistorico(Pedido pedido) {
        historicoPedidos.add(pedido);
    }

    public void exibirHistoricoPedidos() {
        if (historicoPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
            return;
        }

        System.out.println("Histórico de Pedidos do model.Cliente " + nome + ":");
        for (Pedido pedido : historicoPedidos) {
            System.out.println(pedido);  // Supondo que model.Pedido tenha um toString() bem definido
        }
    }

    @Override
    public String toString() {
        return "model.Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", total de pedidos=" + historicoPedidos.size() +
                '}';
    }
}
