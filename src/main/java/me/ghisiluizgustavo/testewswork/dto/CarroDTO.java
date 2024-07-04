package me.ghisiluizgustavo.testewswork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.ghisiluizgustavo.testewswork.entidade.Carro;
import me.ghisiluizgustavo.testewswork.entidade.Modelo;

import java.math.BigDecimal;
import java.time.Instant;

public record CarroDTO(
        Integer id,
        Instant dataCadastro,
        Integer ano,
        String combustivel,
        Integer numPortas,
        String cor,
        Integer modeloId
) {
    public static CarroDTO fromEntity(Carro carro) {
        return new CarroDTO(
                carro.getId(),
                carro.getDataCadastro(),
                carro.getAno(),
                carro.getCombustivel(),
                carro.getNumPortas(),
                carro.getCor(),
                carro.getModelo().getId()
        );
    }

    public Carro toEntity(Modelo modelo) {
        return new Carro(id, dataCadastro, ano, combustivel, numPortas, cor, modelo);
    }
}