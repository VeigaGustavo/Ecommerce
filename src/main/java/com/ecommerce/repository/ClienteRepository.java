package com.ecommerce.repository;

import com.ecommerce.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorNome(String nome) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.getNome().equals(nome))
                .findFirst();
        return cliente.orElse(null);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public void atualizar(Cliente cliente) {
        int index = clientes.indexOf(cliente);
        if (index != -1) {
            clientes.set(index, cliente);
        }
    }

    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }
} 