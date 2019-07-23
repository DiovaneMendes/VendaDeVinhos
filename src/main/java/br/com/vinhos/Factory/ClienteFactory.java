package br.com.vinhos.Factory;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.Entity.Cliente;

public class ClienteFactory {

    public Cliente getCliente(ClienteDTO clienteDTO){
        return Cliente.builder()
                .nome(clienteDTO.getNome())
                .cpf(clienteDTO.getCpf())
                .build();
    }

    public ClienteDTO getCliente(Cliente cliente){
        return ClienteDTO.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
