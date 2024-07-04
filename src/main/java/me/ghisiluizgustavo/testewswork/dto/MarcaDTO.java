package me.ghisiluizgustavo.testewswork.dto;

import me.ghisiluizgustavo.testewswork.entidade.Marca;

public record MarcaDTO(
        Integer id,
        String nome
) {
    public static MarcaDTO fromEntity(Marca marca) {
        return new MarcaDTO(
                marca.getId(),
                marca.getNome()
        );
    }
}
