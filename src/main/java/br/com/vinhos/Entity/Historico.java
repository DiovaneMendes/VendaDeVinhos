package br.com.vinhos.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historico {

    private String codigo;
    private LocalDate data;
    private Cliente cliente;
    private List<Item> itens;
    private Double valorTotal;

}
