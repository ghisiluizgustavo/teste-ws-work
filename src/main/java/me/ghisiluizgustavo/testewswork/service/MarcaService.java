package me.ghisiluizgustavo.testewswork.service;

import me.ghisiluizgustavo.testewswork.dto.MarcaDTO;
import me.ghisiluizgustavo.testewswork.entidade.Marca;
import me.ghisiluizgustavo.testewswork.repositorio.MarcaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public Page<MarcaDTO> buscar(Pageable pageable){
        return this.repository.findAll(pageable).map(MarcaDTO::fromEntity);
    }

    public Optional<MarcaDTO> buscarPorId(Integer id) {
        return repository.findById(id).map(MarcaDTO::fromEntity);
    }

    public MarcaDTO criar(MarcaDTO marcaDTO) {
        Marca novaMarca = new Marca();
        novaMarca.setNome(marcaDTO.nome());
        Marca save = repository.save(novaMarca);
        return MarcaDTO.fromEntity(save);
    }

    public Optional<MarcaDTO> atualizar(Integer id, MarcaDTO marcaDTO) {
        return repository.findById(id).map(marca -> {
            marca.setNome(marcaDTO.nome());
            Marca save = repository.save(marca);
            return MarcaDTO.fromEntity(save);
        });
    }

    public boolean deletar(Integer id) {
        return repository.findById(id).map(marca -> {
            repository.delete(marca);
            return true;
        }).orElse(false);
    }
}