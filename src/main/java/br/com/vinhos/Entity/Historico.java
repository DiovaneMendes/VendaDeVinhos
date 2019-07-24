package br.com.vinhos.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HISTORICOS")
public class Historico {

    @Id
    @GeneratedValue(generator = "HISTORICO_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DATA")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @ManyToOne
    private Cliente cliente;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historico")
    private List<Item> itens = new ArrayList<>();

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

}
