package me.ghisiluizgustavo.testewswork.repositorio;

import me.ghisiluizgustavo.testewswork.entidade.Carro;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    @NotNull
    Page<Carro> findAll(@NotNull Pageable pageable);
}
