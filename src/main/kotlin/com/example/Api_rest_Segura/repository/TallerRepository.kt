package com.example.Api_rest_Segura.repository

import com.example.Api_rest_Segura.model.Taller
import com.example.Api_rest_Segura.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TallerRepository: JpaRepository<Taller, Long> {

    fun findByNombreTaller(nombreTaller: String?): Optional<Taller>
}
