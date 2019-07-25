package br.com.vinhos.Factory;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.Entity.Cliente;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public static List<ClienteDTO> getListClienteDTO(List<Cliente> clientes){
        return clientes.stream()
                .map(ClienteFactory::getCliente)
                .collect(toList());
    }
}
