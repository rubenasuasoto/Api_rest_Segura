package com.example.Api_rest_Segura.repository

import com.example.Api_rest_Segura.model.Cita_Taller
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface Citas_TallerRepository: JpaRepository<Cita_Taller, Long> {

}
