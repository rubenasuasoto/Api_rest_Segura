package com.example.Api_rest_Segura.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "citas_taller")
data class Cita_Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCita: Long? = null,


    @JoinColumn(name = "id_usuario", nullable = false)
    val usuario:  Long? = null,


    @JoinColumn(name = "id_taller", nullable = false)
    val taller:  Long? = null,

    @Column(nullable = false)
    var fecha: LocalDateTime,

    @Column(nullable = false)
    var servicio: String? = null,

    @Column(nullable = false)
    var estado: String? = null
)
