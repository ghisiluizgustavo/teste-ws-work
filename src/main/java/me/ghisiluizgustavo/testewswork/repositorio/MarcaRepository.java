package me.ghisiluizgustavo.testewswork.repositorio;

import me.ghisiluizgustavo.testewswork.entidade.Marca;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    @NotNull
    Page<Marca> findAll(@NotNull Pageable pageable);
}
