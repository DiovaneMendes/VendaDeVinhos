package br.com.vinhos.Controller;

import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Repository.HistoricoRepository;
import br.com.vinhos.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1/cliente")
public class PesquisaController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private HistoricoRepository historicoRepository;

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

    @GetMapping("/h")
    @ResponseBody
    public List<Historico> todosH(){
        clienteService.popularBanco();

        return (List<Historico>) historicoRepository.findAll();
    }
}
