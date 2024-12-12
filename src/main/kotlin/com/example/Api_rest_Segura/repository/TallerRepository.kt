package com.example.Api_rest_Segura.repository

import com.example.Api_rest_Segura.model.Taller
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TallerRepository: JpaRepository<Taller, Long> {

}