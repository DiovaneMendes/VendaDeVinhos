package br.com.vinhos.Component;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Entity.Item;
import org.springframework.stereotype.Component;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Component
public class ClienteComponent {

    public boolean validadorHistorico(HistoricoDTO historicoDTO, ClienteDTO clienteDTO){
        return historicoDTO.getCliente().equals("0" + formatadorCpf(clienteDTO.getCpf())) ||
                historicoDTO.getCliente().equals(formatadorCpf(clienteDTO.getCpf()));
    }

    public String formatadorCpf(String cpf){
        return cpf.replace("-", ".");
    }

    public List<Item> setHistoricoNoItem(Historico historico){
        return historico.getItens()
                .stream()
                .peek(item -> item.setHistorico(historico))
                .collect(toList());
    }

    public Double calculoValoresTotais(Cliente cliente){
        return cliente.getHistoricos()
                .stream()
                .mapToDouble(Historico::getValorTotal)
                .sum();
    }

    public Double verificaMaiorCompraUnica(Cliente cliente){
        return cliente.getHistoricos()
                .stream()
                .filter(historico -> historico.getData().getYear() == 2016)
                .mapToDouble(Historico::getValorTotal)
                .max()
                .orElse(0);
    }

    public List<Cliente> ordenamentoClienteMaiorMenor(List<Cliente> clientes){
        Collections.reverse(clientes);
        return clientes;
    }

    public Cliente clienteMaiorCompra(TreeMap<Double, Cliente> mapClientes){
        List<Cliente> clientes = new ArrayList<>(mapClientes.values());
        return ordenamentoClienteMaiorMenor(clientes).get(0);
    }

    public Double numeroDeHistoricos(Cliente cliente){
        return (double) cliente.getHistoricos().size();
    }

    public List<Item> ordenamentoItemMaiorMenor(List<Item> itens){
        Collections.reverse(itens);
        return itens;
    }

    public Set<Item> populaSet(Cliente cliente){
        Set<Item> itemSet = new HashSet<>();

        for(Historico historico: cliente.getHistoricos()){
            itemSet.addAll(historico.getItens());
        }

        return itemSet;
    }

    public TreeMap<Double, Item> geraItensRecomendacao(Set<Item> itens, Cliente cliente){
        TreeMap<Double, Item> mapItem = new TreeMap<>();

        for(Item itemDoSet: itens){
            Double contador = 0D;

            for(Historico historico: cliente.getHistoricos()){
                for(Item itemFor : historico.getItens() ){
                    if(itemDoSet.equals(itemFor)) contador++;
                }
            }

            mapItem.put(contador, itemDoSet);
        }

        return mapItem;
    }
}
