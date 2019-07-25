package br.com.vinhos.Component;

import br.com.vinhos.Component.Stub.ClienteComponentStub;
import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteComponentTest {

    private ClienteComponent clienteComponent;
    private ClienteComponentStub clienteComponentStub;

    @Before
    public void init(){
        clienteComponent = new ClienteComponent();
        clienteComponentStub = new ClienteComponentStub();
    }

    @Test
    public void deveValidarTrueSeHistoricoForDoCliente(){
        HistoricoDTO historicoDTO = clienteComponentStub.mockHistoricoDTO();
        ClienteDTO clienteDTO = clienteComponentStub.mockClienteDTO();

        boolean resultado = clienteComponent.validadorHistorico(historicoDTO, clienteDTO);

        assertTrue(resultado);
    }

    @Test
    public void deveValidarFalseSeHistoricoNãoForDoCliente(){
        HistoricoDTO historicoDTO = clienteComponentStub.mockHistoricoDTO();
        ClienteDTO clienteDTO = clienteComponentStub.mockClienteDTO();

        historicoDTO.setCliente("0334.000.100.02");

        boolean resultado = clienteComponent.validadorHistorico(historicoDTO, clienteDTO);

        assertFalse(resultado);
    }

    @Test
    public void deveFormatarCPFqueTenhamTracoAoInvesDePonto(){
        String cpfTeste = "0334.000.100-02";

        String resultado = clienteComponent.formatadorCpf(cpfTeste);

        assertEquals(resultado, "0334.000.100.02");
    }
}
