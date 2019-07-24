package br.com.vinhos.Factory;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.Entity.Cliente;

public abstract class ClienteFactory {

    public static Cliente getCliente(ClienteDTO clienteDTO){
        return Cliente.builder()
                .nome(clienteDTO.getNome())
                .cpf(clienteDTO.getCpf())
                .build();
    }

    public static ClienteDTO getCliente(Cliente cliente){
        return ClienteDTO.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
