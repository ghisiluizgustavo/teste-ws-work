package me.ghisiluizgustavo.testewswork.service;

import me.ghisiluizgustavo.testewswork.dto.ModeloDTO;
import me.ghisiluizgustavo.testewswork.entidade.Marca;
import me.ghisiluizgustavo.testewswork.entidade.Modelo;
import me.ghisiluizgustavo.testewswork.repositorio.MarcaRepository;
import me.ghisiluizgustavo.testewswork.repositorio.ModeloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    public ModeloService(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    public Page<ModeloDTO> buscar(Pageable pageable){
        return this.modeloRepository.findAll(pageable).map(ModeloDTO::fromEntity);
    }

    public Optional<ModeloDTO> buscarPorId(Integer id) {
        return modeloRepository.findById(id).map(ModeloDTO::fromEntity);
    }

    public ModeloDTO criar(ModeloDTO modeloDTO) {
        Marca marca = buscarMarca(modeloDTO.idMarca());
        Modelo save = modeloRepository.save(modeloDTO.toEntity(marca));
        return ModeloDTO.fromEntity(save);
    }

    public Optional<ModeloDTO> atualizar(Integer id, ModeloDTO modeloDTO) {
        Marca marca = buscarMarca(modeloDTO.idMarca());

        return modeloRepository.findById(id).map(modelo -> {
            modelo = modeloDTO.toEntity(marca);
            Modelo save = modeloRepository.save(modelo);
            return ModeloDTO.fromEntity(save);
        });
    }

    public boolean deletar(Integer id) {
        return modeloRepository.findById(id).map(modelo -> {
            modeloRepository.delete(modelo);
            return true;
        }).orElse(false);
    }

    private Marca buscarMarca(Integer id){
        return marcaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Marca não encontrada para o ID: " + id));
    }
}