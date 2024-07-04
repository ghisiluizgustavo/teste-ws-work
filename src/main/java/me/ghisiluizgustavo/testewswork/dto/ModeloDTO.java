package me.ghisiluizgustavo.testewswork.dto;

import me.ghisiluizgustavo.testewswork.entidade.Marca;
import me.ghisiluizgustavo.testewswork.entidade.Modelo;

import java.math.BigDecimal;

public record ModeloDTO(
        Integer id,
        String nome,
        BigDecimal valorFipe,
        Integer idMarca
) {

    public static ModeloDTO fromEntity(Modelo modelo) {
        return new ModeloDTO(
                modelo.getId(),
                modelo.getNome(),
                modelo.getValorFipe(),
                modelo.getMarca().getId()
        );
    }

    public Modelo toEntity(Marca marca) {
        return new Modelo(id, nome, valorFipe, marca);
    }

}
