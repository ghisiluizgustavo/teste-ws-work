package me.ghisiluizgustavo.testewswork.controller

import me.ghisiluizgustavo.testewswork.dto.MarcaDTO
import me.ghisiluizgustavo.testewswork.service.MarcaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/marcas")
class MarcaController(private val service: MarcaService) {

    @GetMapping
    fun buscarMarcas(pageable: Pageable): Page<MarcaDTO> = service.buscar(pageable)

    @GetMapping("/{id}")
    fun buscarMarcaPorId(@PathVariable id: Int): ResponseEntity<MarcaDTO> {
        return service.buscarPorId(id).map {
            marca -> ResponseEntity.ok(marca)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun criarMarca(@RequestBody marcaDTO: MarcaDTO): ResponseEntity<MarcaDTO> {
        val novaMarca = service.criar(marcaDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca)
    }

    @PutMapping("/{id}")
    fun atualizarMarca(@PathVariable id: Int, @RequestBody marcaDTO: MarcaDTO): ResponseEntity<MarcaDTO> {
        return service.atualizar(id, marcaDTO).map {
            marcaAtualizada -> ResponseEntity.ok(marcaAtualizada)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deletarMarca(@PathVariable id: Int): ResponseEntity<Void> {
        return if (service.deletar(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}