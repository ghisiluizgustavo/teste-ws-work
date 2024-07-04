package me.ghisiluizgustavo.testewswork.controller

import me.ghisiluizgustavo.testewswork.dto.CarroDTO
import me.ghisiluizgustavo.testewswork.service.CarroService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carros")
class CarroController(private val service: CarroService) {

    @GetMapping
    fun buscarCarros(pageable: Pageable): Page<CarroDTO> = service.buscar(pageable)

    @GetMapping("/{id}")
    fun buscarCarroPorId(@PathVariable id: Int): ResponseEntity<CarroDTO> {
        return service.buscarPorId(id).map { carro ->
            ResponseEntity.ok(carro)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun criarCarro(@RequestBody carroDTO: CarroDTO): ResponseEntity<CarroDTO> {
        val novoCarro = service.criar(carroDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro)
    }

    @PutMapping("/{id}")
    fun atualizarCarro(@PathVariable id: Int, @RequestBody carroDTO: CarroDTO): ResponseEntity<CarroDTO> {
        return service.atualizar(id, carroDTO).map { carroAtualizado ->
            ResponseEntity.ok(carroAtualizado)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deletarCarro(@PathVariable id: Int): ResponseEntity<Void> {
        return if (service.deletar(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}