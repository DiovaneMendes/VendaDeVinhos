package br.com.vinhos.Component;

import br.com.vinhos.Component.Stub.ClienteComponentMock;
import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import br.com.vinhos.Entity.Cliente;
import br.com.vinhos.Entity.Historico;
import br.com.vinhos.Entity.Item;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteComponentTest {

    private ClienteComponent clienteComponent;
    private ClienteComponentMock clienteComponentMock;

    @Before
    public void init(){
        clienteComponent = new ClienteComponent();
        clienteComponentMock = new ClienteComponentMock();
    }

    @Test
    public void deveValidarTrueSeHistoricoForDoCliente(){
        HistoricoDTO historicoDTO = clienteComponentMock.mockHistoricoDTO();
        ClienteDTO clienteDTO = clienteComponentMock.mockClienteDTO();

        boolean resultado = clienteComponent.validadorHistorico(historicoDTO, clienteDTO);

        assertTrue(resultado);
    }

    @Test
    public void deveValidarFalseSeHistoricoNãoForDoCliente(){
        HistoricoDTO historicoDTO = clienteComponentMock.mockHistoricoDTO();
        ClienteDTO clienteDTO = clienteComponentMock.mockClienteDTO();

        historicoDTO.setCliente("0334.000.100.02");

        boolean resultado = clienteComponent.validadorHistorico(historicoDTO, clienteDTO);

        assertFalse(resultado);
    }

    @Test
    public void deveFormatarCPFqueTenhamTracoAoInvesDePonto(){
        String cpfTeste = "0334.000.100-02";

        String resultado = clienteComponent.formatadorCpf(cpfTeste);

        assertEquals("0334.000.100.02", resultado);
    }

    @Test
    public void deveRetornarListaDeItensComAtribuicaoDoHistoricoApartirDeHistoricoPassado(){
        List<Item> itensEsperado = clienteComponentMock.mockListaItensComHistorico();

        Historico historico = clienteComponentMock.mockHistorico();

        List<Item> itensResultado = clienteComponent.setHistoricoNoItem(historico);

//        assertEquals(itensResultado, itensEsperado);
    }

    @Test
    public void deveSomarValoresTotaisDeTodosHistoricosDoCliente(){
        Cliente cliente = clienteComponentMock.mockCliente();

        Double resultado = clienteComponent.calculoValoresTotais(cliente);

        assertEquals(1186.03, resultado,1);
    }

    @Test
    public void deveRetornarValorTotalMaiorCompraUnicaDe2016DeUmCliente(){
        Cliente cliente = clienteComponentMock.mockCliente();

        Double resultado = clienteComponent.verificaMaiorCompraUnica(cliente);

        assertEquals(264.75, resultado, 1);
    }

    @Test
    public void deveRetornarZeroCasoNaoHajaValoresDe2016DoCliente(){
        Cliente cliente = clienteComponentMock.mockCliente();

        cliente.getHistoricos().get(1).setData(LocalDate.now());
        cliente.getHistoricos().get(2).setData(LocalDate.now());

        Double resultado = clienteComponent.verificaMaiorCompraUnica(cliente);

        assertEquals(0, resultado, 1);
    }
}
