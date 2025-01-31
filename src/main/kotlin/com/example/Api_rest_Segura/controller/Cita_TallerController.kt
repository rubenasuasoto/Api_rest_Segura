package com.example.Api_rest_Segura.controller

import com.example.Api_rest_Segura.model.Cita_Taller
import com.example.Api_rest_Segura.service.CitaTallerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/citas")
class CitaTallerController {

    @Autowired
    private lateinit var citaTallerService: CitaTallerService

    /**
     * Endpoint para registrar una nueva cita
     */
    @PostMapping("/register")
    fun registrarCita(@RequestBody citaTaller: Cita_Taller): ResponseEntity<Cita_Taller> {
        val nuevaCita = citaTallerService.registrarCita(citaTaller)
        return ResponseEntity.status(201).body(nuevaCita)
    }

    /**
     * Endpoint para obtener todas las citas
     */
    @GetMapping("/T")
    fun obtenerCitas(): ResponseEntity<List<Cita_Taller>> {
        val cita = citaTallerService.obtenerTodasLasCitas()
        return ResponseEntity.ok(cita)
    }

    /**
     * Endpoint para obtener una cita por ID
     */
    @GetMapping("/{id}")
    fun obtenerCitaPorId(@PathVariable id: Long): ResponseEntity<Cita_Taller> {
        val cita = citaTallerService.obtenerCitaPorId(id)
        return ResponseEntity.ok(cita)
    }

    /**
     * Endpoint para actualizar una cita por ID
     */
    @PutMapping("/update/{id}")
    fun actualizarCita(
        @PathVariable id: Long,
        @RequestBody citaActualizada: Cita_Taller
    ): ResponseEntity<Cita_Taller> {
        val cita = citaTallerService.actualizarCita(id, citaActualizada)
        return ResponseEntity.ok(cita)
    }

    /**
     * Endpoint para eliminar una cita por ID
     */
    @DeleteMapping("/delete/{id}")
    fun eliminarCita(@PathVariable id: Long): ResponseEntity<Void> {
        citaTallerService.eliminarCita(id)
        return ResponseEntity.noContent().build()
    }
}
