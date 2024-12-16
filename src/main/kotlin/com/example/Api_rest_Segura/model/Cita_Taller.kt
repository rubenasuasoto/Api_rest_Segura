package com.example.Api_rest_Segura.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "citas_Taller")
data class Cita_Taller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCita: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    val usuario: Usuario,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller", nullable = false)
    val taller: Taller,

    @Column(nullable = false)
    var fecha: LocalDateTime,

    @Column(nullable = false)
    var servicio: String? = null,

    @Column(nullable = false)
    var estado: String? = null
)

