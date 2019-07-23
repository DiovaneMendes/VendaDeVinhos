package br.com.vinhos.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoDTO {

    private String codigo;
    private String data;
    private String cliente;
    private List<ItemDTO> itens;
    private Double valorTotal;

}
