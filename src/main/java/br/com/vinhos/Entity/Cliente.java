package br.com.vinhos.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;

    @Builder.Default
    @OneToMany(cascade = ALL, mappedBy = "cliente")
    private List<Historico> historicos = new ArrayList<>();

}
