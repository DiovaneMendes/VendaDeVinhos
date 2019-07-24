package br.com.vinhos.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "HISTORICOS")
public class Historico {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DATA")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @Builder.Default
    @OneToMany(cascade = ALL, mappedBy = "historico")
    private List<Item> itens = new ArrayList<>();

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

}
