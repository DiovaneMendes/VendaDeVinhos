package br.com.vinhos.Component.Stub;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Entity.Item;

import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class ClienteComponentMock {

    public HistoricoDTO mockHistoricoDTO(){
        return HistoricoDTO.builder()
                .cliente("0000.000.000.02")
                .build();
    }

    public ClienteDTO mockClienteDTO(){
        return ClienteDTO.builder()
                .cpf("000.000.000-02")
                .build();
    }

    public Historico mockHistorico(){
        return Historico.builder()
                .itens(mockListaItens())
                .build();
    }

    public List<Item> mockListaItens(){
        return Arrays.asList(
                Item.builder()
                    .categoria("Tinto")
                    .build(),
                Item.builder()
                    .categoria("Branco")
                    .build(),
                Item.builder()
                    .categoria("Rosé")
                    .build()
        );
    }

    public List<Item> mockListaItensComHistorico(){
        return mockListaItens().stream()
                .peek(item -> item.setHistorico(mockHistorico()))
                .collect(toList());
    }

    public Cliente mockCliente(){
        return Cliente.builder()
                .historicos(
                    Arrays.asList(
                      Historico.builder()
                          .data( LocalDate.of(2015,7,1) )
                          .valorTotal(315.98)
                          .itens(mockListaItens())
                          .build(),
                      Historico.builder()
                          .data( LocalDate.of(2016,5,28) )
                          .valorTotal(264.75)
                          .itens(mockListaItens())
                          .build(),
                      Historico.builder()
                          .data( LocalDate.of(2016,10,15) )
                          .valorTotal(177.0)
                          .itens(mockListaItens())
                          .build(),
                      Historico.builder()
                          .data( LocalDate.of(2013,3,21) )
                          .valorTotal(428.30)
                          .itens(mockListaItens())
                          .build()
                    )
                )
                .build();
    }

    public List<Cliente> mockListaClientes(){
        return Arrays.asList(
            Cliente.builder().cpf("327.000.000-05").build(),
            Cliente.builder().cpf("890.000.000-02").build(),
            Cliente.builder().cpf("121.000.000-03").build(),
            Cliente.builder().cpf("997.000.000-08").build()
        );
    }

    public TreeMap<Double, Cliente> mockTreeMapCliente(){
        TreeMap<Double, Cliente> mapClientes = new TreeMap<>();

        mapClientes.put(328.60, Cliente.builder().cpf("890.000.000-02").build());
        mapClientes.put(560.98, Cliente.builder().cpf("997.000.000-08").build());
        mapClientes.put(127.50, Cliente.builder().cpf("327.000.000-05").build());
        mapClientes.put(554.00, Cliente.builder().cpf("121.000.000-03").build());

        return mapClientes;
    }

    public Set<Item> mockSetItens(){
        Set<Item> itens = new HashSet<>();

        itens.addAll( Arrays.asList(Item.builder().categoria("Tinto").build(),
                Item.builder().categoria("Branco").build(),
                Item.builder().categoria("Rosé").build()) );

        return itens;
    }
}