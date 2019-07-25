package br.com.vinhos.Service;

import br.com.vinhos.Component.ClienteComponent;
import br.com.vinhos.Component.RequestAPI;
import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Entity.Item;
import br.com.vinhos.Factory.ClienteFactory;
import br.com.vinhos.Factory.HistoricoFactory;
import br.com.vinhos.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteComponent clienteComponent;

    @Transactional(rollbackFor = Exception.class)
    public void popularBanco() {
        if( clienteRepository.findAll().isEmpty() ) {
            List<HistoricoDTO> historicoDTOS = RequestAPI.historico();
            List<ClienteDTO> clienteDTOS = RequestAPI.cliente();

            for (ClienteDTO clienteDTO: clienteDTOS) {
                Cliente cliente = ClienteFactory.getCliente(clienteDTO);

                List<Historico> historicosCliente = historicoDTOS.stream()
                        .filter(historicoDTO -> clienteComponent.validadorHistorico(historicoDTO, clienteDTO))
                        .map(HistoricoFactory::getHistorico)
                        .peek(historico -> historico.setItens(clienteComponent.setHistoricoNoItem(historico)) )
                        .peek(historico -> historico.setCliente(cliente))
                        .collect(toList());

                cliente.setHistoricos(historicosCliente);

                clienteRepository.save(cliente);
            }
        }
    }

    public List<Cliente> todos(){
        return clienteRepository.findAll();
    }

    public List<Cliente> ordenadoMaiorValorTotal(){
        TreeMap<Double, Cliente> mapClientes = new TreeMap<>();

        for ( Cliente cliente: clienteRepository.findAll() ){
            Double valorTotal = clienteComponent.calculoValoresTotais(cliente);

            mapClientes.put(valorTotal, cliente);
        }

        List<Cliente> clientes = new ArrayList<>(mapClientes.values());

        return clienteComponent.ordenamentoClienteMaiorMenor(clientes);
    }

    public Cliente maiorCompraUnicaDoisMilEDezesseis(){
        TreeMap<Double, Cliente> mapClientes = new TreeMap<>();

        for ( Cliente cliente: clienteRepository.findAll() ){
            Double maiorCompraUnica = clienteComponent.verificaMaiorCompraUnica(cliente);

            mapClientes.put(maiorCompraUnica, cliente);
        }

        return clienteComponent.clienteMaiorCompra(mapClientes);
    }

    public List<Cliente> clientesMaisFieis(){
        TreeMap<Double, Cliente> mapClientes = new TreeMap<>();

        for ( Cliente cliente: clienteRepository.findAll() ){
            Double numeroHistorico = clienteComponent.numeroDeHistoricos(cliente);

            mapClientes.put(numeroHistorico, cliente);
        }

        List<Cliente> clientes = new ArrayList<>(mapClientes.values());

        return clienteComponent.ordenamentoClienteMaiorMenor(clientes);
    }

    public Item recomendacaoVinho(Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if(clienteOptional.isPresent()){
            TreeMap<Double, Item> mapItem = new TreeMap<>();
            Cliente cliente = clienteOptional.orElse(new Cliente());
            Set<Item> itemSet = new HashSet<>();

            for(Historico historico: cliente.getHistoricos()){
                itemSet.addAll(historico.getItens());
            }

            for(Item itemDoSet: itemSet){
                Double contador = 0D;

                for(Historico historico: cliente.getHistoricos()){
                    for(Item itemFor : historico.getItens() ){
                        if(itemDoSet.equals(itemFor)) contador++;
                    }
                }

                mapItem.put(contador, itemDoSet);
            }

            List<Item> itens = new ArrayList<>(mapItem.values());

            return clienteComponent.ordenamentoItemMaiorMenor(itens).get(0);
        }

        return new Item();
    }
}
