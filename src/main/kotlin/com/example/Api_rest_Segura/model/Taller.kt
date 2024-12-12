package com.example.Api_rest_Segura.model

import jakarta.persistence.*

@Entity
@Table(name = "talleres")
data class Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idTaller: Long? = null,

    @Column(nullable = false)
    val nombreTaller: String? = null,

    @Column(nullable = false)
    val direccion: String? = null,

    @Column(nullable = false)
    val telefono: String? = null,

    @Column
    val especialidades: String? = null
)