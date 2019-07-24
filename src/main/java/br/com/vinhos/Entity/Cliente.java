package br.com.vinhos.Entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(generator = "CLIENTE_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Historico> historicos = new ArrayList<>();

}
