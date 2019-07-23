package br.com.vinhos.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private String safra;
    private Double preco;

}
