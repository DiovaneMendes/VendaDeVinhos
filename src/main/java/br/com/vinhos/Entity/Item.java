package br.com.vinhos.Entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ITENS")
public class Item {

    @Id
    @GeneratedValue(generator = "ITEM_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "PRODUTO")
    private String produto;

    @Column(name = "VARIEDADE")
    private String variedade;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "SAFRA")
    private String safra;

    @Column(name = "PRECO")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "ID_HISTORICO")
    private Historico historico;

}
