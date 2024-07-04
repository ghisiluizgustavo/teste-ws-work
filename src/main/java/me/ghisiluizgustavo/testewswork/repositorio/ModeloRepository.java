package me.ghisiluizgustavo.testewswork.repositorio;

import me.ghisiluizgustavo.testewswork.entidade.Modelo;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {

    @NotNull
    Page<Modelo> findAll(@NotNull Pageable pageable);
}
