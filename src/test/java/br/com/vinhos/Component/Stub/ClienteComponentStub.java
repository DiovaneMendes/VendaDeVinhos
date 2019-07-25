package br.com.vinhos.Component.Stub;

import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;

public class ClienteComponentStub {

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
}
