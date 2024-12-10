package com.example.Api_rest_Segura.model

import jakarta.persistence.*

@Entity
@Table(name = "Talleres")
data class Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTaller: Long = 0,

    @Column(nullable = false)
    val nombreTaller: String,

    @Column(nullable = false)
    val direccion: String,

    @Column(nullable = false)
    val telefono: String,

    @Column
    val especialidades: String? = null
)