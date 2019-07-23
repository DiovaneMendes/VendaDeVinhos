package br.com.vinhos.Entity;

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
    private LocalDate data;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @Builder.Default
    @OneToMany(mappedBy = "historico")
    private List<Item> itens = new ArrayList<>();

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

}
