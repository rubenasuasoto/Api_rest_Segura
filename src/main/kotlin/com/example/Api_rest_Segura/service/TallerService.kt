package com.example.Api_rest_Segura.service

import com.example.Api_rest_Segura.error.APIExceptionHandler
import com.example.Api_rest_Segura.error.exception.ConflictException
import com.example.Api_rest_Segura.error.exception.NotFoundException
import com.example.Api_rest_Segura.model.Taller
import com.example.Api_rest_Segura.repository.TallerRepository
import com.example.Api_rest_Segura.security.SecurityConfig
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TallerService {

    @Autowired
    private lateinit var tallerRepository: TallerRepository




    /**
     * Registrar un nuevo taller.
     */
    fun registrarTaller(taller: Taller): Taller {
        if (tallerRepository.findByNombreTaller(taller.nombreTaller).isPresent) {
            throw  ConflictException("El taller ya existe")
        }

        return tallerRepository.save(taller)
    }

    /**
     * Obtener todos los talleres.
     */
    fun obtenerTodosLosTalleres(): List<Taller> {
        return tallerRepository.findAll()
    }

    /**
     * Obtener un taller por ID.
     */
    fun obtenerTallerPorId(id: Long): Taller {
        return tallerRepository.findById(id)
            .orElseThrow { NotFoundException("Taller no encontrado con ID $id") }
    }
    /**
     * Obtener un taller por Nombre.
     */
    fun obtenerTallerPorNombre(nombreTalller: String): Taller {
        return tallerRepository.findByNombreTaller(nombreTalller)
            .orElseThrow { NotFoundException("Taller no encontrado con nombre $nombreTalller") }
    }

    /**
     * Actualizar un taller existente.
     */
    fun actualizarTaller(id: Long, tallerActualizado: Taller): Taller {
        val taller = obtenerTallerPorId(id)

        // Actualizar campos
        taller.nombreTaller = tallerActualizado.nombreTaller
        taller.direccion = tallerActualizado.direccion
        taller.telefono = tallerActualizado.telefono


        // Guardar cambios
        return tallerRepository.save(taller)
    }

    /**
     * Eliminar un taller por ID.
     */
    fun eliminarTaller(id: Long) {
        if (!tallerRepository.existsById(id)) {
            throw NotFoundException("Taller no encontrado con ID $id")
        }
        tallerRepository.deleteById(id)
    }
}
