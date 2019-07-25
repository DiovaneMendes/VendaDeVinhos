package br.com.vinhos.Controller;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Item;
import br.com.vinhos.Factory.ClienteFactory;
import br.com.vinhos.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/v1/cliente")
public class PesquisaController {

    private ClienteService clienteService;

    @GetMapping("/todos")
    @ResponseBody
    public List<ClienteDTO> todos(){
        clienteService.popularBanco();

        return ClienteFactory.getListClienteDTO( clienteService.todos() );
    }

    @GetMapping("/ordenados")
    @ResponseBody
    public List<ClienteDTO> ordenados(){
        clienteService.popularBanco();

        return ClienteFactory.getListClienteDTO( clienteService.ordenadoMaiorValorTotal() );
    }

    @GetMapping("/maior_compra")
    @ResponseBody
    public ClienteDTO maiorCompra(){
        Cliente cliente = clienteService.maiorCompraUnicaDoisMilEDezesseis();
        return ClienteFactory.getCliente(cliente);
    }

    @GetMapping("/mais_fieis")
    @ResponseBody
    public List<ClienteDTO> maisFieis(){
        clienteService.popularBanco();

        return ClienteFactory.getListClienteDTO( clienteService.clientesMaisFieis() );
    }

    @GetMapping("/{id}/recomendacao")
    @ResponseBody
    public Item recomendacao(@PathVariable Long id){
        clienteService.popularBanco();

        return clienteService.recomendacaoVinho(id);
    }
}
