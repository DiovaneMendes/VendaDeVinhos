import br.com.vinhos.Component.RequestAPI;
import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Factory.ClienteFactory;
import br.com.vinhos.Factory.HistoricoFactory;
import br.com.vinhos.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Spike {

    @Autowired
    private static ClienteRepository clienteRepository;

    public static void main(String[] args) {
        aaa();

    }

    public static void aaa(){
        List<HistoricoDTO> historicoDTOS = RequestAPI.historico();
        List<ClienteDTO> clienteDTOS = RequestAPI.cliente();


        for (ClienteDTO clienteDTO: clienteDTOS){
            List<Historico> historicosCliente = historicoDTOS.stream()
                    .filter(historicoDTO -> historicoDTO.getCliente().equals( clienteDTO.getCpf().replace('-', '.') ) )
                    .map(HistoricoFactory::getHistorico)
                    .collect(toList());
            System.out.println("==========================================================");

            historicosCliente.forEach(System.out::println);

            System.out.println("==========================================================");
            Cliente cliente = ClienteFactory.getCliente(clienteDTO);
            cliente.setHistoricos(historicosCliente);

            clienteRepository.save(new Cliente());
        }
    }
}
