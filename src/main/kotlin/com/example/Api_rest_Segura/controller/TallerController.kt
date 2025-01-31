package com.example.Api_rest_Segura.controller

import com.example.Api_rest_Segura.model.Taller
import com.example.Api_rest_Segura.service.TallerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/talleres")
class TallerController {

    @Autowired
    private lateinit var tallerService: TallerService

    /**
     * Endpoint para registrar un nuevo taller
     */
    @PostMapping("/register")
    fun registrarTaller(@RequestBody taller: Taller): ResponseEntity<Taller> {
        val nuevoTaller = tallerService.registrarTaller(taller)
        return ResponseEntity.status(201).body(nuevoTaller)
    }
    /**
     * Endpoint para obtener todos los talleres
     */
    @GetMapping
    fun obtenerTalleres(): ResponseEntity<List<Taller>> {
        val taller = tallerService.obtenerTodosLosTalleres()
        return ResponseEntity.ok(taller)
    }

    /**
     * Endpoint para obtener un taller por Nombre
     */
    @GetMapping("/{nombreTaller}")
    fun obtenerTallerPorNombre(@PathVariable nombreTaller: String): ResponseEntity<Taller> {
        val taller = tallerService.obtenerTallerPorNombre(nombreTaller)
        return ResponseEntity.ok(taller)
    }

    /**
     * Endpoint para actualizar un taller por ID
     */
    @PutMapping("/{id}")
    fun actualizarTaller(
        @PathVariable id: Long,
        @RequestBody tallerActualizado: Taller
    ): ResponseEntity<Taller> {
        val taller = tallerService.actualizarTaller(id, tallerActualizado)
        return ResponseEntity.ok(taller)
    }

    /**
     * Endpoint para eliminar un taller por ID
     */
    @DeleteMapping("/{id}")
    fun eliminarTaller(@PathVariable id: Long): ResponseEntity<Void> {
        tallerService.eliminarTaller(id)
        return ResponseEntity.noContent().build()
    }
}
