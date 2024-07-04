package me.ghisiluizgustavo.testewswork.service;

import me.ghisiluizgustavo.testewswork.dto.CarroDTO;
import me.ghisiluizgustavo.testewswork.entidade.Carro;
import me.ghisiluizgustavo.testewswork.entidade.Modelo;
import me.ghisiluizgustavo.testewswork.repositorio.CarroRepository;
import me.ghisiluizgustavo.testewswork.repositorio.ModeloRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;
    private final ModeloRepository modeloRepository;

    public CarroService(CarroRepository carroRepository, ModeloRepository modeloRepository) {
        this.carroRepository = carroRepository;
        this.modeloRepository = modeloRepository;
    }

    public Page<CarroDTO> buscar(Pageable pageable){
        return this.carroRepository.findAll(pageable).map(CarroDTO::fromEntity);
    }

    public Optional<CarroDTO> buscarPorId(Integer id) {
        return carroRepository.findById(id).map(CarroDTO::fromEntity);
    }

    public CarroDTO criar(CarroDTO carroDTO) {
        Modelo modelo = buscarModelo(carroDTO.modeloId());
        Carro save = carroRepository.save(carroDTO.toEntity(modelo));
        return CarroDTO.fromEntity(save);
    }

    public Optional<CarroDTO> atualizar(Integer id, CarroDTO carroDTO) {
        Modelo modelo = buscarModelo(carroDTO.modeloId());

        return carroRepository.findById(id).map(carro -> {
            carro = carroDTO.toEntity(modelo);
            Carro save = carroRepository.save(carro);
            return CarroDTO.fromEntity(save);
        });
    }

    public boolean deletar(Integer id) {
        return carroRepository.findById(id).map(carro -> {
            carroRepository.delete(carro);
            return true;
        }).orElse(false);
    }

    private Modelo buscarModelo(Integer id){
        return modeloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Modelo não encontrado para o ID: " + id));
    }
}