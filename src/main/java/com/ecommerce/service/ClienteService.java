package com.ecommerce.service;

import com.ecommerce.model.Cliente;
import com.ecommerce.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    public void cadastrarCliente(Cliente cliente) {
        clienteRepository.salvar(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteRepository.buscarPorNome(nome);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }

    public void atualizarCliente(Cliente cliente) {
        clienteRepository.atualizar(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clienteRepository.remover(cliente);
    }
} 