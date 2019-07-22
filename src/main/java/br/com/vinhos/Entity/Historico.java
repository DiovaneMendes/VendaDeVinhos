package br.com.vinhos.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "historico")
    private List<Item> itens = new ArrayList<>();

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

}
