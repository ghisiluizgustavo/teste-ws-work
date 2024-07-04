package me.ghisiluizgustavo.testewswork.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "carro")
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "data_cadastro")
    private Instant dataCadastro;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "combustivel", length = 50)
    private String combustivel;

    @Column(name = "num_portas")
    private Integer numPortas;

    @Column(name = "cor", length = 50)
    private String cor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id")
    @JsonIgnore
    private Modelo modelo;

}