package br.com.vinhos.Component;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Entity.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

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

    public Cliente clienteMaiorCompra(TreeMap<Double, Cliente> mapClientes){
        List<Cliente> clientes = new ArrayList<>(mapClientes.values());
        Collections.reverse(clientes);
        return clientes.get(0);
    }
}
