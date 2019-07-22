package br.com.vinhos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
