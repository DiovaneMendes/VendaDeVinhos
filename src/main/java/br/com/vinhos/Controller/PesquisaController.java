package br.com.vinhos.Controller;

import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Item;
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
    public List<Cliente> todos(){
        clienteService.popularBanco();

        return clienteService.todos();
    }

    @GetMapping("/ordenados")
    @ResponseBody
    public List<Cliente> ordenados(){
        clienteService.popularBanco();

        return clienteService.ordenadoMaiorValorTotal();
    }

    @GetMapping("/maior_compra")
    @ResponseBody
    public Cliente maiorCompra(){
        return clienteService.maiorCompraUnicaDoisMilEDezesseis();
    }

    @GetMapping("/mais_fieis")
    @ResponseBody
    public List<Cliente> maisFieis(){
        clienteService.popularBanco();

        return clienteService.clientesMaisFieis();
    }
}
