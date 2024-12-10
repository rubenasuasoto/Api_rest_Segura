package com.example.Api_rest_Segura.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Citas_Taller")
data class CitaTaller(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCita: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    val usuario: Usuario,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_taller", nullable = false)
    val taller: Taller,

    @Column(nullable = false)
    val fecha: LocalDateTime,

    @Column(nullable = false)
    val servicio: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val estado: EstadoCita
)

enum class EstadoCita {
    PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA
}