package com.example.Api_rest_Segura.service

import com.example.Api_rest_Segura.error.exception.NotFoundException
import com.example.Api_rest_Segura.model.Cita_Taller
import com.example.Api_rest_Segura.repository.Citas_TallerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CitaTallerService {

    @Autowired
    private lateinit var citaTallerRepository: Citas_TallerRepository

    /**
     * Registrar una nueva cita.
     */
    fun registrarCita(citaTaller: Cita_Taller): Cita_Taller {
        return citaTallerRepository.save(citaTaller)
    }

    /**
     * Obtener todas las citas.
     */
    fun obtenerTodasLasCitas(): List<Cita_Taller> {
        return citaTallerRepository.findAll()
    }

    /**
     * Obtener una cita por ID.
     */
    fun obtenerCitaPorId(id: Long): Cita_Taller {
        return citaTallerRepository.findById(id)
            .orElseThrow { NotFoundException("Cita no encontrada con ID $id") }
    }

    /**
     * Actualizar una cita existente.
     */
    fun actualizarCita(id: Long, citaActualizada: Cita_Taller): Cita_Taller {
        val cita = obtenerCitaPorId(id)

        // Actualizar campos
        cita.fecha = citaActualizada.fecha
        cita.servicio = citaActualizada.servicio
        cita.estado = citaActualizada.estado

        return citaTallerRepository.save(cita)
    }

    /**
     * Eliminar una cita por ID.
     */
    fun eliminarCita(id: Long) {
        if (!citaTallerRepository.existsById(id)) {
            throw NotFoundException("Cita no encontrada con ID $id")
        }
        citaTallerRepository.deleteById(id)
    }
}
