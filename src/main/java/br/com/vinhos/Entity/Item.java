package br.com.vinhos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ITENS")
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    @JsonIgnore
    @ManyToOne
    private Historico historico;

}
