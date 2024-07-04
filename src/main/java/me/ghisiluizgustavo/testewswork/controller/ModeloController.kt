package me.ghisiluizgustavo.testewswork.controller

import me.ghisiluizgustavo.testewswork.dto.ModeloDTO
import me.ghisiluizgustavo.testewswork.service.ModeloService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/modelos")
class ModeloController(private val service: ModeloService) {

    @GetMapping
    fun buscarModelos(pageable: Pageable): Page<ModeloDTO> = service.buscar(pageable)

    @GetMapping("/{id}")
    fun buscarModeloPorId(@PathVariable id: Int): ResponseEntity<ModeloDTO> {
        return service.buscarPorId(id).map { modelo ->
            ResponseEntity.ok(modelo)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun criarModelo(@RequestBody modeloDTO: ModeloDTO): ResponseEntity<ModeloDTO> {
        val novoModelo = service.criar(modeloDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo)
    }

    @PutMapping("/{id}")
    fun atualizarModelo(@PathVariable id: Int, @RequestBody modeloDTO: ModeloDTO): ResponseEntity<ModeloDTO> {
        return service.atualizar(id, modeloDTO).map { modeloAtualizado ->
            ResponseEntity.ok(modeloAtualizado)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deletarModelo(@PathVariable id: Int): ResponseEntity<Void> {
        return if (service.deletar(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}